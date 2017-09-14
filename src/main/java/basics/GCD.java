package basics;

/**
 * Created by on 5/21/2017.
 */
public class GCD
{
	public static void main(String[] args){
		int a = 27, b = 18;
		while (b != 0){
			int rem = a % b;
			a = b;
			b = rem;
		}
		System.out.print(a);
	}
}
