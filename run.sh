#!/usr/bin/env bash

mvn clean
mvn install
cd target
java -cp MessageGameThreading-1.0-SNAPSHOT.jar Main

