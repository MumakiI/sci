package basics;

/**
 * Created by Anton_Markov on 5/21/2017.
 */
public class GCD
{
	public static void main(String[] args){
		int a = 12, b = 8;
		while (b != 0){
			int rem = a % b;
			a = b;
			b = rem;
		}
		System.out.print(a);
	}
}
