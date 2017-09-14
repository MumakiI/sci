package basics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton_Markov on 8/10/2017.
 */
public class LongestCommonPrefix
{
	static public String longestCommonPrefix(String[] strs) {
		Map<String,Integer> map = new HashMap<>();

		for (String s : strs) {
			for (int i = 1; i <= s.length(); i++) {
				map.merge(s.substring(0,i), 1, (a, b) ->a+b);
			}
		}
		return map.keySet().stream().reduce((a, b) ->
		{if (map.get(a)> map.get(b))
			return  a;
		else return b;

		}
		).orElse("");


	}

	public static void main(String a[]) {
		System.out.print(longestCommonPrefix(
				new String[]{

				"abc",
				"a",
				"ab",
				"abcde"}
		));
	}
}
