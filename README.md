# QE NE Digital Pretest

  You can answer it as creative as you can, you can even show off what you know, use all the tools that you like, and send us your PR.
Once upon a time there is a web page (https://devexpress.github.io/testcafe/example/) that need to assess how cool is the quality of the page. And here it comes your first task begin:


**1.** Tell us what kind of test should be conduct (plan and why) to make sure the page is ok.


**2.** Tell us what kind of testcase you want to execute.

**For Step 1 & 2, I have arrived with following Strategy and Test Plan - https://docs.google.com/document/d/1BFCf8Xztm7wMiRFuGbgdq7A8fQy9f6aGXRzGeELpcV0/edit?usp=sharing**


**3.** We all know automation can help, show us your test-automation code to test it with BDD Style and Please Impress us by not using Katalon. <BR>
   Please put in your README.md how to run this locally, so we can try it.
   Nice to have if you can integrate it with the CircleCI or Bitbucket Pipelines , and capture the result.

# **NEDigitalTest**
> Outline a brief description of your project.
> Live demo [_here_](https://drive.google.com/file/d/1LnXAl-Dh3d75w1vdeyXk6twyShLZHIti/view?usp=sharing). 

## Table of Contents
* [General Info](#general-information)
* [Tools Used/Environment Requirement](#technologies-used)
* [Test Scenarios Automated](#features)
* [Framework Structure](#screenshots)
* [How To Run](#usage)
* [Bugs Found](#project-status)


## General Information
- NEDigitalTest project is created to automate Examples webpage-https://devexpress.github.io/testcafe/example/
- All the tests are run in chrome browser [Can be modified via remote webdriver]

## Tools Used/Environment Requirement
- Java JDK 17
- Maven 3.8.3
- Chrome 97
- Chrome Webdriver [Attached directly under project]
  
## Additioanl tools for Grid and CI implementataions [Not required to run in local machine]
  - Docker For Windows 


## Test Scenarios Automated
- Verify user is not allowed to submit the form without specifying name and with all other options enabled
- Verify user is able submit the application with choosing Test Cafe
- Verify user is able submit the application by choosing TestCafe interface
- Verify user is able submit the application with OS alone selected
- VVerify user is able submit the application with all the important features selected
- Verify user is able to submit the application with only name input entered  in different formats 


## Framework Structure
Run command [MVN] -> Serenity BDD -> Cucumber-> Run Settings File [Junit] -> Secenarios -> Step Definitions -> Steps -> Page Object Class 


## How To Run
- Directly it can be run in IntelliJi/Eclipse by running Junit file named "SerenityCucumberRunner'
- Can be run via maven command -"mvn clean verify" 
- Can be run via maven with Selenium GRID setup, follow following step 
     - Install Docker For Windows 
     - Perform docker compose on 'docker-compose.yml' file which consist of image requirements for hub and nodes 
     - After hub is up , run following command via cmd - 'mvn clean verify  -Dwebdriver.driver=remote -Dwebdriver.remote.url=http://192.168.0.145:4444/wd/hub -Dwebdriver.remote.driver=chrome'
- CI/CD
     - Create a Jenkin PipeLine Job and add "JenkinFile" as Jenkins file 
     - Run the Job [Job will run against already invoked Selenium GRID]
     - Specify "JenkinsFile" as "JenkinsFile" which will automatically setup the Selenium GRID images and run the scripts 

**4.** Every new employee at NTUC will have a buddy help him/her to tune in with environment. Every employee have their supervisor and team. Let's say that we have a table of employee where all the information mention earlier is store. The table specification is looks like this:<BR>
| employee_id | employee_name | buddy_id | supervisor_id | team_name |<BR>
your task is to create a query to show:<BR>
| employee_id | employee_name | buddy_name | supervisor_name | team_name |

 ** Query**: SELECT A.employee_id, A.employee_name, B.employee_name AS "buddy_name", C.employee_name AS supervisor_name, A.team_name FROM EMPLOYEE A, EMPLOYEE B, EMPLOYEE C WHERE A.buddy_id =B.employee_id AND A.supervisor_id = C.employee_id
