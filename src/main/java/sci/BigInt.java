package sci;

/**
 * Created by Anton on 4/4/2017.
 */
public class BigInt
{

	public static final int BASE = 127;
	public static final int SIGNIFICANT_BITS_COUNT = 7;
	public static final byte[] ONE = { 1 };
	private byte[] bits;

	public BigInt(byte[] bits)
	{
		this.bits = bits;
	}

	public BigInt add(BigInt a)
	{
		return new BigInt(add(this.bits, a.bits, 0, 0, 0));
	}

	private byte[] add(byte[] a, byte[] b, int i, int j, int overflow)
	{
		if (i > a.length - 1 && j > b.length - 1)
			if (overflow == 1)
				return ONE;
			else
				return null;

		byte ai = 0;
		if (i < a.length)
			ai = a[i];

		byte bj = 0;
		if (j < b.length)
			bj = b[j];

		short currentWithOverflow = (short) (ai + bj + overflow);
		byte[] higherBits = add(a, b, i + 1, j + 1, (currentWithOverflow <= BASE) ? 0 : 1);

		byte currentNoOverflow = (byte) (currentWithOverflow & BASE);
		if (higherBits != null)
		{
			byte[] res = new byte[higherBits.length + 1];
			res[0] = currentNoOverflow;
			System.arraycopy(higherBits, 0, res, 1, higherBits.length);
			return res;
		}
		else
			return new byte[] { currentNoOverflow };
	}

	public String toString()
	{
		long acc = 0;
		for (int i = 0; i < bits.length; i++)
		{
			acc = acc + (bits[i] << (i * SIGNIFICANT_BITS_COUNT));
		}
		return String.valueOf(acc);
	}
}
