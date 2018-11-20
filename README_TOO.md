# java-developer-assignment
Language: Java 8
Dependency Management: Maven 3.5
Source Control: Git
IDE: IntelliJIdea
## 1. Build project (root directory):
```
$ mvn clean package
```
## 2. Run demo app (root directory):
```
$ java -jar java-developer-assignment-1.0-SNAPSHOT.jar
```
You don't need to build the project, jar is provided anyway.

## 3. Classes:
· Flight (models Flight)
· FlightList (Converts 2 List<<List> String> to List<Flight>)
· PriceFlight (Calculates cost given a list of flights, days to departure and number of passengers)
· SearchFlight (Searchs flights given origin and destiny)
· Main (demo purposes only)
· Unit tests for FlightList, PriceFlight and SearchFlight

## 4. Considerations:
1) Minor change introduced in the provided CSV parser in order to:
· Avoid using different read methods between sources and tests
· Be able to read resources contained in jar files.
3) Despite it wasn't need anymore, the provided method "fullPathTo" at the provided test class ReadFlightsTest seems to include a windows platform specific issue. I've provided a workaround to the issue. Anyway, I insist on this method shouldn't be needed anymore.
2) At pom.xml, maven-compiler-plugin has been replaced with maven-jar-plugin
· It was specified not to use additional libraries, but nothing was specified about maven plugins or the build process, so for the demo purposes was easier to use the jar plugin instead.