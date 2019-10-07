# crealytics-reporting

Steps to run

For development
```
mvn spring-boot:run
```

For building
```shell script
mvn package
```

Once build is complete, run jar file as
````
java -jar target/reporting-0.0.1-SNAPSHOT.jar
````

Endpoints:

Report for a given month and site 
````
http://localhost:8080/api/v1/reports/1/iOS
http://localhost:8080/api/v1/reports/jan/android
http://localhost:8080/api/v1/reports/February/desktop_web
````

Aggregated report for a given month  
````
http://localhost:8080/api/v1/reports?month=jan
http://localhost:8080/api/v1/reports?month=January
http://localhost:8080/api/v1/reports?month=01
````

Aggregated report for a given site  
````
http://localhost:8080/api/v1/reports?site=desktop_web
http://localhost:8080/api/v1/reports?site=mobile_web
http://localhost:8080/api/v1/reports?site=iOS
````
