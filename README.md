# Learn Java Spring Framework

## Introduction 
The project is for experiencing the Java Spring Boot 2 framework and take some basic knowledge from the practice.

The code was implemented by watching this [video](https://www.youtube.com/watch?v=vtPkZShrvXQ),
and including the homework that given by the video.

## Need
- java SDK 11
- mvn
- postgres
- docker (optional)

## run 
start your postgres service and create a database name `app` before starting the program

```
mvn install
java -jar target/Demo-xxxx.jar
```

## Memo

have to install `javax` after get the package from spring boot website, which is not including in the video
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

hav to install the migration and postgres relative dependencies.
```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>

    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>

    <dependency> <!-- database migrations -->
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
    </dependency>
```

to start a postgres by docker
```
docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine
```
