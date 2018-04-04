package cz.ladicek.swarm.reproducer.SWARM_1929;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class HelloService {
    private int counter;

    @CircuitBreaker
    @Fallback(HelloFallback.class)
    public String performSomeRequest() throws IOException {
        counter++;
        throw new IOException("Simulated IO error");
    }

    public int getCounter() {
        return counter;
    }
}
