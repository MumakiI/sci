package sci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

class BigIntegerTest {

    @Test
    void testAdd_small_numbers() {
        assertEquals("15", new BigInteger("7").add(new BigInteger("8")).toString());
    }

    @Test
    void testAdd_random_ints() {
        for (int i = 0; i < 1000; i++) {
            int j = Math.abs(new Random().nextInt(100));
            int k = Math.abs(new Random().nextInt(10000));
            if (i == 0 || k == 0) continue;
            assertEquals(j + k + "", new BigInteger(j + "").add(new BigInteger(k + "")).toString(), j + " " + k);
        }
    }
}