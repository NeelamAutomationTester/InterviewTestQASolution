import org.junit.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assert calc.add(5, 3) == 8;
    }

    @Test
    public void testSubtract() {
        assert calc.subtract(5, 3) == 2;
        assert calc.subtract(6, 10) == -4;
    }

    @Test
    public void testMultiply() {
        assert calc.multiply(5, 3) == 15;
    }

    @Test
    public void testDivide() {
        assert calc.divide(10, 2) == 5;
        try{
            calc.divide(10,0);
        }catch(IllegalArgumentException e){
            assert e.getMessage().equals("Cannot divide by zero");
        }
    }

    @Test
    public void testSquare() {
        assert calc.square(5) == 25;
    }

    @Test
    public void testSquareRoot() {
        assert calc.squareRoot(25) == 5;
        try{
            calc.squareRoot(-1);
        }catch(IllegalArgumentException e){
            assert e.getMessage().equals("Cannot calculate square root of a negative number");
        }
    }

}
