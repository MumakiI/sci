package sci;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Anton on 4/10/2017.
 */
public class ThreSum {
    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < nums.length-1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                List<List<Integer>> candidates =  map.get(nums[i] + nums[j]);
                if (candidates == null) {
                    candidates = new ArrayList<>();
                    map.put(nums[i] + nums[j], candidates);
                }
                candidates.add(Stream.of(nums[i], nums[j]).collect(Collectors.toList()));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> set = new HashSet();

        for (int c : nums)
            set.add(c);

        for (int c : set)
        {
            List<List<Integer>> candidate = map.get(-c);
            if (candidate != null)
            {
                for (List list : candidate) {
                    list.add(c);
                    result.add(list);
                }
            }
        }

        return result;
    }
}
