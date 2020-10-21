# sebit_case_study

Spring Boot was used to start Rest API together with H2 database and jdbc template.
I have controller methods for rest endpoints
DAO methods to access and modify H2 Database
Models for easier JSON parsing

H2 database control panel can be reached through http://localhost:8080/h2-console/
Swagger-Ui can be reached through http://localhost:8080/swagger-ui/
I used schema sql to automatically create db schema.
data.sql to populate db
postman for testing endpoints

## Used Libraries
Spring Web
H2 Database
Spring Data JDBC
Spring fox boot starter (Swagger)

## Assumptions for system logic
- There will be only one commit for one project for that day, when doing batch insert i did not check if date exists for that commit.
- For commit insertion, I did not check if the given userId and projectId exist in project_user table.

## Time Complexity for Commit insertion code
I looped thourgh array once and calculate user(s) commits for the day, put them into hashmap resulting in O(n) complexity.

## Incomplete parts 
Part 8 of the assignment is not complete, it only checks the dates to be at least 4 days apart.
I did not have time, 
