package basics;

/**
 * Created by Anton_Markov on 8/31/2017.
 */
public class GoogleDecompressSrting
{
	public static void main(String[] a) {
		System.out.print(dec("a3[b2[c1[d]]]e", 0));
	}

	private static String dec(String s, int i)
	{
		StringBuffer buf = new StringBuffer();

		while (i < s.length()) {
			String c = s.substring(i, i + 1);

			try
			{
				int n = Integer.valueOf(c);
				String inner = s.substring(s.indexOf("[")+1, s.lastIndexOf("]"));
				inner = dec(inner, 0);
				while (n-- > 0) {
					buf.append(inner);
				}
				i = s.lastIndexOf("]");
			} catch (NumberFormatException e){
				if (!c.equals("]"))
					buf.append(c);
				i++;
			}
		}

		return buf.toString();
	}
}
