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

  config :host , :validate=> :string
  config :port, :validate=> :number, :default=>32767
  config :sensors, :validate=> :array
  public
  def register
    @server_name = Socket.gethostname
  end # def register

  def run(queue)
      #puts "============="
      #puts queue.class
      @queue = queue
      #puts "In run, printing global_var class: "
      obj=Java::MainThreadClass.new
      sensorsObj = java.util.ArrayList.new @sensors
      obj.invoke(@host, sensorsObj, @port, @queue)

      #obj.invoke(@host,sensorsObj,@port,@queue)
      #while 1 do
      #	  puts "Sleeping......"
      #    sleep(10000000000000000)
      #end
      
      puts "I am Done"
  end 

  def output_stream(hash={}, queue)
      #puts "INSIDE output_stream +++++++++"
      #puts hash
      @server_name = Socket.gethostname
      #event = LogStash::Event.new("message" => hash , "host" => @server_name)
      hash["host"] = @server_name
      hash["local_time"] = DateTime.now.strftime('%Q')
      hash["time"] = DateTime.now.strftime('%Q')
      event = LogStash::Event.new(hash)
      #puts hash.class
      #hash.each do |key, value|
#	puts "==========================+"
#	puts key
#	puts value
#      end
      decorate(event)
      #event.get("message")
      #puts "$$$$$$$$$$$$$$$$$$$$$$$$$$"
      #puts queue.class
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

puts "#########################################"
puts "Checking if file is loaded"

def print_function(hash={}, queue)
    #puts "printing in ruby, IN print_function"
    obj = LogStash::Inputs::Openconfig.new
    obj.output_stream(hash, queue)
    #puts hash 
end
