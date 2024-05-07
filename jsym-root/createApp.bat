@echo off
set GRADLE_COMMAND=gradlew --daemon %1%2 -Penv=%3
%GRADLE_COMMAND%
EXIT