package basics;

/**
 * Created by Anton_Markov on 7/27/2017.
 */
import java.util.Arrays;
public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];

		int i = 0;
		int j = nums.length-1;



		while (i<j) {

			if (nums[i]+nums[j] == target)
				break;

			if ((i+1) % 2 != 0)
				i++;
			else
				j--;
		}

		res[0] = i;
		res[1] = j;
		return res;
	}

	public static void main(String[] a) {

		System.out.print(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
		ChildIF cI = null;
		ParentIF pI = null;
		OtherIF oI = null;
		ChildCL cL = null;
		ParentCL pL = null;
		OtherCL oC = null;

		//cI = oI;
	}
}
interface ParentIF{}
interface ChildIF extends ParentIF{}
interface OtherIF{}

class ParentCL{}
class ChildCL extends ParentCL{}
class OtherCL{}