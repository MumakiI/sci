package recursion;

import java.util.Stack;

/**
 * Created by on 6/8/2017.
 */
public class HanoiTower
{
	public void move(Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux, int n) {

		if (n > 1)
			move(source, aux, target, n-1);

		target.push(source.pop());

		if (n > 1)
			move(aux, target, source, n-1);
	}
}
