#!/bin/sh

#rm -Rf ./.svn
gradle clean
rm -Rf ./.idea
rm -Rf ./.temp
rm -Rf ./.gradle
rm -Rf ./classes
rm -Rf ./gen
rm -Rf ./build
#mvn clean
find . -name "*.iml" | xargs rm
find . -name "*.ipr" | xargs rm
find . -name "*.iws" | xargs rm
find . -name "pom.xml" | xargs rm

