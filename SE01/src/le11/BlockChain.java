package le11;

import java.util.ArrayList;
import java.util.List;

public class BlockChain implements IObserver {
    private List<Block> chain;
    private String name;

    public BlockChain(String name) {
        this.name = name;
        chain = new ArrayList<>();
    }

    public void addblock(Block block) {
        block.add(this);
        if(chain.size()>0)
            block.setPrev(chain.get(chain.size()-1));
        chain.add(block);
    }

    public void createBlock(String data) {
        int nonce = 1;
        int length = chain.size();
        Block b;
        if(chain.size() == 0) {
            b = new Block(data, nonce);
            chain.add(b);
        } else {
            b = new Block(data, nonce, chain.get(length-1));
            chain.add(b);
        }
        b.add(this);
    }

    public void mine() {
        chain.stream()
                .forEach(b -> {
                    try {
                        b.mine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public Block getBlock(int index) {
        return chain.get(index);
    }

    public boolean chainIsCorrect() {
        return chain.parallelStream()
                .map(b -> b.checkIsHashCorrect(b.getHash()))
                .reduce(true, (a,b) -> a && b);
    }

    @Override
    public void update() throws Exception {
       chain.stream()
               .forEach(b -> {
            try {
               b.setHash();
           } catch (Exception e) {
               e.printStackTrace();
           }
       });
    }
}
