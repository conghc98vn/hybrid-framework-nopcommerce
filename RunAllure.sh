#!/bin/sh
echo "------ Step 01: Set project path to variable -------"
project_path="/Users/congchi/Desktop/hybrid-framework-nopcommerce"
echo "------ Step 02: Go to project path folder -------"
cd "$project_path"
echo "------ Step 03: Run the testcases -------"
java -javaagent:"$project_path/libAllure/aspectjweaver-1.9.8.jar" -classpath "$project_path/bin:$project_path/libAllure/*:$project_path/libLog4Jver2/*:$project_path/lib/*:$project_path/libReportNG/*:$project_path/libAssertJ/*:$project_path/libSelenium/*" org.testng.TestNG "$project_path/bin/RunNopCommerce.xml"
echo "------ Step 04: Load allure command line setting -------"
source ~/.bash_profile
echo "------ Step 05: Generate Allure HTML Report -------"
allure serve ./allure-results/