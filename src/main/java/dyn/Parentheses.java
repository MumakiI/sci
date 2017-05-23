package dyn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anton_Markov on 5/22/2017.
 */
public class Parentheses
{
	List<String> generateParenthesis(int n) {
		List<String> l = new ArrayList<>();
		if (n==1)
		{
			l.add("()");
			return l;
		}

		List<String> sls = generateParenthesis(n-1);

		for (String sl : sls)
		{
			l.add("(" + sl + ")");

			String s1 = sl + "()";
			l.add(s1);
			String s2 = "()" + sl;
			if (!s1.equals(s2))
			l.add(s2);
		}
		Collections.sort(l);
	return l;
	}

	String getParenthesysWrap(int n) {
		if (n==1)
			return "{}";
		throw new IllegalStateException();
	}
	String getParenthesysApp(int n) {
		if (n==1)
			return "{}";
		throw new IllegalStateException();
	}
	public static void main(String[] s) {

		List<String> parenthesys = new Parentheses().generateParenthesis(4);
		for (String p : parenthesys)
		System.out.println(p);
	}
}
