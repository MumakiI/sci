package elementary;

import java.util.Arrays;

/**
 * Created by Anton_Markov on 6/13/2017.
 */
public class ArrayPartitionI
{
	static public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int r = 0;
		for (int i = 0; i < nums.length - 1; i+=2)
		{
			r+= Math.min(nums[i+1],  nums[i]);
		}
		return r;
	}

	public static void main(String[] a)
	{
		System.out.print(arrayPairSum(new int[]  {1,4,3,2}));
	}
}
