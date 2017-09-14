package basics;

/**
 * Created by Anton_Markov on 6/9/2017.
 */
public class PalindromeNumper
{
	static public boolean isPalindrome(int x)
	{
		if(x<0)
			return false;
		if (x == 0)
			return true;
		long inv = 0;
		int power = getMaxPower(x);

		int k = 0;
		int t = x;
		while (power >= 0 && x>0)
		{
			inv = (long) (inv + ((int)(x/Math.pow(10, power)))*Math.pow(10, k++));
			x = (int) (x % Math.pow(10, power));
			power--;
		}
		return t == inv;
	}

	private static int getMaxPower(int t)
	{
		int maxPower = 0;
		while (t>=10)  {
			maxPower++;
			t = t/10;
		}
		return maxPower;
	}

	public static boolean isPalindrome2(int x) {
		if (x<0 || (x!=0 && x%10==0)) return false;
		int rev = 0;
		while (x>rev){
			rev = rev*10 + x%10;
			x = x/10;
		}
		return (x==rev || x==rev/10);
	}

	public static void main(String a[])
	{
		System.out.print(isPalindrome2(252));
	}
}
