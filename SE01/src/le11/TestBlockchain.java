package le11;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBlockchain {

    Block b1, b2;

    @Before
    public void setup() {
        b1 = new Block("sad", 2);
    }

    @Test
    public void setHash() {

    }

    @Test
    public void proofHash() {
        assertTrue(b1.proofHash("00"));
        assertTrue(b1.proofHash("001"));
        assertTrue(b1.proofHash("001das"));
        assertFalse(b1.proofHash("0201"));
        assertFalse(b1.proofHash("120001"));
        assertFalse(b1.proofHash("sadewe10201"));
        assertFalse(b1.proofHash("0dd001"));
        assertTrue(b1.proofHash("00dd001"));
        assertFalse(b1.proofHash(b1.getHash()));
    }

    @Test
    public void mine() {
        try {
            b1.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(b1.proofHash(b1.getHash()));
        System.out.print(b1.getHash());
    }

    @Test
    public void littleChain() {

        b1 = new Block("Hallo", 1);
        b2 = new Block("Luk", 1, b1);


        try {
            b2.mine();
            b1.mine();
            assertFalse(b2.proofHash(b2.getHash()));
            b2.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
