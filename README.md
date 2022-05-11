# Brain_Health_Initiative_SERVER

## Requirements

For building and running the application you need:

- [JAVA 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)


## Steps to run locally

1. Build the project using
  `mvn clean install`
2. Run using `mvn spring-boot:run`
3. The web application is accessible via localhost:9090
4. Import initialization data using the SQL script "Data initialization" to populate the database with the required data.
5. Some of the added users are:
   1. Doctor: userId is "123456789100" and password is "hello world"
   2. Admin: userId is "123456789101" and password is "hello world"
   3. Program Manager: userId is "123456789102" and password is "hello world"
6. All the doctors, admins and program managers can be viewed and edited by logging in using admin credentials
