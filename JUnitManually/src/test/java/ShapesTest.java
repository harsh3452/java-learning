import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
public class ShapesTest {
    Shapes shape = new Shapes();
    @Test
    public void testSquareArea(){
        assertEquals(100,shape.computeSquareArea(10));
    }
}
