package elementary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anton_Markov on 6/13/2017.
 */
public class FindAllNumbersDisappearedInAnArray
{
	static public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i=0; i<nums.length; i++) {
			nums[Math.abs(nums[i])-1] = - Math.abs(nums[Math.abs(nums[i])-1]);
		}
		for (int i=0; i<nums.length; i++) {
			if (nums[i]>0)
				res.add(i+1);
		}
		return res;
	}

	public static void main(String[] a)
	{
		findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}).stream().forEach(i-> System.out.print(i));
	}
}
