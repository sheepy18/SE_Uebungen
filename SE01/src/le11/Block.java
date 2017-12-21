package le11;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.MessageDigest;

public class Block {
    private static Integer blocknummer = 0;
    private Integer nonce;
    private String hash;
    private String data;
    private Block prev;

    public Block(String data, int nonce) {
        blocknummer++;
        this.data = data;
        this.nonce = nonce;
        prev = this;

        try {
            setHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Block(String data, int nonce, Block prevBlock) {
        blocknummer++;
        this.data = data;
        this.nonce = nonce;
        this.prev = prevBlock;

        try {
            setHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHash() throws Exception {
       String blockString = blocknummer + nonce + prev.getHash() + data;
       byte[] blockBytes = blockString.getBytes();

       MessageDigest md = MessageDigest.getInstance("SHA");
       md.update(blockBytes);

       hash = HexBin.encode(md.digest());
    }

    public void mine() throws Exception{
        while (!proofIsHashCorrect(hash)) {
            nonce++;
            setHash();
        }
    }

    public boolean proofIsHashCorrect(String hash) {
        return hash.matches("00\\w*");
    }

    public String getHash() {
        return  hash;
    }

    public void setPrev(Block b) {
        prev = b;
    }

    public void setData(String data) throws Exception{
        this.data = data;
        setHash();
    }
}
