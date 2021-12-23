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
        LinkedListStack<Integer> st1 = new LinkedListStack<>();
        LinkedListStack<Integer> st2 = new LinkedListStack<>();
        LinkedListStack<Integer> copy_st1 = new LinkedListStack<>();
        LinkedListStack<Integer> copy_st2 = new LinkedListStack<>();

        for (Integer i: testDataF) {
            st1.push(i);
            copy_st1.push(i);
        }

        for (Integer i: testDataS) {
            st2.push(i);
            copy_st2.push(i);
        }

        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        while(!st1.isEmpty()) {
            list.add(st1.pop());
        }

        while(!st2.isEmpty()) {
            list2.add(st2.pop());
        }

        for(int j = list2.size()-1; j >= 0; j--) {
            st1.push(list2.get(j));
        }

        for(int j = list.size()-1; j >= 0; j--) {
            st2.push(list.get(j));
        }

        assertEquals(copy_st1.toString(), st2.toString());
        assertEquals(copy_st2.toString(), st1.toString());
    }
}
