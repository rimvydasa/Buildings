# Buildings
Registry for buildings REST API.

MySQL database.
1. In terminal need to run mysql server with command : mysql.server start
    Conntect to: mysql -u root -p 
    Create a schema :CREATE DATABASE dbname;
    Open project and go to: application.properties and set this  
    spring.datasource.url=jdbc:mysql://localhost:3306/dbname 
    spring.datasource.username=root 
    spring.datasource.password=root
    
2. Start"RUN" the project and a database will be created automatically. The database is empty. Use POST endpoint for insert first data.
3. Can check all endpoints with this address: http://localhost:8080/swagger-ui.html
4. There are 6 endpoints. Each endpoint has a different purpose.
    GET - http://localhost:8080/api/buildings/ (can check in postman or in browser) - get a list of all buildings,
    GET - http://localhost:8080/api/buildings/{id} (can check in postman or in browser) - get a specific building,
    POST - http://localhost:8080/api/buildings/ (can use in postman or in swagger) - insert the desired building, leaving the ID box blank. Id will be generated automatically
    PUT -  http://localhost:8080/api/buildings/{id} (can use in postman or in swagger) - enter the ID number you want to change the information.
    DELETE - http://localhost:8080/api/buildings/{id} (can use in postman or in swagger) - enter the ID number you want to delete the building data.
    DELETE - http://localhost:8080/api/buildings/ (can use in postman or in swagger) - delete a list of all buildings.
    
