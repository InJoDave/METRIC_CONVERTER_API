# METRIC_CONVERTER_API
 This API is based on the conversion charts found in Google. If any mistake in conversion it can be easily rectified
 
## UNIT ABBREVIATIONS USED

For LENGTH:
Unit code | Unit

m | Meters km | Kilometers cm | Centimeters mm | Millimeters mi | Miles yd | Yards ft | feet in | Inches

For TEMPERATURE:
Unit code | Unit

c | Celsius f | Fahrenheit

## Steps to Setup

**1. Build and run the app using maven**

```bash
mvn package
java -jar target/metricconverter-0.0.1-SNAPSHOT.jar

```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at at port 8080 (Embedded Tomcat Server).

**2. PostMan Collection**

```bash
Included Postman collection METRIC_CONVERTER_API.postman_collection.json can be imported into Postman for testing purposes
```
**3. Unit Test Cases and Integration Test Cases**

```bash
Unit Test Cases -> JUnit5 with Mockito
Integration Test Cases -> Spring Boot Test instance to trigger the endpoints
```
**4. Exception Handling**

```bash
Single Exception Handler class using @RestControllerAdvice
```
**5. Dockerfile**

```bash
-> Multi-layer approach
First stage:  Extracts the dependencies
Second stage: Copies the extracted dependencies to the final image

