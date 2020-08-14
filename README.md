# metrics-conversion
This is a Metric Conversion Service

Exposed Endpoints
 - endpoint = IP_ADDRESS:8080/conversion/ktoc to convert kelvin to celsius
 - endpoint = IP_ADDRESS:8080/conversion/ctok to convert celsius to kelvin
 - endpoint = IP_ADDRESS:8080/conversion/ktom to convert kilometers to miles
 - endpoint = IP_ADDRESS:8080/conversion/mtok to convert miles to kilometers
 
Option 1
  - clone the project to your local
  - Run the TempertureConversionApplication.java class on your IDE
  - Launch your browser
  - navigate to ${endpoint}?input=${input} 
  
Option 2
  - clone the project to your local
  - open your terminal
  - navigate to ${project_home}/test/java
  - run the command : java -jar 0.0.1-SNAPSHOT.jar
  - Launch your browser
  - navigate to ${endpoint}?input=${input}
  
