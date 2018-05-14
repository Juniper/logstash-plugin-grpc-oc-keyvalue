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
import javax.net.ssl.SSLException;
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
import java.util.Arrays;
import authentication.AuthenticationService;
import authentication.LoginGrpc;
import java.lang.reflect.Field;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.netty.NegotiationType;

public class host_threads implements Runnable {
        String server;
        ArrayList<String> sensors;
        String certFile;
        Object queue;
	int sampleFrequency;
	String username;
	String password;
	String clientID;
	String clientKey;
	String clientCert;
        public host_threads(String server, ArrayList<String> sensors, String certFile, Object queue, int sampleFrequency, String username, String password, String clientID){
                this.server = server;
                this.sensors = sensors;
                this.certFile = certFile;
                this.queue = queue;
		this.sampleFrequency = sampleFrequency;
		this.username = username;
		this.password = password;
		this.clientID = clientID;
        }
        public void run() {

                System.out.println("Starting a thread with server: " + server);
                String tmp_array[] = (server.split(":"));
                if (tmp_array.length > 2) {
                        System.out.println("Error! Too many : in the server configuration");
                }
		if(tmp_array.length == 1){
			System.out.println("Error! Port not specified in server configuration");
		}
                String serverName = tmp_array[0];
                int portNum = Integer.parseInt(tmp_array[1]);
                System.out.println("Server: " + server);
                System.out.println("Port: " + portNum);
                System.out.println("Sensors: " + sensors);
		System.out.println("CertFIle: "+ certFile);
               /*
		  ManagedChannel channel = ManagedChannelBuilder.forAddress(serverName,portNum)
                		           .useTransportSecurity(new File(certFile))
                        		   .build();

		*/
		try {

			/*
			 ManagedChannel channel = ManagedChannelBuilder.forAddress(serverName,portNum)
				                        .usePlaintext(true)
                      				        .build();
				
			ManagedChannel channel = NettyChannelBuilder.forAddress(serverName, portNum)
	    					.sslContext(GrpcSslContexts.forClient().trustManager(new File(certFile)).build())
	    					.build();
			*/
			AbstractManagedChannelImplBuilder<?> channelBuilder;
			if (!certFile.isEmpty()){
				System.out.println("Entered certFIle is a string");
			        channelBuilder = NettyChannelBuilder.forAddress(serverName,portNum)
						.sslContext(GrpcSslContexts.forClient().trustManager(new File(certFile)).build());

			}
			else {
				System.out.println("Entered certFile is null");
				channelBuilder = NettyChannelBuilder.forAddress(serverName,portNum)
                                		.negotiationType(NegotiationType.PLAINTEXT);
			}
			Field declaredField = NettyChannelBuilder.class.getSuperclass().getDeclaredField("tracingEnabled");
		        declaredField.setAccessible(true);
	                declaredField.set(channelBuilder, false);
	
		        ManagedChannel channel = channelBuilder.build();
	 		OpenConfigTelemetryGrpc.OpenConfigTelemetryBlockingStub stub=OpenConfigTelemetryGrpc.newBlockingStub(channel);
	                //Thread[] threads = new Thread[sensors.size()];//as many threads as there are sensors
			
			if (!username.isEmpty()){
		             /* 
		                ManagedChannel channel = NettyChannelBuilder.forAddress(serverName, portNum)
		                                                        .sslContext(GrpcSslContexts.forClient().trustManager(new File(certFile)).build())
		                                                        .build();
		            */
		                System.out.println("username found");
		                LoginGrpc.LoginBlockingStub auth_stub = LoginGrpc.newBlockingStub(channel);
		                System.out.println("auth_stub created");
		                AuthenticationService.LoginRequest request = AuthenticationService.LoginRequest.newBuilder()
		                                                                .setUserName(username)
		                                                                .setPassword(password)
		                                                                .setClientId(clientID)
		                                                                .build();
		                System.out.println("request created");
		                while(true){
		                        AuthenticationService.LoginReply response = auth_stub.loginCheck(request);
		                        if (!response.getResult()){
		                                System.out.println("Error!Password Authentication failed for " + server+ ". Will retry in 10 seconds.");
		                        }
		                        System.out.println("Before break in while loop");
		                        break;
		                }
		        }
			
		        //OpenConfigTelemetryGrpc.OpenConfigTelemetryBlockingStub stub=OpenConfigTelemetryGrpc.newBlockingStub(channel);
		        //OpenConfigTelemetryGrpc.OpenConfigTelemetryStub stub=OpenConfigTelemetryGrpc.newStub(channel);

	                ArrayList<Thread> threads = new ArrayList<Thread>();
			LinkedHashMap<String, LinkedHashMap<String, Object>> tr_record = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
	                int threadCount = 0;
		        for (int i = 0; i < sensors.size(); i++) {
			    int frequency = sampleFrequency;
			    String measurementName;
			    String new_sensor_split[];
			    String sensor_split[] = sensors.get(i).split(" ");
			    measurementName = sensor_split[0];
			    if (sensor_split.length > 1)  {
				measurementName = "";
				if (Integer.toString(Integer.parseInt(sensor_split[0])) == sensor_split[0] ){
					frequency = Integer.parseInt(sensor_split[0]); 
					if (!sensor_split[1].startsWith("/")){
						measurementName = sensor_split[1];
						new_sensor_split = Arrays.copyOfRange(sensor_split, 2, sensor_split.length);
					}
					else {
						new_sensor_split = Arrays.copyOfRange(sensor_split, 1, sensor_split.length);
					}
				}
				else {
					if (!sensor_split[0].startsWith("/")){
						measurementName = sensor_split[0];
						new_sensor_split = Arrays.copyOfRange(sensor_split, 1, sensor_split.length);
					}
					else {
						new_sensor_split = Arrays.copyOf(sensor_split, sensor_split.length);
					}
				}	
			    }
			    else {
					new_sensor_split =  Arrays.copyOf(sensor_split, sensor_split.length);
			    }
			    System.out.println("sensor_split.length: "+ sensor_split.length);
			    System.out.println("new_sensor_split.length: "+ new_sensor_split.length);
			    for (int j=0; j< new_sensor_split.length; j++){
				String sensor_name = new_sensor_split[j];
				if (measurementName == ""){
	                   		 Runnable r = new OpenConfigTelemetryGrpcClient(sensor_name, tr_record, channel, stub, serverName, queue, sensor_name);
	                   		 threads.add(new Thread(r));
	                   		 (threads.get(threadCount)).start();
					 threadCount=threadCount+1;
				}
				else {
			  		 Runnable r = new OpenConfigTelemetryGrpcClient(sensor_name, tr_record, channel, stub, serverName, queue, measurementName);
					 threads.add(new Thread(r));
	                   		 (threads.get(threadCount)).start();
					 threadCount=threadCount+1;
				}
			    }
	                }
			System.out.println("threadCount:  " + threadCount);
	                for (int i = 0; i < threadCount; i++) {
	                    threads.get(i).join(); 
	                }
			System.out.println("Thread join returned");
		}
		catch(Exception e){
			System.out.println("Exception Raised in host_threads: ");
                        System.out.println(e);
		}
                

                System.out.println("Reached end of thread");
          }
}


