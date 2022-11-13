package strings.test;

import static org.junit.Assert.assertArrayEquals;

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
            String exampleData[] = Utils.filler();
            String sortedResult[] = Algorithm.sort(exampleData);
            
            Arrays.sort(exampleData);
            System.out.println("Expected: " + exampleData + ", got " + sortedResult);
            assertArrayEquals(exampleData, sortedResult);

            

        }
    }
}
