@echo off
REM Use local Allure binary inside project

cd /d %~dp0
set RESULTS_DIR=%cd%\target\allure-results
set ALLURE_BIN=%cd%\tools\allure-2.44.1\bin\allure.bat

echo Using Allure at %ALLURE_BIN%
"%ALLURE_BIN%" serve "%RESULTS_DIR%"

pause
