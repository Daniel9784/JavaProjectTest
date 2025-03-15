import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAnotherOneTest {

    private ArrayListNumbersAnotherOne test;

    @BeforeEach
    public void setUp() {
        test = new ArrayListNumbersAnotherOne();
    }

    @Test
    public void testRoundToTwoDecimalPlaces() {
        // Test zaokruhlovania
        assertEquals(12.35, test.roundToTwoDecimalPlaces2(12.345), 0.0001);
        assertEquals(12.34, test.roundToTwoDecimalPlaces2(12.344), 0.0001);
    }

    @Test
    public void testCalculateSum() {
       // Nastavime hodnoty pre sucet
        setNumbers(10.5, 20.3, 5.2);
        double expectedSum = 10.5 + 20.3 + 5.2;
        assertEquals(expectedSum, test.calculateSum(), 0.0001);
    }

    // Metoda na nastavenie hodnot (nechapem ju)
    private void setNumbers(Double... values) {
        try {
            var field = ArrayListNumbersAnotherOne.class.getDeclaredField("numbers");
            field.setAccessible(true);
            field.set(test, new ArrayList<>(List.of(values)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
