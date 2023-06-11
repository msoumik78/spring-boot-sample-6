package karate;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KarateRunner {
    @Test
    void testParallel() {
        Results results = Runner.path("classpath:features").tags("~@ignore").parallel(1);
        assertEquals(0, results.getFailCount(), "there are scenario failures");
    }
}
