# roboshop-selenium

### Install Docker Stack 

```bash
curl -s https://raw.githubusercontent.com/linuxautomations/labautomation/master/tools/docker-stack/install.sh | sudo bash 
```

### Install Selenium 

```bash
curl -s https://raw.githubusercontent.com/linuxautomations/labautomation/master/tools/selenium/install.sh | sudo bash 
```

### Install Maven

### Update the location of robshop running in the following file.

```text
File Name: src/test/java/testscripts/StanRobotShop.java
Line Number : 31
```

### Run the selenium tests

```bash
mvn clean install "-Dremote=true" "-DseleniumGridURL=http://SELENIUM-PUBLIC-IP:4444/wd/hub" "-Dplatform=Linux" "-Dbrowser=Chrome"  "-Doverwrite.binaries=true"
```

