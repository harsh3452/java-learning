import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReverseTest {
    @Test
    public void testReverseString(){
        Reverse reverse = new Reverse();
        String actual = reverse.reverseString("Harsh");
        String expected = "hsraH";
        assertEquals(expected,actual);
    }
    @Test
    void emptyString() {
        Reverse r = new Reverse();
        assertEquals("", r.reverseString(""));
    }
    @Test
    void oneCharacter() {
        Reverse r = new Reverse();
        assertEquals("a", r.reverseString("a"));
    }

    @Test
    void palindrome() {
        Reverse r = new Reverse();
        assertEquals("madam", r.reverseString("madam"));
    }
    @Test
    void normalWord() {
        Reverse r = new Reverse();
        assertEquals("olleh", r.reverseString("hello"));
    }
}
