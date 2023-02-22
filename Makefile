.PHONY: run memgraph spotless up down build

run:
	./gradlew run

memgraph:
	docker run -it -p 7687:7687 -p 7444:7444 -p 3000:3000 -v mg_lib:/var/lib/memgraph --env MEMGRAPH="--bolt-server-name-for-init=Neo4j/" memgraph/memgraph-platform

spotless:
	./gradlew spotlessApply

up:
	docker compose up

down:
	docker compose down

build:
	docker compose build
