package basics;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by on 6/2/2017.
 */
public class ThreePrimeFactors
{
	public static int removeMin(Queue<Integer> q)
	{
		int min = q.peek();
		for (Integer v : q)
		{
			if (min > v)
			{
				min = v;
			}
		}
		while (q.contains(min))
		{
			q.remove(min);
		}
		return min;
	}

	public static void addProducts(Queue<Integer> q, int v)
	{
		q.add(v * 3);
		q.add(v * 5);
		q.add(v * 7);
	}

	public static int getKthMagicNumber(int k)
	{
		if (k < 0)
			return 0;

		int val = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		addProducts(q, 1);
		for (int i = 0; i < k; i++)
		{
			val = removeMin(q);
			addProducts(q, val);
		}
		return val;
	}
	public static void main(String[] s){
		System.out.print(getKthMagicNumber(7));
	}
}
