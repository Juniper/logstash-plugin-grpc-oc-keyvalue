require 'logstash/inputs/openconfig'
require 'logstash/inputs/base'
require 'logstash/namespace'
def print_function(hash={})
    #obj=Logstash::Inputs::Plugin.new 
    #obj.output_stream(hash)
    event = LogStash::Event.new("message" => hash, "host" =>host)
    decorate(event)
    @queue << event
end

