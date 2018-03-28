#def print_function(hash={})
#    puts "printing in ruby"
#    puts hash 
#end

require "/b/janishj/logstash-input-openconfig/logstash/inputs/openconfig.rb"

def print_function(hash={})
    puts "printing in ruby"
    obj = Openconfig.new
    obj.output_stream(hash)
    #puts hash 
end 

