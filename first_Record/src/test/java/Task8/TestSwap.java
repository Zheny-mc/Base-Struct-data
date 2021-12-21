package Task8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class TestSwap {

    private List<Integer> testDataF;
    private List<Integer> testDataS;

    @Before
    public void init() {
        testDataF = Arrays.asList(600, 1200, 1500, 2100);
        testDataS = Arrays.asList(6, 12, 15, 21);
    }

    @Test
    public void testSwap() {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> copy_st1 = new Stack<>();
        Stack<Integer> copy_st2 = new Stack<>();

        for (Integer i: testDataF) {
            st1.push(i);
            copy_st1.push(i);
        }

        for (Integer i: testDataS) {
            st2.push(i);
            copy_st2.push(i);
        }

        Iterator<Integer> i = st1.iterator();
        Iterator<Integer> i2 = st2.iterator();

        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        while(i.hasNext()) {
            list.add(i.next());
        }

        while(i2.hasNext()) {
            list2.add(i2.next());
        }

        st1.clear();

        for(int j = 0; j < list2.size(); j++) {
            st1.push(list2.get(j));
        }

        st2.clear();

        for(int j = 0; j < list.size(); j++) {
            st2.push(list.get(j));
        }

        assertEquals(copy_st1, st2);
        assertEquals(copy_st2, st1);
    }
}
