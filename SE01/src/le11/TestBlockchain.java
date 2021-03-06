package le11;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBlockchain {

    Block b1, b2, b3;

    @Before
    public void setup() {
        b1 = new Block("sad", 2);
    }

    @Test
    public void setHash() {

    }

    @Test
    public void proofHash() {
        assertTrue(b1.checkIsHashCorrect("00"));
        assertTrue(b1.checkIsHashCorrect("001"));
        assertTrue(b1.checkIsHashCorrect("001das"));
        assertFalse(b1.checkIsHashCorrect("0201"));
        assertFalse(b1.checkIsHashCorrect("120001"));
        assertFalse(b1.checkIsHashCorrect("sadewe10201"));
        assertFalse(b1.checkIsHashCorrect("0dd001"));
        assertTrue(b1.checkIsHashCorrect("00dd001"));
        assertFalse(b1.checkIsHashCorrect(b1.getHash()));
    }

    @Test
    public void mine() {
        try {
            b1.mine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(b1.checkIsHashCorrect(b1.getHash()));
        System.out.print(b1.getHash());
    }

    @Test
    public void littleChain() {
        BlockChain chain1 = new BlockChain("LittleChain");

        chain1.createBlock("Hallo");
        chain1.createBlock("Luk");

        b1 = chain1.getBlock(0);
        b2 = chain1.getBlock(1);
        b3 = new Block("Marie", 2);

        chain1.mine();
        assertTrue(chain1.chainIsCorrect());
        assertTrue(b1.checkIsHashCorrect(b1.getHash()));
        assertTrue(b2.checkIsHashCorrect(b2.getHash()));

        chain1.addblock(b3);
        assertFalse(b3.checkIsHashCorrect(b3.getHash()));
        assertFalse(chain1.chainIsCorrect());
        chain1.mine();
        assertTrue(chain1.chainIsCorrect());

        try {
            b2.setData("Luke");
            assertFalse(chain1.chainIsCorrect());
            assertFalse(b3.checkIsHashCorrect(b3.getHash()));
            chain1.mine();
            assertTrue(chain1.chainIsCorrect());
            b1.setData("Look");
            assertFalse(b1.checkIsHashCorrect(b1.getHash()));
            assertFalse(b2.checkIsHashCorrect(b2.getHash()));
            assertFalse(b3.checkIsHashCorrect(b3.getHash()));
            b2.mine();
            assertTrue(b2.checkIsHashCorrect(b2.getHash()));
            b1.mine();
            assertFalse(b2.checkIsHashCorrect(b2.getHash()));
            assertFalse(b3.checkIsHashCorrect(b3.getHash()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
