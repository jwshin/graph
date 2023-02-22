.PHONY: run memgraph format up down build clean check

run:
	./gradlew run

clean:
	./gradlew clean 

check:
	./gradlew check

memgraph:
	docker run -it -p 7687:7687 -p 7444:7444 -p 3000:3000 -v mg_lib:/var/lib/memgraph --env MEMGRAPH="--bolt-server-name-for-init=Neo4j/" memgraph/memgraph-platform

format:
	./gradlew spotlessApply

up:
	docker compose up

down:
	docker compose down

build:
	docker compose build
