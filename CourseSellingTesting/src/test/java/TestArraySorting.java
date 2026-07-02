import com.harsh.service.SortingService;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TestArraySorting {

    TestArraySorting(){
        System.out.println("Calling Constructor");
    }
    SortingService sorter;

    @BeforeAll
    static void BeforeAll(){
        System.out.println("Before All Test ");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("After all test");
    }

    @BeforeEach
    void init(){
         sorter = new SortingService();
        System.out.println("Before each test");
    }

    @AfterEach
    void destroy(){
        System.out.println("After each test");
    }

    @Test
    void shouldSortArrayWithinTimeLimit(){
        int[] a = {13,45,33,2,5};
        assertTimeout(Duration.ofMillis(2),()->sorter.sortingArray(a));
        System.out.println("I am test");
    }
    @Test
    void shouldThrowExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class,()->sorter.sortingArray(null));
        System.out.println("I am test 2");
    }
}
