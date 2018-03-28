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
