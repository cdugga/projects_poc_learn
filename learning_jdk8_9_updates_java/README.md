# What's new in Java 9
Sample implementations of some of the new features in JDK 9

## Covered Features
 - Interface static methods 
 - Interface default methods 
 - Interface private methods
 - HttpClient
 - JShell


### Interface Static methods

This feature was introduced in Java 8 and allows for the creation of static methods inside Interface. This allows for the use of factory method to create concrete instance of interface and reduces the amount of classes the user must know about to use the interface.  

### Interface default methods  

Before Java 9 it was impossible to update an interface without breaking the concrete implementing classes have coded to. Default methods allow for the addition of new interface methods which provide a default implementation. Implementing classes can use the default method or override. 

### Interface Private methods 

Private methods can be used to split lengthy default methods

### HttpClient

HttpClient is made easier with builder pattern and use of synchronous, asynchronous and multi-Asynchronous requests

## Requirements

- JDK 9
