package cz.ladicek.swarm.reproducer.SWARM_1929;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class HelloFallback implements FallbackHandler<String> {
    @Override
    public String handle(ExecutionContext context) {
        return "Fallback";
    }
}
