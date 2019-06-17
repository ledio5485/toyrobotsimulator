# Toy Robot Simulator

### Code problem details:
- The application is a simulation of a toy robot moving on a square tabletop, of
dimensions 5 x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be prevented from
falling to destruction. Any movement that would result in the robot falling from the table must
be prevented, however further valid movement commands must still be allowed.

### Create an application that can read in commands of the following form:

| Command       | Description                                                                                                                                                     |
| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| PLACE X,Y,F   | will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner. |
| MOVE          | will move the toy robot one unit forward in the direction it is currently facing.                                                                               |
| LEFT          | will rotate the robot 90 degrees in the LEFT without changing the position of the robot.                                                                        |
| RIGHT         | will rotate the robot 90 degrees in the RIGHT without changing the position of the robot.                                                                       |
| REPORT        | will announce the X,Y and F of the robot.                                    |

### Constraints:
- The application must be a Spring-Boot-Application
- Input must be realised over the REST-API, take care when designing the REST-API
- The robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT
and REPORT commands.
- The robot must not fall off the table during movement. This also includes the initial
placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.
- It is not required to provide any graphical output showing the movement of the toy
robot.

## Prerequisites:
* [java 8+][java-download]
* [maven 3.x.x][maven-download]

Check the installed version of java
```bash
java -version
```
and maven
```bash
mvn --v
```

##Test, Build and Run instructions

- test: 
```bash
mvn clean test
```
- package: 
```bash
mvn clean package
```
- run: 
```bash
java -jar target/toyrobotsimulator-1.0.0-SNAPSHOT.jar
```

## Test the REST

You can consult the REST API spec [here][api-docs].

You can try it [at this page][swagger-ui]. Here are some examples:

-
request:
```json
{
  "commands": [
    {
      "name": "PLACE",
      "args": 
        {
          "location": 
            {
              "x": 0,
              "y": 0  
            },
          "facing": "NORTH"
        }
    },
    {
      "name": "MOVE"
    },
    {
      "name": "REPORT"
    }
  ]
}
```
or 
```bash
curl -X POST "http://localhost:8080/toy-robot-simulator/api/simulate" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"commands\": [ { \"name\": \"PLACE\", \"args\": { \"location\": { \"x\": 0, \"y\": 0 }, \"facing\": \"NORTH\" } }, { \"name\": \"MOVE\" }, { \"name\": \"REPORT\" } ]}"
```
response:
```json
{
  "position": {
    "facing": "NORTH",
    "location": {
      "x": 0,
      "y": 1
    }
  }
}
```
-
request:
```json
{
  "commands": [
    {
      "name": "PLACE",
      "args": 
        {
          "location": 
            {
              "x": 0,
              "y": 0
            },
          "facing": "NORTH"
        }
    },
    {
      "name": "LEFT"
    },
    {
      "name": "REPORT"
    }
  ]
}
```
or
```bash
curl -X POST "http://localhost:8080/toy-robot-simulator/api/simulate" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"commands\": [ { \"name\": \"PLACE\", \"args\": { \"location\": { \"x\": 0, \"y\": 0 }, \"facing\": \"NORTH\" } }, { \"name\": \"LEFT\" }, { \"name\": \"REPORT\" } ]}"
```
response:
```json
{
  "position": {
    "location": {
      "x": 0,
      "y": 0
    },
    "facing": "WEST"
  }
}
```
-
request:
```json
{
  "commands": [
    {
      "name": "PLACE",
      "args": 
        {
          "location": 
            {
              "x": 1,
              "y": 2  
            },
          "facing": "EAST"
        }
    },
    {
      "name": "MOVE"
    },
    {
      "name": "MOVE"
    },
    {
      "name": "LEFT"
    },
    {
      "name": "MOVE"
    },
    {
      "name": "REPORT"
    }
  ]
}
```
or
```bash
curl -X POST "http://localhost:8080/toy-robot-simulator/api/simulate" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"commands\": [ { \"name\": \"PLACE\", \"args\": { \"location\": { \"x\": 1, \"y\": 2 }, \"facing\": \"EAST\" } }, { \"name\": \"MOVE\" }, { \"name\": \"MOVE\" }, { \"name\": \"LEFT\" }, { \"name\": \"MOVE\" }, { \"name\": \"REPORT\" } ]}"
```
response:
```json
{
  "position": {
    "location": {
      "x": 3,
      "y": 3
    },
    "facing": "NORTH"
  }
}
```
-
request:
```json
{
  "commands": [
    {
      "name": "PLACE",
      "args": 
        {
          "location": 
            {
              "x": 0,
              "y": 0  
            },
          "facing": "SOUTH"
        }
    },
    {
      "name": "MOVE"
    },
    {
      "name": "MOVE"
    },
    {
      "name": "REPORT"
    }
  ]
}
```
or
```bash
curl -X POST "http://localhost:8080/toy-robot-simulator/api/simulate" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"commands\": [ { \"name\": \"PLACE\", \"args\": { \"location\": { \"x\": 0, \"y\": 0 }, \"facing\": \"SOUTH\" } }, { \"name\": \"MOVE\" }, { \"name\": \"MOVE\" }, { \"name\": \"REPORT\" } ]}"
```
response:
```json
{
  "position": {
    "location": {
      "x": 0,
      "y": 0
    },
    "facing": "SOUTH"
  }
}
```
-
request:
```json
{
  "commands": [
    {
      "name": "MOVE"
    },
    {
      "name": "REPORT"
    }
  ]
}
```
or
```bash
curl -X POST "http://localhost:8080/toy-robot-simulator/api/simulate" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"commands\": [ { \"name\": \"MOVE\" }, { \"name\": \"REPORT\" } ]}"
```
response:
```json
{
  "httpStatus": 400,
  "message": "ROBOT MISSING"
}
```

[java-download]: https://www.java.com/en/download/
[maven-download]: https://maven.apache.org/download.cgi

[api-docs]: http://localhost:8080/toy-robot-simulator/v2/api-docs
[swagger-ui]: http://localhost:8080/toy-robot-simulator/swagger-ui.html#/simulator-controller
