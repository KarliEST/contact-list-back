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

Before you start the app you have to set up your database. 
1. Create PostgreSQL database named **contacts**.
2. Default database user/password are "postgres"/"password". If necessary, they can be changed in [application.properties](src/main/resources/application.properties).
3. Run SQL scripts from [contacts.sql](db/contacts.sql) in database, to create table and fill it with some contact data.
4. Run [ContactsBackApplication](src/main/java/com/contacts/contactsback/ContactsBackApplication.java)

### NB! Front end is configured to use proxy port: 8080
