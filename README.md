# Command-line based Search Engine
The command-line based search engine

## Technologies used
* Programming Language: Java
* File System based Database: SQLite
* Unit Test Framework: jUnit
* Build Runner: Maven
* Continuous Integration Server: Jenkins

## Prerequisite to Run the App
JRE (Java Run Time) 1.8 or above

## How to Run the App
1) Copy https://github.com/meetgaurang/Java-Search-Demo/blob/master/target/ZenDeskSearch.jar to your local machine
2) Run the Jar file by running following command in Command Prompt,
> java -jar ZenDeskSearch.jar

That starts the search app and it prompts for input,
![](../master/src/main/resources/documentation-images/search-prompt.png)

## How it Works under the Hood
![](../master/src/main/resources/documentation-images/how-it-works.png)

At the time of initialization, application creates local SQLite DB (e.g. zendesk.db) in the same directory as where JAR file is running. Then it moves data from JSON files to the SQLite DB. 
![](../master/src/main/resources/documentation-images/db-screenshot.png)

## Why SQLite was chosen

The focus was to make this demo easy to use yet powerful. Have I had used, server based Databases like MySQL or Oracle, it would have been 
This file system based DB is fast and very light weight as it doesn't need any server to run.

## Prerequisite to Build the App on Developer's Machine
* JDK (Java Development Kit) 1.8 or above
* Apache Maven 3.5 or above

## How to Build the App
1) Copy following GitHub repo code in local machine
> https://github.com/meetgaurang/Java-Search-Demo.git

2) Start Command Prompt and go inside Project Directory,
> cd Java-Search-Demo

3) Run following Maven Command
> mvn assembly:assembly 

4) That executes the Unit Test Cases and then generates the distribution JAR file - ZenDeskSearch.jar under following location,
> Java-Search-Demo/target/ZenDeskSearch.jar

## Future enhancement
