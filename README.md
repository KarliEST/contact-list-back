# CONTACTS LIST

### Project author: Karli Kullasepp.

# Read Me
Backend for a webapp that displays/adds/removes/updates list of contacts. 
Project creates required REST endpoints for frontend and stores contact data in database.

* Programming language is Java 17.
* Uses Spring Framework (v3.2.1).
* Uses Gradle for dependencies.
* Spring database configuration is in [application.properties](src/main/resources/application.properties).
* PostgreSQL was used as database.

Project has total of 5 endpoints, defined
in [ContactController](src/main/java/com/contacts/contactsback/controllers/ContactController.java)
in [controller](src/main/java/com/contacts/contactsback/controllers) package.<br/>
<br/>
POST request to "/post" endpoint with valid request body adds new contact to database. <br/>
PUT request with valid "id" and valid request body to "/update?id={id}" endpoint updates corresponding contact in database.<br/>
DELETE request with valid "id" to "/delete?id={id}" endpoint deletes contact from database. <br/>
GET request with valid "id" to "/get?id={id}" endpoint returns contact info. <br/>
GET request to "/all" endpoint returns all contacts from database.

Services are located in [services](src/main/java/com/contacts/contactsback/sevices) package.

# Getting Started

### Setup with database

Before you start the app you have to set up your database. 
1. Create PostgreSQL database named **contacts**.
2. Default database user/password are "postgres"/"password". If necessary, they can be changed in [application.properties](src/main/resources/application.properties).
3. Run SQL scripts from [database.sql](database/database.sql) in database, to create table and fill it with some contact data.
4. Run [ContactsBackApplication](src/main/java/com/contacts/contactsback/ContactsBackApplication.java)
   <br/>

### Setup with dockerized database
**Docker must be running!** \
PostgreSQL database is used in docker containers and if needed Adminer as database manager. \
Data is stored on localhost!
1. Change database's properties in [application.properties](src/main/resources/application.properties). \
* Comment out ln 3 (contains port nr 5432)
* Uncomment ln 6 (contains port nr 32768)

2. To run database containers, open terminal in project folder and run: \
   **docker-compose -f postgres.yaml up -d**

3. Run [ContactsBackApplication](src/main/java/com/contacts/contactsback/ContactsBackApplication.java)
4. To stop and containers, networks, volumes, and images created by **up**, type into terminal: \
   **docker-compose -f postgres.yaml down**

To use Adminer open [postgres.yaml](postgres.yaml) and uncomment lines 20-24. \
By default Adminer uses port 8081 (http://localhost:8081/). Port nr can be changed on ln 24. \
To login (defined in [postgres.yaml](postgres.yaml)) :
* System: PostgreSQL
* Server: contacts-db
* Username: postgres
* Password: password
* Database: contacts
### NB! Front end is configured to use proxy port: 8080
