# Command-line based Search Engine
The command-line based search engine

## Technologies used
* Programming Language: Java
* File System based Database: SQLite
* Unit Test Framework: jUnit
* Build Runner: Maven
* Continuous Integration Server: Jenkins

## Prerequisite to Run the App
JRE (Java Run Time)

## How to Run the App
1) Copy https://github.com/meetgaurang/Java-Search-Demo/blob/master/target/ZenDeskSearch.jar to your local machine
2) Run the Jar file by running following command in Command Prompt,
> java -jar ZenDeskSearch.jar

1) Download and install maven
2) Created Maven Project with following cmd,
mvn archetype:generate -DgroupId=com.sample -DartifactId=searchdemo -DarchetypeArtifactId=maven-archetype-quickstart

To generate jar file,
mvn assembly:assembly
