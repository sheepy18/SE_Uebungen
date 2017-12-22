package le11;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Block implements IObservable{
    private static  MessageDigest md;
    private static Integer blocknummer = 0;

    private List<IObserver> observers;

    private Integer nonce;
    private String hash;
    private String data;
    private Block prev;

    public Block(String data, int nonce) {
        blocknummer++;
        this.data = data;
        this.nonce = nonce;
        prev = null;

        try {
            md = MessageDigest.getInstance("SHA");
            setHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        observers = new ArrayList<>();
    }
    public Block(String data, int nonce, Block prevBlock) {
        blocknummer++;
        this.data = data;
        this.nonce = nonce;
        this.prev = prevBlock;

        try {
            md = MessageDigest.getInstance("SHA");
            setHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        observers = new ArrayList<>();
    }

    public void setHash() throws Exception {
        String blockString;

        if(prev == null)
             blockString = blocknummer + nonce + data;
        else
             blockString = blocknummer + nonce + prev.getHash() + data;

       byte[] blockBytes = blockString.getBytes();


       md.update(blockBytes);

       hash = HexBin.encode(md.digest());
    }

    public void mine() throws Exception{
        while (!checkIsHashCorrect(hash)) {
            nonce++;
            updateChain();
        }
    }

    public boolean checkIsHashCorrect(String hash) {
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
        updateChain();
    }

    @Override
    public void add(IObserver obs) {
        observers.add(obs);
    }

    @Override
    public void updateChain(){
        if(observers.size() <= 0)
            return;
        observers.stream()
                .forEach(o -> {
                    try {
                        o.update();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
