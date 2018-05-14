Gem::Specification.new do |s|
  
  version = ENV_JAVA['jar-dependencies']||'0.3.1'
  s.name          = 'logstash-input-openconfig'
  s.version       = '0.1.0'
  s.licenses      = ['Apache License (2.0)']
  s.summary       = 'Logstash input grpc plugin'
  s.description   = 'Plugin takes input from juniper routers using grpc and sends to influxdb'
  s.authors       = ['gtanvi']
  s.email         = 'gtanvi@juniper.net'
  s.require_paths = ['lib']

  # Files
  #  s.files = Dir['Rakefile','lib/**/*','spec/**/*','vendor/**/*','*.gemspec','*.md','CONTRIBUTORS','Gemfile','LICENSE','NOTICE.TXT',"vendor/jar-dependencies/**/*.jar","vendor/jar-dependencies/**/*.rb","VERSION","docs/**/*"]
   
  s.files = Dir['lib/telemetryproto.jar','lib/*.rb']
  s.files += `git ls-files`.lines.map(&:chomp)

  s.add_runtime_dependency 'jar-dependencies',"~> #{version}"
  s.requirements << "jar io.grpc:grpc-netty, 1.11.0"
  s.requirements << "jar io.grpc:grpc-protobuf, 1.11.0"
  s.requirements << "jar io.grpc:grpc-stub, 1.11.0"
  s.requirements << "jar io.netty:netty-handler, 4.1.17.Final"
  s.requirements << "jar io.netty:netty-tcnative-boringssl-static, 2.0.7.Final"
  s.requirements << "jar org.jruby:jruby-complete, 9.1.13.0"

  # Special flag to let us know this is actually a logstash plugin
  s.metadata = { "logstash_plugin" => "true", "logstash_group" => "input" }

  # Gem dependencies
  s.add_runtime_dependency "logstash-core-plugin-api", "~> 2.0"
  s.add_runtime_dependency 'logstash-codec-plain'
  s.add_development_dependency 'logstash-devutils', '>= 0.0.16'
  s.add_development_dependency "bundler", "~> 1.15"
  s.add_development_dependency "rake", "~> 10.3"
  s.add_development_dependency "rspec", "~> 3.0"
  s.add_runtime_dependency "ruby-maven", "~> 3.3.11"
  s.add_development_dependency 'rake-compiler', '~> 0.9'
  s.platform = 'java'
end
