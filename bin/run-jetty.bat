@echo off
rem /**
rem  * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">allinbox</a> All rights reserved.
rem  *
rem  * Author: renweiwei@163.com
rem  */
title %cd%
echo.
echo [��Ϣ] ʹ��Jetty������й��̡�
echo.
rem pause
rem echo.

cd %~dp0
cd..

set MAVEN_OPTS=%MAVEN_OPTS% -Xms256m -Xmx512m -XX:PermSize=128m -XX:MaxPermSize=256m
call mvn jetty:run

cd bin
pause