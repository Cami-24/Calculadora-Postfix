import org.junit.Assert;
import org.junit.Test;

public class VectorStackTest {

    @Test
    public void testPushAndPop() {
        IStack<Integer> stack = new VectorStack<Integer>();
        stack.push(1);
        stack.push(2);

        Assert.assertTrue(stack.pop() == 2);
        Assert.assertTrue(stack.pop() == 1);
    }

    @Test
    public void testPeek() {
        IStack<Integer> stack = new VectorStack<Integer>();
        stack.push(5);

        Assert.assertTrue(stack.peek() == 5);
        Assert.assertTrue(stack.size() == 1);
    }

    @Test(expected = RuntimeException.class)
    public void testPopEmptyStack() {
        IStack<Integer> stack = new VectorStack<Integer>();
        stack.pop();
    }
}


