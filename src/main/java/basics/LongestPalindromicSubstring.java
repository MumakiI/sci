package basics;

/**
 * Created by Anton_Markov on 8/7/2017.
 */
public class LongestPalindromicSubstring
{
	public static void main(String a[])
	{
		//System.out.print(longestPalindrome("babad"));
		System.out.print(maxArea(new int[]{1,1}));
	}

	public static String longestPalindrome(String s) {
		int L = s.length();

		boolean[][] a = new boolean[L][L];

		for(int i = 0; i<a.length; i++)
			a[i][i] = true;

		for(int i = 0; i<a.length-1; i++)
			a[i][i+1] = s.charAt(i)==s.charAt(i+1);

		int l = 2;

		while(l < L) {
			for (int i = 0; i < l - 1; i++)
				a[l][i] = a[l-1][i+1] && s.charAt(i) == s.charAt(l-i);
			l++;
		}

		//int i = L-1, j = L-1;

		l = 0;

		while (l++<L)
			for (int i = L-1, j = l-1; j>=0; i--, j--)
				if (a[i][j])
					return s.substring(j, i);

		return "";//s.substring(0, 1);
	}

	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int s = 0;

		int a = 0, b = height.length - 1;

		while (a>b) {
			s = Math.max(s, (b-a) * Math.min(height[a], height[b]));

			if (height[a] > height[b])
				b--;
			else a ++;
		}

		return s;
	}


	/*static public String longestPalindrome(String s)
	{
		int L = s.length();
		if (L == 1)
			return s;

		boolean[][] m = new boolean[L][L];

		for (int i = 0; i < L; i++)
			m[i][i] = true;

		for (int i = 1; i < L; i++)
			if (s.charAt(i - 1) == s.charAt(i))
				m[i - 1][i] = true;

		for (int l = 2; l < L; l++)
		{
			int j;
			for (int i = 0; i < l - 1; i++)
			{
				j = l;
				m[i][j] = m[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));

			}
		}

		int l = 0;

		while (l < L - 1)
		{
			for (int i = l, j = L - 1; i >= 0; i--, j--)
				if (m[i][j])
					return s.substring(i, j + 1);
			l++;
		}
		return s.substring(0, 1);
	}*/
}
