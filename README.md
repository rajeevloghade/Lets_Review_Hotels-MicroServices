# Project Name

Let's Review Hotels

# Installation

for installation of this project in your system 

1. Take checkout by using cmd 

	git checkout "https://github.com/rajeevloghade/Lets_Review_Hotels-Microservices.git"

# Usage

2. Import it in eclipce/Intellij and do update all project modules by maven update

3. To run the project. 

   First run centralized-config-server then service-discovery then api-gateway service and then rest of the services


# Microservice Concepts used in Let's Review Hotels : 

Service Discovery.

Feign Client.

API Gateway is responsible for several tasks, including:

    - Authentication and authorization
    - Load balancing
    - Request routing
    - Caching

Config Server (For centralized/externalized configuration) 

Circuit Breaker (Resillience4j) to handle Fault Tolerance (in which requested service is down). Resillience4j provides us three modules Circuit Breaker , Retry, and RateLimiter.

Okta for authentcation and authorization.

Feign Client/RestTemplate Interceptors.

# Project Description

The Let's Review Hotels project is an excellent example of how microservices architecture can be used to build a scalable and maintainable application. By using different microservices for specific responsibilities, such as user management, hotel rating, and hotel information, the application can be more modular and easier to maintain.

The project also makes use of various microservices concepts, such as Service Discovery, Feign Client, API Gateway, Config Server, and Circuit Breaker. The API Gateway acts as the entry point for all incoming requests, handling tasks such as authentication, authorization, and load balancing. The Config Server service provides centralized configuration, and the Service Discovery service helps to manage the different microservices and their endpoints, and Feign Client for communication between microservices

Circuit Breaker, which is implemented using Resilience4j, is used to handle fault tolerance when a requested service is down. It has three states: Close, Open, and Half-Open. The working of Circuit Breaker can be viewed in statistics using the actuator health endpoint. Retry can be used to retry requests to slow or down services. Rate Limiter allows for limiting access to certain services by limiting the number of calls processed in a specific window, providing both security and performance benefits.

Okta, a third-party tool, is used for authentication and authorization to secure APIs. Feign Client Interceptors hold requests and add an auth token to the header before redirecting to the relevant service.

Overall, the Let's Review Hotels project provides a practical example of how to build microservices-based applications, and it can serve as a useful reference for developers who are new to microservices architecture.

# Future Enhancements

We can enhance this project by incorporating various cutting-edge technologies, such as Docker, Kubernetes, Kafka, and AWS.
