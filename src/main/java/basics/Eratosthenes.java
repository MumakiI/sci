package basics;

import java.util.Arrays;

/**
 * Created by on 5/26/2017.
 */
public class Eratosthenes
{
	public static void main(String[] s){
		int n = 100000;
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		for (int i = 2; i < n; i ++)
			for(int j = i*2; j < n; j+=i)
				primes[j] = false;

		for (int i = n-1; i > 0; i--)
		{
			if (primes[i] == true)
			{
				System.out.println(i);
			}
		}
	}
}
