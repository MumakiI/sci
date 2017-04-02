package sci;

/**
 * Created by Anton on 4/2/2017.
 */
public class HexConverter {

    public String toHex(int num) {
        final int BASE = 16;

        if (num < 0) {
            num = Math.abs(num);
            
        }

        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder buf = new StringBuilder();

        if (num >= 0) {
            while (num > 0) {
                if (num < BASE) {
                    buf.append(map[num]);
                    break;
                }
                buf.append(map[num % BASE]);
                num = num / BASE;
            }
        }
        return buf.reverse().toString();
    }
}
