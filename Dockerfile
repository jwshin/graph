FROM ghcr.io/graalvm/graalvm-ce:ol9-java17 AS build
COPY . /app
WORKDIR /app
RUN /app/gradlew nativeOptimizedCompile

FROM oraclelinux:9-slim
EXPOSE 8080
RUN mkdir /app
COPY --from=build /app/build/native/nativeOptimizedCompile/graph /app/graph
ENTRYPOINT ["/app/graph"]
