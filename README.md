# Assessment apiTest 

This is a apiTest Assessment gradle project. User can develop/debug/run the automation scripts to testAPI test.
This test project is built on rest Assured, Selenium and TestNG  automation test framework, script language is used in writting automation test is Java. 
 
Getting started:

Git Repository: 
[apiTest](git@github.com:pankajsir/apiTest.git)

**Architecture**

- resources - artifact of .csv, .properties and testing driver files

 **Test**
 
apiTest  - actual test

## Prerequisites

The following tools and pre-requisites must be available on the machine being used to develop and/or run api tests: if just need to run the test only command can be used

Eclipse - IDE

- [Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html)

- Build Automation tool [Gradle](https://gradle.org/releases/): Install gradle 5.5 or later

- Selenium Test Driver  [Selenium Driver](https://www.seleniumhq.org/download/) : This needs to import in java build path in eclipse 
	Right click on project folder -> select Build path -> Configuration build Path add the jar file in library section


## Environment variables:

1. JAVA_HOME - set the value path of jdk version folder where java is install on machine
2. GRADLE_HOME - set the value path of your Gradle folder location on machine



### Run the test - This is for CICD Integration

Following command runs the specified task mentioned in build.gradle file and run the tests methods/class/packages provided in testNg XML file in source folder.

```bash

Gradle build
Gradle Dependencies
Gradle CompileJava
Gradle CompileTestJava
Gradle testAPI
```



## Test, build and run the project in eclipse

Once environment variables are set open the project in eclips and add testNG plugins to eclipse if you need to run from eclipse:

Click on Help->Install New software and add

1. TestNG Eclipse - http://beust.com/eclipse


## Gradle command to compile and run the project

Open command prompt and go to project folder and run the commands: 

### Command to clean the eclipse dependencies and download fresh dependencies and build the project.
  
```bash
Gradle cleaneclipse eclipse
Gradle build
Gradle Dependencies
Gradle CompileJava
Gradle CompileTestJava
Gradle testAPI

```

now refresh the project in eclipse and now test can be run from testNG file.
	
