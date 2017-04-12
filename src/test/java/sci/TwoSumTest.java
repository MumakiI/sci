package sci;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Anton on 4/8/2017.
 */
public class TwoSumTest {

    @Test
    public void test() {
        assertEquals("[1, 2]", Arrays.toString(new TwoSum().twoSum(new int[]{3,2,4}, 6)));
        assertEquals("[0, 1]", Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        assertEquals("[0, 1]", Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
    }
}
