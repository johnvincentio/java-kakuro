#!/bin/sh
#
# script to run java app kakuro
#
DEV_HOME=/Users/jv/Desktop/MyDevelopment/github/java/Games/java-kakuro/Kakuro
#
MYCP=$DEV_HOME/classes
#
java -cp $MYCP -Xdock:name="Kakuro" io.johnvincent.kakuro.Appgui
#
