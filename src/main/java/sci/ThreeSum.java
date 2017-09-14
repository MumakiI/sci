package sci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Anton on 4/10/2017.
 */
public class ThreeSum {

    public static void main(String[] a) {
        threeSum(new int[]{-1, -1,0,1});
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        int k = 0;
        Arrays.sort(nums);

        while (k<nums.length-2) {
            if (k==0 || nums[k] != nums[k-1]) {
                int t = nums[k];
                int i = k+1; int j = nums.length - 1;

                while (i < j) {
                    if (t + nums[i] + nums[j] == 0) {
                        result.add(Arrays.asList(t, nums[i], nums[j]));

                        while (i<j && nums[i] == nums[i+1])
                            i++;
                        while (i< j && nums[j] == nums[j-1])
                            j--;
                        i++;
                        j--;

                    } else if (nums[i] + nums[j] > t)
                        j--;
                    else i++;
                }
            }
            k++;
        }

        return result;
    }
}
