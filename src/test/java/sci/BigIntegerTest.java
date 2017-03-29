package sci;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigIntegerTest {

    @Test
    void testAdd_small_numbers() {
        assertEquals("7", new BigInteger("7").add(new BigInteger("8")).toString());
    }

    @Test
    void testAdd_random_ints() {
        for (int i = 0; i < 100; i++) {
            int j = Math.abs(new Random().nextInt(10));
            int k = Math.abs(new Random().nextInt(10));
            if (i == 0 || k == 0) continue;
            assertEquals(j + k + "", new BigInteger(j + "").add(new BigInteger(k + "")).toString(), j + " " + k);
        }
    }
}