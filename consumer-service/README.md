# Consumer Service
The purpose of this project is to consume a simple REST API over HTTP.

## Development Steps 

Create Spring Boot project with Web, devtool and actuator dependencies using spring.io

Added Rest service using Spring Boot RESTController

Added Swagger2 support  

Added Docker support


# Docker

###Build 
```
docker build -t synrgroup/consumer-service-demo-01 .
```

###RUN
```
docker run -p 8081:8081 --name consumer-server-container consumer-server-image
```
### Push images to Dockerhub

```
docker commit <contanier-id> <repo-name>:<tag>
docker push <repo-name>:<tag>
Example:
docker commit 99d9364ffd5f synrgroup/consumer-service-demo-01:1
docker commit 99d9364ffd5f synrgroup/consumer-service-demo-01:latest
```