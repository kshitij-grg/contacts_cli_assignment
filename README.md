# Contacts CLI Assignment

This repository contains quiz work for building a Java Contact Management CLI app using Maven.

## Student Work Included

- Task 1.1: Functional requirements list
- Task 1.2: UML class diagram image
- Task 2.1: Git repository initialization with terminal screenshot
- Task 2.2: Maven Java CLI project setup with IDE screenshot
- Task 2.3: Domain model classes in package model
- Task 2.4: CLI app that:
  - Builds sample contacts data
  - Sorts contacts by last name in ascending order
  - Prints contact data in JSON format

## Project Structure

- task1_1_functional_requirements.txt
- task1_2_contacts_uml.png
- screenshots/
- contacts-cli-app/
  - pom.xml
  - src/main/java/model/
  - src/main/java/edu/miu/contacts/App.java
  - src/test/java/edu/miu/contacts/AppTest.java

## Prerequisites

- Java 21
- Maven 3.x

## Build and Test

From contacts-cli-app directory:

mvn test

## Run the Application

From contacts-cli-app directory:

mvn exec:java -Dexec.mainClass=edu.miu.contacts.App

## Output Behavior

The application prints pretty-formatted JSON of sample contacts sorted by last name in ascending order.

## Notes

- Maven target folders are ignored by git via .gitignore.
- IDE files under .idea are ignored.
