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

require 'jar-dependencies'
if defined?(JRUBY_VERSION) && Gem.post_install_hooks.empty?
    Gem.post_install do |gem_installer|
	require 'jar_installer'
	unless(ENV['JARS_SKIP'] || java.lang.System.get_property('jars.skip')) == 'true'
	    jars = Jars::JarInstaller.new( gem_installer.spec )
	    jars.ruby_maven_install_options = gem_installer.options || {}
	    jars.vendor_jars
	end
    end 
end
gem_name = "logstash-input-openconfig"
puts "valid logstash plugin '#{gem_name}'. Installing..."
Gem.install(gem_name)
