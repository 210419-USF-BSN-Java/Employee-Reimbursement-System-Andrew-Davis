# Employee Reimbursement System - Andrew Davis



## Overview
### This application allows employees and managers to interact with the Employee Reimbursement System for their company. The system allows employees to submit reimbursement requests from the company for a variety of business related expenses. Employees can also view pending and resolved requests in addition to viewing and changing their
personal information. Managers can the approve or deny these requests, of which they can the entirety of, or just one employee's pending requests.



## Getting Started
### After cloning the repository onto your machine, ensure that you have the following installed
- Apache Tomcat
- Maven
- Visual Studio Code + Apache Tomcat Extension
### Navigate to the src/java/resources directory to find the SQL that is needed to construct the schema and populate it with dummy data
### In the same directory you will need to provide a connection.properties file with the following values for your connection
- url=url-to-the-database
- username=username-for-the-database
- password=password-for-the-database
### Run the command within the project root directory to build the project and generate the WAR file
- mvn clean package
### Within Visual Studio Code, right click the WAR file that was generated in the /target directory and select
- Run On Tomcat Server
### If you use the default port for Apache Tomcat, which is port 8080 navigate to
- http://localhost:8080/ERS/
### Use the dummy data that exists in the SQL file to login and use the application



## Features
### Employee User Stories 
- An Employee can login
- An Employee can view the Employee Homepage
- An Employee can logout
- An Employee can submit a reimbursement request
- An Employee can view their pending reimbursement requests
- An Employee can view their resolved reimbursement requests
- An Employee can view their information
- An Employee can update their information

### Manager User Stories
- A Manager can login
- A Manager can view the Manager Homepage
- A Manager can logout
- A Manager can approve/deny pending reimbursement requests
- A Manager can view all pending requests from all employees
- A Manager can view all resolved requests from all employees and see which manager resolved it
- A Manager can view all Employees
- A Manager can view reimbursement requests from a single Employee



## Technology Used
- Java, Backend Programming Language
- HTML + CSS + JavaScript, Frontend Programming Languages
- Apache Maven, Build Automation Tool and Package Manager
- Apache Tomcat + Java Servlets, Server Environment
- Java Database Connectivity, Database Interactivity API
- PostgreSQL, Relational Database Management System
- AWS RDS, Cloud Based Distributed Relational Database Service
- JUnit, Unit Testing Framework
- Log4j, Logging Utility


## Notes and ToDo
- There is an upload receipt functionality that hasn't been implemented, which was considered a stretch goal.
- There is currently an issue with accepting and denying requests
- Sessions need to be implemented
- Input validations need to be implemented
