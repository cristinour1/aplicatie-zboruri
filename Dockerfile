FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
# În loc de: RUN mvn clean package -DskipTests -Dmaven.resources.skip=true
RUN mvn clean package -DskipTests -Dmaven.main.skip=false

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]