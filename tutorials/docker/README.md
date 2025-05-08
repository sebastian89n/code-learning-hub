# Docker

Docker is a platform for developing, shipping, and running applications in containers, which are self-contained,
isolated environments that encapsulate an application and its dependencies. This containerization technology simplifies
software deployment, scaling, and management, ensuring consistent performance across different computing environments.

### Docker commands

- **Image Management:**
    - `docker pull <image_name>`: Pull a Docker image from a registry.
    - `docker build -t <image_name> .`: Build a Docker image from a Dockerfile.
    - `docker images`: List all Docker images on your system.
    - `docker rmi <image_name>`: Remove a Docker image.

- **Container Lifecycle:**
    - `docker run -it <image_name>`: Create and start a new container from an image.
    - `docker start <container_id>`: Start a stopped container.
    - `docker stop <container_id>`: Stop a running container.
    - `docker restart <container_id>`: Restart a container.
    - `docker rm <container_id>`: Remove a stopped container.
    - `docker ps`: List running containers.
    - `docker ps -a`: List all containers (including stopped ones).

- **Container Interaction:**
    - `docker exec -it <container_id> <command>`: Execute a command inside a running container.
    - `docker logs <container_id>`: View the logs of a container.
    - `docker cp <container_id>:<src_path> <dest_path>`: Copy files between your host and a container.

- **Networking:**
    - `docker network ls`: List Docker networks.
    - `docker network create <network_name>`: Create a custom Docker network.
    - `docker run --network=<network_name> <image_name>`: Connect a container to a specific network.

- **Volume Management:**
    - `docker volume ls`: List Docker volumes.
    - `docker volume create <volume_name>`: Create a Docker volume.
    - `docker run -v <volume_name>:<container_path> <image_name>`: Mount a volume in a container.

- **Docker Compose:**
    - `docker-compose up`: Start services defined in a Docker Compose file.
    - `docker-compose down`: Stop and remove containers defined in a Docker Compose file.
    - `docker-compose ps`: List containers managed by Docker Compose.

- **Registry and Repository:**
    - `docker login`: Log in to a Docker registry.
    - `docker push <image_name>`: Push a Docker image to a registry.
    - `docker tag <image_id> <new_image_name>`: Tag an image for a registry.

- **Cleaning Up:**
    - `docker system prune`: Remove all stopped containers, unused networks, and dangling images.
    - `docker volume prune`: Remove all unused volumes.

- **Docker Info:**
    - `docker version`: Show Docker version information.
    - `docker info`: Display Docker system-wide information.

Remember to replace placeholders like `<image_name>`, `<container_id>`, and `<network_name>` with your specific values
when using these commands. These commands will help you work with Docker as a Java developer.

### Sample Dockerfile

```shell
# Use a base image with Java and Maven to build the application
FROM maven:3.8-openjdk-11 AS build

WORKDIR /app

# Copy the project files to the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package

# Use a lightweight JRE image to run the application
FROM openjdk:11-jre-slim

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/myapp.jar .

# Define the command to run the Java application
CMD ["java", "-jar", "myapp.jar"]
```

### Sample docker-compose.yml

```yaml
version: '3.8'
services:
  myapp:
    build:
      context: ./myapp
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    environment:
      DATABASE_URL: "jdbc:postgresql://postgres:5432/myappdb"
      DATABASE_USER: myappuser
      DATABASE_PASSWORD: myapppassword
  postgres:
    image: postgres:13
    environment:
      POSTGRES_USER: myappuser
      POSTGRES_PASSWORD: myapppassword
      POSTGRES_DB: myappdb
    volumes:
      - postgres-data:/var/lib/postgresql/data
  volumes:
    postgres-data:
```

### Docker core concepts

- **Docker Containers:**
    - Containers are lightweight, standalone, and executable packages that encapsulate applications and their
      dependencies, ensuring consistency across different environments.

- **Docker Images:**
    - Images are read-only templates for creating containers. They contain the application code, libraries, and runtime
      needed to run an application.

- **Dockerfile:**
    - A Dockerfile is a script that defines how to build a Docker image. It specifies the base image, application code,
      environment variables, and runtime configuration.

- **Docker Hub:**
    - Docker Hub is a public registry that hosts thousands of pre-built Docker images, allowing developers to share and
      distribute container images.

- **Containerization:**
    - Containerization is the practice of packaging an application and its dependencies into a container, ensuring
      isolation and portability.

- **Docker Compose:**
    - Docker Compose is a tool for defining and running multi-container applications. It allows developers to manage
      complex applications as a group of interconnected services.

- **Docker Networking:**
    - Docker provides network isolation for containers, allowing them to communicate with each other and the external
      world. Developers can create custom networks for containers.

- **Docker Volumes:**
    - Docker volumes are a way to persist and share data between containers and the host system, ensuring data
      durability.

- **Registry and Repository:**
    - A Docker registry is a repository for Docker images, and a Docker repository is a collection of related Docker
      images tagged with version information.

- **Orchestration (e.g., Docker Swarm and Kubernetes):**
    - Docker Swarm and Kubernetes are container orchestration tools that help manage and scale containerized
      applications across multiple hosts.

- **Docker Security:**
    - Docker provides security features like user namespaces, seccomp profiles, and container image scanning to ensure
      secure containerization.

- **Docker CLI (Command Line Interface):**
    - The Docker CLI is a command-line tool used to interact with Docker, allowing developers to manage containers,
      images, and other Docker resources.

These core Docker concepts are essential for software developers to effectively work with container technology.