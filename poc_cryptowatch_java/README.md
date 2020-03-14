#Cryptowatch
Application which fetches token prices from https://www.cryptocompare.com/api.

# React App with Spring Boot

Spring Boot application uses RestTemplate to fetch prices and ouputs results using a ReactJs and Bootstrap front-end

### Requirements

- Maven
- JDK 8
- ReactJS 1.15.
- Bootstrap

### Configuration

Maven front-end controller uses npm and webpack to package css and ReactJs assets. Update webpack.config.js if you need to udpate assets locations.

### Running

To build and start the server simply type

```sh
$ mvn spring-boot:run
```

from the root directory.

### Using

Browse to `localhost:8080` to see the application in action.


### License

