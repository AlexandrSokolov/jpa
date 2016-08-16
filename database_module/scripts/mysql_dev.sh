#!/bin/bash

#If script is run from scripts folder, we first change a current location
#If script is run from a folder where pom.xml exists, we do nothing
file="pom.xml"
if [ ! -f "$file" ]
then
    cd ..
fi

mvn clean install -Pmysql -Ddataset=production liquibase:update | tee dbupdate.log 2>&1