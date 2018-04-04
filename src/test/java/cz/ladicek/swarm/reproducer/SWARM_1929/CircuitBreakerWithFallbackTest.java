package cz.ladicek.swarm.reproducer.SWARM_1929;

import org.apache.http.client.fluent.Request;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@DefaultDeployment
public class CircuitBreakerWithFallbackTest {
    @Test
    @RunAsClient
    public void circuitBreakerShouldOpen() throws IOException {
        // all 30 calls to the business method fail, and after the first 20, the circuit breaker should open
        //
        // when the circuit breaker is open, the business method isn't called at all, so the number of invocations
        // of the business method should be exactly 20

        for (int i = 0; i < 30; i++) {
            Request.Get("http://localhost:8080/?op=call").execute().discardContent();
        }

        String count = Request.Get("http://localhost:8080/?op=count").execute().returnContent().asString();
        assertEquals("20", count);
    }
}
