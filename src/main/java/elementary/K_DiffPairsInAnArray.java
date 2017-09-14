package elementary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Anton_Markov on 6/13/2017.
 */
public class K_DiffPairsInAnArray
{
	static public int findPairs(int[] nums, int k)
	{
		HashMap<Integer, Integer> map = new HashMap<>();

		for (Integer i : nums)
		{
			Integer v = map.get(i);
			if (v == null)
				map.put(i, 0);

			int candidate = (i<k)? i + k : i-k;
			if (map.get(candidate) != null)
			{
				map.put(candidate, map.get(candidate) + 1);
			}
			//				candidate = i - k;
			//				if (map.get(candidate) != null)
			//				{
			//					map.put(candidate, map.get(candidate) + 1);
			//				}

		}
		return map.values().stream().filter(a -> a != null).mapToInt(i -> i.intValue()).sum();
	}

	public static void main(String[] a)
	{
		System.out.print(findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));
	}
}
