package sci;

/**
 * Created by Anton on 4/2/2017.
 */
public class HexConverter {

    public String toHex(int num) {
         final int BASE = 16;

        long n = num;
        if (n < 0) {
            n = Math.abs(n);
            n = (((1l << 32)) - 1) - n + 1;
        }

        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder buf = new StringBuilder();

        if (n != 0) {
            while (n > 0) {
                if (n < BASE) {
                    buf.append(map[(int)n]);
                    break;
                }
                buf.append(map[(int)(n % BASE)]);
                n = n / BASE;
            }
        }
        else {
            buf.append(0);
        }
        return buf.reverse().toString();
    }
}
