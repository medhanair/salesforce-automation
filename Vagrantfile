Vagrant.configure("2") do |config|
  config.vm.box = "pbarriscale/centos7-gui"
  config.vm.hostname = "CentOS"
  config.vm.network "private_network", ip: "192.168.50.4"
  config.vm.network "forwarded_port", guest: 22, host: 2222
  config.vm.provider "virtualbox"
  config.vm.provider "virtualbox" do |v|
    v.memory = 4096
    v.cpus = 2
  end
  config.ssh.username = 'root'
  config.ssh.password = 'vagrant'
  config.vm.provision "shell", inline: "sudo yum-config-manager --disable dockerrepo"
  config.vm.provision "shell", inline: "sudo yum install firefox -y"
  config.vm.provision "shell", inline: "sudo yum install java-1.8.0-openjdk -y"
  config.vm.provision "shell", inline: "sudo systemctl stop firewalld.service"
  config.vm.provision "shell", inline: "sudo systemctl disable firewalld"
end