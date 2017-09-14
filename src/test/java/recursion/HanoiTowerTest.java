package recursion;

import java.util.Stack;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

/**
 * Created by on 6/8/2017.
 */
public class HanoiTowerTest
{
	@Test
	public void test(){
		HanoiTower ht = new HanoiTower();

		Stack<Integer> sourse = new Stack<>();
		sourse.push(1);
		sourse.push(2);
		sourse.push(3);
		sourse.push(4);
		Stack<Integer> target = new Stack<>();
		ht.move(sourse, target, new Stack<>(), 4);

		assertEquals(target.pop().intValue(), 4);
		assertEquals(target.pop().intValue(), 3);
		assertEquals(target.pop().intValue(), 2);
		assertEquals(target.pop().intValue(), 1);
	}
}
