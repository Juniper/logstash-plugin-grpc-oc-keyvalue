/*   Copyright 2018 Juniper Networks

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
import io.grpc.StatusRuntimeException;
import telemetry.Oc;
import telemetry.OpenConfigTelemetryGrpc;
import io.grpc.ManagedChannel;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

class FindFile 
{
    public String findFile(String name,File file)
    {
        File[] list = file.listFiles();
        String filePath = "";
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                filePath = findFile(name,fil);
		if(filePath!="")
			break;
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
		return fil.getAbsolutePath();
            }
        }
	return filePath;
    }
}


public class OpenConfigTelemetryGrpcClient implements Runnable {

    private final ManagedChannel channel;
    String device;
    private final LinkedHashMap<String,LinkedHashMap<String,Object>> tr_record;//shared object
    String sensor;
    int frequency;
    Object queue;
    OpenConfigTelemetryGrpc.OpenConfigTelemetryBlockingStub stub;
    public OpenConfigTelemetryGrpcClient(String sensor,LinkedHashMap<String,LinkedHashMap<String,Object>> tr_record,ManagedChannel channel,OpenConfigTelemetryGrpc.OpenConfigTelemetryBlockingStub stub,String device, Object queue, String measurement_name, int frequency)
    {
        this.channel=channel;
        this.tr_record=tr_record;
        this.sensor = sensor;
        this.stub = stub;
        this.device = device;
	this.queue = queue;
        this.frequency = frequency;
    }
    public void run() 
    {
        Oc.Path path = Oc.Path.newBuilder().setPath(sensor)
                .setSuppressUnchanged(true)
                .setSampleFrequency(frequency)
                .build();

        Oc.SubscriptionRequest request=Oc.SubscriptionRequest.newBuilder()
                .addPathList(path)
                .build();

        Iterator<Oc.OpenConfigData> response ;
	while(true){
		try{
		    ScriptEngine jruby = new ScriptEngineManager().getEngineByName("jruby");
		    String name = "openconfig.rb";
		    FindFile ff = new FindFile();
		    String directory = System.getProperty("user.dir");
		    String oc_path = ff.findFile(name,new File(directory));
		    if(oc_path == ""){
			System.out.println("Error!! File openconfig.rb not found in plugin package. Aborting!!");
	 	    }	    
		    URL url = new File(oc_path).toURI().toURL();
		    File f = new File(url.getPath());
		    jruby.eval(new BufferedReader(new FileReader(f)));
	            response=stub.telemetrySubscribe(request);
	            //INFO:stream of data packets
		    int sequence = 0;
		    while(response.hasNext()){
	                Oc.OpenConfigData data = response.next();
	
	                //INFO:all the information contained within each packet
	                ArrayList<Oc.KeyValue> kv=new ArrayList<>(data.getKvList());
	
	                LinkedHashMap<String,Object> record= new LinkedHashMap<>();
	                Object prefix="";
	                //1.send basic info to the logs
	                //INFO:get all the key value pairs into a hash "record"
	                for(int i=0;i<kv.size();i++) {
			    //System.out.println("Inside for");
	                    int number = kv.get(i).getValueCase().getNumber();
	                    String key = kv.get(i).getKey();
	                    Object value = getDataListValue(number, kv, i);
	                    if (key.equals("__prefix__") && value.toString() != "")
	                        prefix = value;
			    record.put(prefix+key, value);
	                }
	                transform_record(record,device,sequence,sensor);
	                sequence = sequence + 1;
			Iterator it = tr_record.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair = (Map.Entry)it.next();
				jruby.put("hash", pair.getValue());
				jruby.put("q", queue);
	                	jruby.eval("print_function($hash, $q)");
			}
	
	            }
		    break;
		 }catch(Exception e ){
			System.out.println("Exception raised in OpenConfig: ");
			System.out.println(e);
			System.out.println("Will retry in 10 seconds ...");
			try{
				Thread.sleep(10000);
			}catch(Exception ex){
				System.out.println("Exception raised: " + ex);
				System.out.println("Aborting!!");
			}
			continue;
		}
	}
    }
    synchronized void transform_record(LinkedHashMap<String, Object> record,String device, int sequence, String sensor)
    {
        Pattern pattern;
        Matcher matcher;
        for(Map.Entry<String,Object> key: record.entrySet()){
            String master_key=key.getKey();
            LinkedHashMap<String,Object> h=new LinkedHashMap<>();
            Object value = key.getValue();
            pattern = Pattern.compile("\\s*\\[[^\\]]*\\]\\s*");
            matcher = pattern.matcher(master_key);
            ArrayList<String> splits=new ArrayList<>();
	    ArrayList<String> plugin_record_tags = new ArrayList<String>();
	    plugin_record_tags.add(device);
	    String host = "";
	    try {
         	   InetAddress myHost = InetAddress.getLocalHost();
            	   host = myHost.getHostName();
       	    } catch (UnknownHostException ex) {
        	    ex.printStackTrace();
            }
	    plugin_record_tags.add(host);
            while(matcher.find()){
                splits.add(matcher.group(0));}
            String new_key=master_key;
            String sp_key= String.join(",",splits);
            if(tr_record.containsKey(sp_key))
                h=tr_record.get(sp_key);
            for(int i=0;i<splits.size();i++){
                String split = splits.get(i).substring(1, splits.get(i).length() - 1);
                String[] split_key = new_key.split("\\[" + split + "\\]");
                new_key = String.join("",split_key);
                pattern=Pattern.compile("^\\s*\\[\\s*'*\"*(.*?)\"*'*\\s*=\\s*'*\"*(.*?)\"*'*\\s*\\]\\s*$", Pattern.CASE_INSENSITIVE);
                matcher=pattern.matcher(splits.get(i));
                String sub_key = "", sub_value = "";
                if (matcher.find()) {
                    sub_key = matcher.group(1);
                    sub_value = matcher.group(2);
                }
                //write down condition to check if the key already exists
                sub_key = split_key[0] + "/@" + sub_key;
		plugin_record_tags.add(sub_key);
                h.put(sub_key,sub_value);
            }
            h.put(new_key,value);
            h.put("device",device);
	    h.put("sensor_name", sensor);
	    h.put("_seq", sequence);
	    String plugin_record_tags_str = String.join(",", plugin_record_tags);
	    h.put("plugin_record_tags", plugin_record_tags_str);
            tr_record.put(sp_key,h);
        }
    }
    public static Object getDataListValue(int number,ArrayList<Oc.KeyValue> data_list,int index)
    {
        Object obj=new Object();
        switch(number)
        {
            case 5:{
                obj= data_list.get(index).getDoubleValue();
                break;
            }
            case 6:{
                obj=data_list.get(index).getIntValue();
                break;
            }
            case 7:{
                obj=data_list.get(index).getUintValue();
                break;
            }
            case 8:{
                obj=data_list.get(index).getSintValue();
                break;
            }
            case 9: {
                obj = data_list.get(index).getBoolValue();
                break;
            }
            case 10:{
                obj = data_list.get(index).getStrValue();
                break;
            }
            case 11:{
                obj=data_list.get(index).getBytesValue();
                break;
            }
        }
        return obj;
    }
}
