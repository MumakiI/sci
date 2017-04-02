package sci;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Anton on 4/2/2017.
 */
public class HexConverterTest {

    @Test
    public void test() {
        HexConverter c = new HexConverter();

        assertEquals("1a",  c.toHex(26));
        assertEquals("1e",  c.toHex(30));
        assertEquals("493e0",  c.toHex(300000));
    }

}
