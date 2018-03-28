require 'jars/classpath'
require 'rake/javaextensiontask'
require 'jars/installer'
require "logstash/devutils/rake"
require "rake/clean"
CLEAN.include("tmp",'lib/telemetryproto.jar','lib/logstash-input-openconfig_jars.rb','lib/com','lib/io','lib/org','*.gem')

task:install_jars do 
    Jars::JarInstaller.new.vendor_jars
end

desc 'Compiles extensions'
task :compile  #this task compiles the gem 
spec= eval File.read('logstash-input-openconfig.gemspec') #reading all the specifications from the gemspec file

desc 'compile src/main/java/** into lib/telemetryproto.jar'# as the description says
Rake::JavaExtensionTask.new("telemetryproto",spec) do |ext|
    ext.classpath = Jars::Classpath.new.classpath_string 
    ext.source_version=1.8 
    ext.target_version = Java::java.lang.System.getProperty('java.specification.version')
    ext.ext_dir = 'src/main/java/'
end

task :compile => :install_jars
task :package => :compile
task :default => :clean
#require 'rubygems/package_task'
#Gem::PackageTask.new(spec)do
#    desc 'Pack the gem- it will basically call both the build jars and compile file as well'
#    task package: [:install_jars,:compile]
#end
