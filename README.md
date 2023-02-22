# Graph

A basic scaffold integration of Java/GraalVM, Micronaut, Memgraph and Docker.

## Prerequisite

GraalVM
```agsl
% java -version
openjdk version "17.0.5" 2022-10-18
OpenJDK Runtime Environment GraalVM CE 22.3.0 (build 17.0.5+8-jvmci-22.3-b08)
OpenJDK 64-Bit Server VM GraalVM CE 22.3.0 (build 17.0.5+8-jvmci-22.3-b08, mixed mode, sharing)
```

Docker
```agsl
% docker --version
Docker version 20.10.22, build 3a2c30b
```

## Local Development

To bring up memgraph
```agsl
make memgraph
```

Run application
```agsl
make run
```

Application should now be available on http://localhost:8080

## Docker Compose

To start containers
```agsl
make up
```

To cleanup
```agsl
make down
```

To (re)build
```agsl
make build
```

Visit http://localhost:8080
