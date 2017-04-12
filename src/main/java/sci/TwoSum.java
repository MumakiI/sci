package sci;

import java.util.HashMap;

/**
 * Created by Anton on 4/8/2017.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> candidates = new HashMap<>();
        HashMap<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (!candidates.containsKey(target - n)) {
                candidates.put(n, null);
                index.put(n, i);
            } else
                return new int[]{index.get(target - n), i};
        }
        return null;
    }
}
