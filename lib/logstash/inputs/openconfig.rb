=begin

   Copyright 2018 Juniper Networks

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
=end

#encoding: utf-8
require "logstash/inputs/base"
require "logstash/namespace"
require "socket" # for Socket.gethostname
require 'logstash-input-openconfig_jars'
require 'tp'
require 'date'

class LogStash::Inputs::Openconfig < LogStash::Inputs::Base
  config_name "openconfig"

  # If undefined, Logstash will complain, even if codec is unused.
  default :codec, "plain"

  config :server , :validate=> :array
  config :port, :validate=> :number, :default=>32767
  config :sensors, :validate=> :array
  config :username, :validate=> :string, :default=>""
  config :password, :validate=> :string, :default=>""
  config :clientID, :validate=> :string, :default=>""
  config :certFile, :validate=> :string, :default=>""
  config :sampleFrequency, :validate=> :number, :default=>1000

  public
  def register
    @server_name = Socket.gethostname
  end # def register

  def run(queue)
      @queue = queue
      puts @username
      puts @password	
      puts @clientID
      puts @certFile
      obj=Java::MainThreadClass.new
      sensorsObj = java.util.ArrayList.new @sensors
      hostObj = java.util.ArrayList.new @server
      obj.invoke(hostObj, sensorsObj, @port, @queue, @username, @password, @clientID, @certFile, @sampleFrequency)

      #obj.invoke(@host,sensorsObj,@port,@queue)
  end 

  def output_stream(hash={}, queue)
      @server_name = Socket.gethostname
      #event = LogStash::Event.new("message" => hash , "host" => @server_name)
      hash["host"] = @server_name
      hash["local_time"] = DateTime.now.strftime('%Q')
      hash["time"] = DateTime.now.strftime('%Q')
      event = LogStash::Event.new(hash)
      decorate(event)
      queue << event
  end

    def stop
    # nothing to do in this case so it is not necessary to define stop
    # examples of common "stop" tasks:
    #  * close sockets (unblocking blocking reads/accepts)
    #  * cleanup temporary files
    #  * terminate spawned threads
  end
end # class LogStash::Inputs::Plugin

def print_function(hash={}, queue)
    obj = LogStash::Inputs::Openconfig.new
    obj.output_stream(hash, queue)
end
