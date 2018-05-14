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
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import telemetry.OpenConfigTelemetryGrpc;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngineFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ServiceLoader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
//import io.grpc.netty;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import java.io.File;
import java.io.IOException;

/*
public class host_threads implements Runnable {
	String server;
	ArrayList<String> sensors;
	String certFile;
	Object queue;
	public host_threads(String server, ArrayList<String> sensors, String certFile, Object queue){
		this.server = server;
		this.sensors = sensors;
		this.certFile = certFile;
		this.queue = queue;
	}
	public void run(){
		System.out.println("Starting a thread with server: " + server);
		String tmp_array[] = (server.split(":"));
		if (tmp_array.length > 2) {
			System.out.println("Error! Too many : in the host configuration");
		}
		String serverName = tmp_array[0];
		int portNum = Integer.parseInt(tmp_array[1]);
		System.out.println("Server: " + server);
		System.out.println("Port: " + portNum);
		System.out.println("Sensors: " + sensors);
		ManagedChannel channel = ManagedChannelBuilder.forAddress(serverName,portNum)
	                .usePlaintext(true)
	                .build();
	        OpenConfigTelemetryGrpc.OpenConfigTelemetryBlockingStub stub=OpenConfigTelemetryGrpc.newBlockingStub(channel);
		Thread[] threads = new Thread[sensors.size()];//as many threads as there are sensors
	        LinkedHashMap<String, LinkedHashMap<String, Object>> tr_record = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
	        for (int i = 0; i < sensors.size(); i++) {
	            Runnable r = new OpenConfigTelemetryGrpcClient(sensors.get(i), tr_record, channel, stub,serverName,queue);
	            threads[i] = new Thread(r);
	            threads[i].start();
	        }
	        for (int i = 0; i < sensors.size(); i++) {
	            threads[i].join();
	        }
		System.out.println("Reached end of thread");	
	}

}

*/
public class MainThreadClass {
    
    public void invoke(ArrayList<String> server, ArrayList<String> sensors, int port, Object queue, String username, String password, String clientID, String certFile, int sampleFrequency)throws IOException,InterruptedException, ScriptException, FileNotFoundException{
	System.out.println("Starting invoke function");
	Thread[] threads = new Thread[server.size()];
	for (int j=0; j< server.size(); j++){
		System.out.println("Server in invoke: "+ server.get(j));
		Runnable r = new host_threads(server.get(j), sensors, certFile, queue, sampleFrequency, username, password, clientID);
		threads[j] = new Thread(r);
		System.out.println("Invoking a thread start for server: "+ server.get(j));
		threads[j].start();
	/*
		ManagedChannel channel = NettyChannelBuilder.forAddress(serverName, portNum)
    					.sslContext(GrpcSslContexts.forClient().trustManager(new File(certFile)).build())
    					.build();

	 	To create an async stub
		OpenConfigTelemetryGrpc.OpenConfigTelemetryStub stub=OpenConfigTelemetryGrpc.newStub(channel);

	      listScriptingEngines();
		System.setProperty("org.jruby.embed.localvariable.behavior", "transient");
		System.setProperty("org.jruby.embed.localcontext.scope", "singleton");	
		ScriptEngineManager manager = new ScriptEngineManager();
	      ScriptEngine engine = manager.getEngineByName("jruby");
		Reader reader = new FileReader("/b/janishj/logstash/vendor/local_gems/940211cf/logstash-input-openconfig-0.1.0-java/lib/logstash/inputs/openconfig.rb");
	      engine.eval(reader);
		String server = "teakwood";
		ArrayList<String> sensors = new ArrayList<>();
		sensors.add("/components/");
		sensors.add("/interfaces/");
	      System.out.println("Printing in main");
		System.out.println(queue);
		System.out.println(sensors.size());
	*/
	}
	for (int j=0; j<server.size();j++){
		threads[j].join();
	}
	System.out.println("Reached the end of invoke");
    }
    public static void listScriptingEngines() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        for (ScriptEngineFactory factory : mgr.getEngineFactories()) {
            System.out.println("ScriptEngineFactory Info");
            System.out.printf("\tScript Engine: %s (%s)\n", factory.getEngineName(), factory.getEngineVersion());
            System.out.printf("\tLanguage: %s (%s)\n", factory.getLanguageName(), factory.getLanguageVersion());
            for (String name : factory.getNames()) {
                System.out.printf("\tEngine Alias: %s\n", name);
            }
        }
    }
}

