# Origami Coding Test

 A simple Checkout test for Origami.
 
 Additional considerations:
 
 add() and find() methods are using synchronised to stop multiple threads from interacting with the map at the same time. 
 However, this could potentially be improved upon by locking the map when it is being accessed. This would allow threads
  to find items in the map concurrently.
 
 ## Build and Run
 Navigate to project root
 
 Run the following command
 
 ```
 mvn clean install
 ```
 
 This will generate a jar file in the target directory. Now we go to that directory and run the jar.
 
 Run following commands
 ```
 cd target
 java -jar origamitest-1.0-jar-with-dependencies.jar
 ```
 
 Alternatively you can run via Intelli J by navigating to Main.java. Then click on the green triangle on left hand side.

