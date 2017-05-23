package sci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Created by Anton on 4/2/2017.
 */
public class ComplementTest {

    @Test
    public void test() {
        Complement c = new Complement();

        assertEquals(2, c.findComplement(5));
        assertEquals(0, c.findComplement(3));
        assertEquals(7, c.findComplement(8));
        assertEquals(1, c.findComplement(0));
    }
}
