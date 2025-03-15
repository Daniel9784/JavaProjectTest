package sk.tmconsulting.testy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;
    private CircleMain circlemain;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // Inicializujeme objekt pred každým testom
        circlemain = new CircleMain();
    }

    @Test
    void testAreaCircle() {
        assertEquals(78.54, circlemain.calculateArea(5),0.01);
        assertEquals(452.39, circlemain.calculateArea(12),0.01);

    }

    @Test
    void testCircumference() {
        assertEquals(31.42, circlemain.calculateCircumference(5),0.01);
        assertEquals(75.4, circlemain.calculateCircumference(12),0.01);

    }

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(-1,1));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-5, calculator.subtract(-2, 3));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-6, calculator.multiply(-2, 3));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(-6, 3));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

