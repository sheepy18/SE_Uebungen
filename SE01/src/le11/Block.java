package le11;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.MessageDigest;

public class Block {
    private static Integer blocknummer = 0;
    private Integer nonce;
    private String hash;
    private String data;
    private String prevHash;

    public Block() {
        blocknummer++;
        prevHash = "";
    }
    public Block(String data, int nonce) {
        blocknummer++;
        this.data = data;
        this.nonce = nonce;
        prevHash = "";
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
        this.prevHash = prevBlock.getHash();
        try {
            setHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHash() throws Exception {
       String blockString = blocknummer + nonce + prevHash + data;
       byte[] blockBytes = blockString.getBytes();

       MessageDigest md = MessageDigest.getInstance("SHA");
       md.update(blockBytes);

       hash = HexBin.encode(md.digest());
    }

    public void mine() throws Exception{
        while (!proofHash(hash)) {
            nonce++;
            setHash();
        }
    }

    public boolean proofHash(String hash) {
        return hash.matches("00\\w*");
    }

    public String getHash() {
        return  hash;
    }
}
