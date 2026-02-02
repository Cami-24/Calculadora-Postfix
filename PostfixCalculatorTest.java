import org.junit.Assert;
import org.junit.Test;

public class PostfixCalculatorTest {

    @Test
    public void testSimpleAddition() {
        PostfixCalculator calc = new PostfixCalculator();
        Assert.assertTrue(calc.evaluate("1 2 +") == 3);
    }

    @Test
    public void testExampleFromSheet() {
        PostfixCalculator calc = new PostfixCalculator();
        Assert.assertTrue(calc.evaluate("1 2 + 4 * 3 +") == 15);
    }

    @Test
    public void testAnotherExpression() {
        PostfixCalculator calc = new PostfixCalculator();
        Assert.assertTrue(calc.evaluate("6 2 3 + *") == 30);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        PostfixCalculator calc = new PostfixCalculator();
        calc.evaluate("4 0 /");
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidOperator() {
        PostfixCalculator calc = new PostfixCalculator();
        calc.evaluate("2 3 &");
    }
}




