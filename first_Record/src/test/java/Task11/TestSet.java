package Task11;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class TestSet {
    private List<Integer> testData1;
    private List<Integer> testData2;
    private MySet<Integer> mySet;

    @Before
    public void init() {
        testData1 = Arrays.asList(600, 1200, 1500, 2100);
        testData2 = Arrays.asList(600, 100, 650, 2100);
        mySet = new MySet<Integer>();
    }

    @Test
    public void testUnion() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //инициализация множеств
        for (int i = 0; i < testData1.size(); i++) {
            set1.add(testData1.get(i));
            set2.add(testData2.get(i));
        }

        Set<Set<Integer>> mainSet = new HashSet<Set<Integer>>();
        mainSet.add(set1);
        mainSet.add(set2);

        Set<Integer> resSet = mySet.union(mainSet);
        assertEquals("[1200, 2100, 100, 600, 650, 1500]", resSet.toString());
    }

    @Test
    public void testIntersection() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //инициализация множеств
        for (int i = 0; i < testData1.size(); i++) {
            set1.add(testData1.get(i));
            set2.add(testData2.get(i));
        }

        Set<Set<Integer>> mainSet = new HashSet<Set<Integer>>();
        mainSet.add(set1);
        mainSet.add(set2);

        Optional<HashSet<Integer>> resSet = mySet.intersection(mainSet);
        assertEquals("[2100, 600]", resSet.get().toString());
    }

}
