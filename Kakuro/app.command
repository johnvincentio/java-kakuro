#!/bin/sh
#
# script to run java app kakuro
#
echo "begin"
#
DEV_HOME=/Users/jv/Desktop/MyDevelopment/github/java/Games/java-kakuro/Kakuro/classes
#
MYCP=$DEV_HOME
#
java -cp $MYCP -Xdock:name="Kakuro" io.johnvincent.kakuro.Appgui
#
echo "end"
