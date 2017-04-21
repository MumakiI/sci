package sci;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Anton on 4/10/2017.
 */
public class ThreSum {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3)
            return Collections.emptyList();

        HashMap<Integer, List<List<Integer>>> supplementMap = new HashMap<>();

        String combinations = "";


        // create all possible pairs of numbers
        // calculate possible supplement for each pair
        for (int i = 0; i < nums.length-1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                List<List<Integer>> candidates =  supplementMap.get(nums[i] + nums[j]);
                if (candidates == null) {
                    candidates = new ArrayList<>();
                    supplementMap.put(nums[i] + nums[j], candidates);
                }
                candidates.add(Stream.of(nums[i], nums[j]).collect(Collectors.toList()));
            }
        }

        // calculate counts of repetition for every number
        // if we know count we may decide if possible supplement is not included in the pair itself
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            Integer c = 0;
            if (counts.containsKey(nums[i])) {
                c = counts.get(nums[i]);
            }
            counts.put(nums[i], ++c);
        }

        List<List<Integer>> result = new ArrayList<>();

        // consider every number as a possible supplement for all possible pairs
        Set<Integer> set = new HashSet();
        for (int c : nums)
            set.add(c);

        for (int c : set)
        {
            List<List<Integer>> candidate = supplementMap.get(-c);

            if (candidate != null)
            {
                //supplement found
                // sort out not unique combinations
                Integer count = counts.get(c);

                for (List<Integer> list : candidate) {
                    int inlist = 0;
                    if (list.get(0) == c)
                        inlist++;
                    if (list.get(1) == c)
                        inlist++;

                    if (count!=null && inlist < count)
                    {
                        list.add(c);
                        Collections.sort(list);

                        String unique = list.get(0) + "|" + list.get(1) + "|" + list.get(2);
                        if (!combinations.contains(unique))
                        {
                            combinations = combinations + unique + " ";
                            result.add(list);
                        }
                    }
                }
                supplementMap.remove(-c);
            }
        }
        return result;
    }
}
