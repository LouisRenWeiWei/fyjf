@echo off
rem /**
rem  * Copyright &copy; 2012-2014 <a href="https://github.com/LouisRenWeiWei">allinbox</a> All rights reserved.
rem  *
rem  * Author: renweiwei@163.com
rem  */
echo.
echo [��Ϣ] ������̣�����war���ļ���
echo.
pause
echo.

cd %~dp0
cd..

call mvn clean package -Dmaven.test.skip=true

cd bin
pause