require 'java'
require '/b/janishj/logstash-input-openconfig/lib/tp' 

def run
    sensors = java.util.ArrayList.new 
    sensors.add("/junos/system/linecard/interface")
    #sensors.add("interfaces")
    host="teakwood"
    port=32767
    puts sensors
    obj=Java::MainThreadClass.new
    obj.invoke(host,sensors,port)
    puts "I am DONE TOOOOo"
end 
class TClass
    def print_fuc
	puts "Vijay"
    end
end
TClass.new()

run


