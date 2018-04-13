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

public class MainThreadClass {
    public void invoke(String server,ArrayList<String> sensors,int port, Object queue)throws IOException,InterruptedException, ScriptException, FileNotFoundException{
	System.out.println("Server: " + server);
	System.out.println("Port: " + port);
	System.out.println("Sensors: " + sensors);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(server,port)
                .usePlaintext(true)
                .build();
        OpenConfigTelemetryGrpc.OpenConfigTelemetryBlockingStub stub=OpenConfigTelemetryGrpc.newBlockingStub(channel);
//      listScriptingEngines();
//	System.setProperty("org.jruby.embed.localvariable.behavior", "transient");
//	System.setProperty("org.jruby.embed.localcontext.scope", "singleton");	
//	ScriptEngineManager manager = new ScriptEngineManager();
//      ScriptEngine engine = manager.getEngineByName("jruby");
//	Reader reader = new FileReader("/b/janishj/logstash/vendor/local_gems/940211cf/logstash-input-openconfig-0.1.0-java/lib/logstash/inputs/openconfig.rb");
//      engine.eval(reader);
//	String server = "teakwood";
//	ArrayList<String> sensors = new ArrayList<>();
//	sensors.add("/components/");
//	sensors.add("/interfaces/");
//      System.out.println("Printing in main");
//	System.out.println(queue);
//	System.out.println(sensors.size());
        Thread[] threads = new Thread[sensors.size()];//as many threads as there are sensors
        LinkedHashMap<String, LinkedHashMap<String, Object>> tr_record = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
        for (int i = 0; i < sensors.size(); i++) {
            Runnable r = new OpenConfigTelemetryGrpcClient(sensors.get(i), tr_record, channel, stub,server,queue);
            threads[i] = new Thread(r);
            threads[i].start();
        }
        for (int i = 0; i < sensors.size(); i++) {
            threads[i].join();
        }
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
