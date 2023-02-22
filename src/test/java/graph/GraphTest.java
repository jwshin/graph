package graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class GraphTest {

    @Inject EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void testApplicationStatus() {
        assertTrue(application.isRunning());
    }

    @Test
    void testIndexHttpClient() {
        BlockingHttpClient client = httpClient.toBlocking();
        HttpRequest<Object> request = HttpRequest.GET("/");
        HttpResponse<String> rsp = client.exchange(request, String.class);

        assertEquals(HttpStatus.OK, rsp.getStatus());
        assertTrue(rsp.getBody().orElse("").startsWith("<!doctype html>"));
    }
}
