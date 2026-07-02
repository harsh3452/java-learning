import com.harsh.course.JUnitCourse;
import com.harsh.course.JavaCourse;
import com.harsh.course.SpringBootCourse;
import com.harsh.service.PurchaseCourse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestPurchaseCourse {
    @Test

    void testproceedWithCourse(){
        PurchaseCourse pc = new PurchaseCourse();
        assertTrue(pc.proceedWithCourse(new JavaCourse()));
     }
    @Test
    void testArrays(){
        int []expected = {1,2,3,4};
        int []actual = {4,3,2,1};
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
        //assertEquals(expected,actual); // fails as memory addresses are different

    }


}
