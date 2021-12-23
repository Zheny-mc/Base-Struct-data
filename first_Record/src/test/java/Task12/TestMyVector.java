package Task12;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestMyVector {

    private List<Double> testData;

    @Before
    public void init() {
        testData = Arrays.asList(2.3, 5.0, 7.3);
    }

    @Test
    public void testAddGet() {
        MyVector<Double> vec = new MyVector<Double>();

        for (Double i: testData)
            vec.add(i);

        String res = "";
        for (int i = 0; i < vec.size(); i++) {
            res += vec.get(i) + " ";
        }

        assertEquals("2.3 5.0 7.3 ", res);
    }

}
