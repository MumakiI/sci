package basics;

import java.util.HashSet;

/**
 * Created by Anton_Markov on 8/6/2017.
 */
public class LongestSubstringWithoutRepeatingCharacters
{
	static public int lengthOfLongestSubstring(String s) {
		HashSet<Character> u = new HashSet<>();

		int i = 0; int j = 0; int max = 0;
		int L = s.length();

		while (i < L && j < L) {
			if (u.contains(s.charAt(i)))
			{
				u.remove(s.charAt(j));
				j++;
			}
			else
				u.add(s.charAt(i++));
			max = Math.max(max, i-j);
		}
		return max;
	}

	public static void main(String a[]) {
		System.out.print(lengthOfLongestSubstring("pwwwwwkew"));
	}
}
