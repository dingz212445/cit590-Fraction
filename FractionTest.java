package fraction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {
    Fraction f;

    @Before
    public void setUp() throws Exception {
        f = new Fraction(1, 2);
    }

    @Test
    public void testAdd() {
        Fraction g = f.add(new Fraction(1, 3));
        assertEquals(new Fraction(5, 6), g); 
        assertEquals(new Fraction("5/6"), g); 
        
        assertEquals(new Fraction(3), f.add(new Fraction(5, 2)));
    }
    
    @Test
    public void testSubtract() {
        Fraction g = f.subtract(new Fraction(1, 3));
        assertEquals(new Fraction(1, 6), g);
    }
    
    @Test
    public void testMultiply() {
        Fraction g = f.multiply(new Fraction(3, 5));
        assertEquals(new Fraction(3, 10), g);
    }
    
    @Test
    public void testDivide() {
        Fraction g = f.divide(new Fraction(2, 3));
        assertEquals(new Fraction(3, 4), g);
        assertEquals(new Fraction("6/ 8"), g);
    }
    
    @Test(expected=ArithmeticException.class)
    public void testDivideByZero() {
        new Fraction(1, 0);
    }
    
    @Test
    public void testAbs() {
        Fraction g = new Fraction(1, -2);
        assertEquals(new Fraction(1, 2), g.abs());   
    }

    @Test
    public void testNegate() {
        assertEquals(new Fraction(-1, 2), f.negate());
        assertEquals(new Fraction(3, -6), f.negate());
    }
}
