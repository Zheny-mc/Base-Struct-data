package Task13;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestMNK {
    private List<Double> U;
    private List<Double> J;

    @Before
    public void init() {
        U = Arrays.asList(5.,  6.,  7.,   8.,  9.,   10.,   11.,   12.,  13.,  14.);
        J = Arrays.asList(0.5, 1.1, 1.45, 2. , 2.51, 3.01, 3.55, 4.1, 4.5, 4.95);
    }

    @Test
    public void testMnk() {
        int n = 10;
        LinkedList<Double> u = new LinkedList<>(U);
        LinkedList<Double> j = new LinkedList<>(J);
        LinkedList<Double> q = MNK.run(u,j,n);

        LinkedList<Double> r = new LinkedList<>();
        for (int i = n-1; i >= 0; i--) {
            r.addFirst(u.get(i) / j.get(i));
            System.out.println(String.format("r[%d] = %.3f", i+1, r.get(i)));
        }

        double test_u = 9.5;
        //R_test = u_test / j
        //j = a * u_test + b
        double r_test = test_u / (q.get(0)*test_u + q.get(1));
        System.out.println(String.format("R_test = %.3f, " +
                        "\nкоторый находиться в интервале [r[5]; r[6]]",
                r_test));

        assertEquals("3,433", String.format("%.3f", r_test));
    }
}
