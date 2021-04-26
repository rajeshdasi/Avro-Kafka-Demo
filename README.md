Steps to run the application.
1. Please make sure your confluent kafka server is up and running.
2. Check out the project to specific directory and generate the jar file.
3. Run the following command `./mvnw spring-boot:run` 
4. The above command should generate a jar file located inside target directory.
5. Navigate to the directory and start the spring boot application using java -jar command.
    Example:
    `$ cd target` followed by
    `$ java -jar avro-kafka-demo-0.0.1-SNAPSHOT.jar`
   
6. Now to publish the message using anyone of the Rest client make a post request as follows
  ```
    http:localhost:8080/publish
    body {
    	"name": "John Doe",
    	"age": 25
    }
    
  ```
7. One should be able to see the results in the kafka topic control center under "users" topic
    
    Example: 
    Navigate to http://localhost:9021
   
    ```Topic -> users -> messages```
   
   