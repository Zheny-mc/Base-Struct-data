package Task4;

import org.junit.Test;
import java.util.Stack;

import static junit.framework.Assert.assertEquals;

public class TestStack {

    @Test
    public void testPushPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1200);
        stack.push(1500);
        assertEquals("[1200, 1500]", stack.toString());
        assertEquals(1500, (int) stack.pop());
        assertEquals("[1200]", stack.toString());
    }
}
