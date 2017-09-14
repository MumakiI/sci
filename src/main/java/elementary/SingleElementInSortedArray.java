package elementary;

/**
 * Created by Anton_Markov on 6/12/2017.
 */
public class SingleElementInSortedArray
{
	static public int singleNonDuplicate(int[] nums)
	{
		// binary search
		int lo = 0, hi = nums.length / 2;
		while (lo < hi)
		{
			int m = (lo + hi) / 2;
			//Basically you want to find the first even-index number not followed by the same number
			if (nums[2 * m] != nums[2 * m + 1])
				hi = m;
			else
				lo = m + 1;
		}
		return nums[2 * lo];
	}

	public static void main(String[] a)
	{
		System.out.print(singleNonDuplicate(new int[] { 3, 3, 4, 7, 7}));
	}
}
