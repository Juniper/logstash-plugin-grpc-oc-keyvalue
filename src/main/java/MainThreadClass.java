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


public class MainThreadClass {
    
    public void invoke(ArrayList<String> server, ArrayList<String> sensors, int port, Object queue, String username, String password, String clientID, String certFile, int sampleFrequency)throws IOException,InterruptedException, ScriptException, FileNotFoundException{
	Thread[] threads = new Thread[server.size()];
	for (int j=0; j< server.size(); j++){
		Runnable r = new host_threads(server.get(j), sensors, certFile, queue, sampleFrequency, username, password, clientID);
		threads[j] = new Thread(r);
		threads[j].start();
	}
	for (int j=0; j<server.size();j++){
		threads[j].join();
	}
    }
}

