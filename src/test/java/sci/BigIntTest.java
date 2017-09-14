package sci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Created by on 4/8/2017.
 */
public class BigIntTest
{

    @Test
    public void test() {
        BigInt a = new BigInt(new byte[]{127, 127});
        BigInt b = new BigInt(new byte[]{127, 127});
        BigInt c = a.add(b);

        assertEquals("32766", c.toString());
        System.out.print("!!!!!!!!!!!!!!!!C:" + c.toString());
        String x = new BigInt(new byte[] { 127, 1 }).toString();
        System.out.print("!!!!!!!!!!!!!!!!X:" + x);
        assertEquals("255", x);

        String y = new BigInt(new byte[] { 127, 127 }).toString();
        System.out.print("!!!!!!!!!!!!!!!!Y:" + y);
        assertEquals("16383", y);
    }
}
