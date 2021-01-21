## Server Side with OAuth2 ##

Project as an Authorization Server and Resource Server with Spring Oauth2 Grant Type Password

* http://localhost:8081/ngx-admin-server/oauth/token : to obtain access_token given user credential
* http://localhost:8081/ngx-admin-server/foos/ : to access rest service foo as resource server

#### Build the project ####

```java
mvn clean install
```
#### Run Project ####

```java
mvn spring-boot:run
```
