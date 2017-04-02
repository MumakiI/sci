package sci;

/**
 * Created by Anton on 4/2/2017.
 */
public class Complement {

    public int findComplement(int num) {

        if (num == 0)
            return 1;

        int m = 0;

        while ((m | num) > m) {
            m = (m << 1) + 1;
        }

        return m - num;
    }
}
