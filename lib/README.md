# Logstash Juniper telemetry plugin for JTI OC sensors

This plugin is designed to parse the JTI OC sensors data.
JTI OC data is encoded in protobuf as key value pairs and sent over a gRPC channnel. Client have to establish a gRPC connection and subscribe for required sensors.

Below are few points that are considered:

* One gRPC session is maintained per router per pipeline
* Retry mechanism in case the gRPC session is not established or terminated until the session is established or configurations are changed
* Support for username/password and SSL based authentication
* Addition of new sensors in future JUNOS versions, can be parsed without any changes to the plugin as long as present “oc.proto” is not changed
* Every entry on a particular timestamp is recognized based on the tags/keys. Tags are identified by parsing the xml path in the OC key attribute. For example, XML path “/interfaces/interface[name=ge-0/0/0]/state/admin-status” will result in a tag ““/interfaces/interface/@name” set to ge-0/0/0 and a field “/interfaces/interface/state/admin-status” set to a value in OC value attribute.
* Multiple fields for a particular key set at a particular timestamp, all of them are combined to a single entry
* Timestamp, system id from the JTI message and hostname on which the collector is running will be added to all the entries


Below is can example configuration.

```sh
input {    openconfig {
        server => ["my_server_name:my_server_port"]
        sensors => ["/interfaces/interface"]
        port => my_server_port
        sampleFrequency => 30000
        username => "regress"
        password => "MaRtInI"
        certFile => "/home/regress/RSA2048.pem"
        clientID => "testID"
    }
}
output {
    stdout {codec => rubydebug}
    influxdb {
        db => logstash_test
        host => localhost
        port => 8086
 
        #user => juniper
        #password => juniper
        allow_time_override => true
        use_event_fields_for_data_points => true
        measurement => "juniperNetworks.%{sensor_name}"
        #exclude_fields => ["sensor_name"]
        #exclude_fields => ["@timestamp", "@Version"]
        #exclude_fields => ["@timestamp", "@version"]
    }
}
```
