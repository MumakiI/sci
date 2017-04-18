package sci;

/**
 * Created by Anton on 4/4/2017.
 */
public class BigInt {

    private byte[] bits;

    public BigInt(byte[] bits)
    {
        this.bits = bits;
    }

    BigInt add(BigInt a)
    {
        return new BigInt(add(this.bits, a.bits, 0, 0, 0));
    }

    byte[] add(byte[] a, byte[] b, int i, int j, int overflow)
    {
        if (i > a.length -1 && j>b.length-1)
            if (overflow == 1)
                return new byte[]{1};
            else
                return null;
        short c = (short) (a[i] + b[j] + overflow);

        byte[] higher = add(a, b, i + 1, j + 1, (c <=127) ? 0 : 1);

        if (higher != null)
        {
            int length = higher.length + 1;
            byte[] res = new byte[length];

            res[0] = (byte) (c & 127);
            System.arraycopy(higher, 0, res, 1, higher.length);
            return  res;
        }
        else
            return new byte[]{(byte)(c & 127)};

    }

    public String toString() {
        long l = 0;
        int i = 0;
        for (byte b : bits)
        {
            l = l + (b << (i++ * 7));
        }
        return l + "";
    }

//	public String toString() {
//		long l = 0;
//		int i = 0;
//
//		StringBuilder buf = new StringBuilder();
//		for (byte b : bits)
//		{
//			while (b > 10)
//			{
//				buf.append(b / 10);
//				b = (byte) (b % 10);
//			}
//			buf.append(b);
//		}
//		return buf.toString();
//		//return "";
//	}
}
