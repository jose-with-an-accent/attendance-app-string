package strings;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import strings.App;

import org.junit.Test;

public class StringTest {
    @Test
    public void basicTest() {
        String sortedExpected[] = {"aamir","aman","callie","jose","luis"};
        String test[] = {"aamir","luis","aman","callie","jose"};
        String sorted[] = App.sort(test);
        
        assertArrayEquals(sortedExpected, sorted);
    }
    @Test
    public void autoTest() {
        for (int i = 0; i < 4; i++) {
            String exampleData[] = Utils.filler();
            String sortedResult[] = App.sort(exampleData);
            
            Arrays.sort(exampleData);

            assertArrayEquals(exampleData, sortedResult);

            

        }
    }
}
