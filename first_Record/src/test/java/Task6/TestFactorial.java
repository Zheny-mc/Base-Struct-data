package Task6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestFactorial {
    private Integer testData;

    @Before
    public void init() {
        testData = 5;
    }

    @Test
    public void testFactorial() {
        assertEquals((Integer)120, Factorial.calc(testData));
    }
}
