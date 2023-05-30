# MessageGameThreading
In this project, 2 player objects communicate each other over synronised queue. So, the players are in the same java process.

To create the jar file, build the maven project to have a executuble jar file "MessageGameThreading-1.0-SNAPSHOT.jar".
```
mvn clean
mvn install
```
In order to run the jar file, run the following command. At the end, you can see their
messages in the terminal. Project is finished after 10 mutual messages are achieved.
```
java -cp MessageGameThreading-1.0-SNAPSHOT.jar Main 
```

Note: To see the version where players work as seperate java process, check the MessageGame project.
