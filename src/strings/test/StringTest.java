package strings.test;

import static org.junit.Assert.assertArrayEquals;

import java.time.Instant;
import java.util.Arrays;

import strings.Algorithm;
import strings.Utils;

import org.junit.Test;

public class StringTest {
    @Test
    public void basicTest() {
        String sortedExpected[] = {"aamir","aman","callie","jose","luis"};
        String test[] = {"aamir","luis","aman","callie","jose"};
        String sorted[] = Algorithm.sort(test);
        
        assertArrayEquals(sortedExpected, sorted);
    }
    @Test
    public void autoTest() {
        for (int i = 0; i < 4; i++) {
            String exampleData[] = Utils.filler(50, 10);
            String sortedResult[] = Algorithm.sort(exampleData);
            
            Arrays.sort(exampleData);
            System.out.println("Expected: " + exampleData + ", got " + sortedResult);
            assertArrayEquals(exampleData, sortedResult);

            

        }
    }
    @Test
    public void longTest() {
        int ARR_LENGTH = 500;
        int STR_LENGTH = 30;

        long before = Instant.now().toEpochMilli();

        String exampleData[] = Utils.filler(50, 10);
        String sortedResult[] = Algorithm.sort(exampleData);
        Arrays.sort(exampleData);

        long milliseconds = Instant.now().minusMillis(before).toEpochMilli();

        System.out.println("Took " + milliseconds + "ms to sort " + ARR_LENGTH + " strings with length " + STR_LENGTH);

        assertArrayEquals(exampleData, sortedResult);
    }
}
