require 'java'
require '/b/gtanvi/Rotation2/plugins/logstash-input-openconfig/lib/tp' 

def run
    sensors = java.util.ArrayList.new 
    sensors.add("/junos/system/linecard/interface")
    #sensors.add("interfaces")
    host="cassia"
    port=32767
    puts sensors
    obj=Java::MainThreadClass.new
    obj.invoke(host,sensors,port)
end 

run


