package basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anton_Markov on 9/14/2017.
 */
public class LetterCombinationsofaPhoneNumber
{

	public List<String> letterCombinations(String digits) {
		Map<Character, Object> map = new HashMap<>();
		map.put('2', new char[]{'a','b','c'});
		map.put('3', new char[]{'d','e','f'});
		List<String> acc = new ArrayList<>();

		combine(digits, 0, acc, map);

		return acc;
	}

	private void combine(String digits, int i, List<StringBuilder> acc, Map<Character, Object> map)
	{
		if (i== digits.length())
			return;
		char[] chars = (char[]) map.get(digits.charAt(i));
		if (acc.isEmpty()) {
			for (char c: chars) {
				acc.add(new StringBuilder(Character.toString(c)));
			}
		}
		else {
			for (StringBuilder b : acc) {
				b
			}
		}
	}
}
