# Command-line based Search Engine
The command-line based search engine

## Technologies used
* Programming Language: **Java**
* File System based Database: **SQLite**
* Unit Test Framework: **jUnit**
* Build Runner: **Maven**
* Continuous Integration Server: **Jenkins**

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

At the time of initialization, application creates local SQLite DB (e.g. zendesk.db) in the same directory as where JAR file is running. Then it moves data from JSON files to the SQLite DB. Further, SQLite DB will facilitate all the search queries.
![](../master/src/main/resources/documentation-images/db-screenshot.png)

## Why SQLite based solution was chosen
**Easy to Use** No extra installation as it is file-system based Database

**Scales Easily** It could easily handle 25000+ records as mentioned in [this comparision](https://sqlite.org/speed.html). Further, it could handle GBs of data with certain tweaks as mentioned [here](https://stackoverflow.com/a/6533930/1069893).

## Test Case Coverage
Currently test cases are there to test following critical features,
* Read data from JSON file and test its integrity
* Insert data into SQLite DB and test its integrity
* Search data from SQLite DB

Test case coverage can be enhanced further upon request.

## Integration with Jenkins
Jenkins server, setup on my local machine, delivers more frequent build drops and raises any build related issue faster.
![](../master/src/main/resources/documentation-images/jenkins-ci.png)

## Prerequisite to Build the App on Developer's Machine
* JDK (Java Development Kit) 1.8 or above
* Apache Maven 3.5 or above

## How to Build the App on Developer's Machine
1) Copy following GitHub repo code in local machine
> https://github.com/meetgaurang/Java-Search-Demo.git

2) Start Command Prompt and go inside Project Directory,
> cd Java-Search-Demo

3) Run following Maven Command
> mvn assembly:assembly 

4) That executes the Unit Test Cases and then generates the distribution JAR file - ZenDeskSearch.jar under following location,
> Java-Search-Demo/target/ZenDeskSearch.jar

## Future enhancements
1) Preventing malicious User Inputs to avoid SQL injection attack
2) Adding Code Quality checks with SonaQube as part of Continuous Integration setup
3) To generate log files
4) Enhancing test case coverage
