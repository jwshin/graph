package graph;

import static org.neo4j.driver.Values.parameters;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import java.util.Collections;
import java.util.Map;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Query;

@Controller
public class HelloController {
    private final Driver driver;

    public HelloController(Driver driver) {
        this.driver = driver;
    }

    @View("index")
    @Get()
    public Map<String, Object> index() {
        String message = "hello from memgraph";
        try (var session = driver.session()) {
            var hello =
                    session.writeTransaction(
                            transaction -> {
                                var query =
                                        new Query(
                                                "CREATE (a:Greeting) SET a.message = $message RETURN 'Node ' + id(a) + ': ' + a.message",
                                                parameters("message", message));
                                var result = transaction.run(query);
                                return result.single().get(0).asString();
                            });

            return Collections.singletonMap("message", hello);
        }
    }
}
