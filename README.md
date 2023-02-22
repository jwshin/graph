# Graph

A basic scaffold integration of Java/GraalVM, Micronaut, Memgraph and Docker.

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
