import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class ArrayListNumbersTest {


    @Test
    public void roundToTwoDecimalPlacesTest(){
    assertEquals(12.35, ArrayListNumbers.roundToTwoDecimalPlaces(12.345));
    assertEquals(12, ArrayListNumbers.roundToTwoDecimalPlaces(11.995));
    }

}
