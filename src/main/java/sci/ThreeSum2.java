package sci;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anton_Markov on 8/10/2017.
 */
public class ThreeSum2
{
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length-2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i-1])) {
				int lo = i+1, hi = num.length-1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo+1]) lo++;
						while (lo < hi && num[hi] == num[hi-1]) hi--;
						lo++; hi--;
					} else if (num[lo] + num[hi] < sum) lo++;
					else hi--;
				}
			}
		}
		return res;
	}
}
