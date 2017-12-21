package le11;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Block> chain;
    private String name;

    public BlockChain(String name) {
        this.name = name;
        chain = new ArrayList<>();
    }

    public void addblock(Block block) {
        if(chain.size()>0)
            block.setPrev(chain.get(chain.size()-1));
        chain.add(block);
    }

    public void createBlock(String data) {
        int nonce = 1;
        int length = chain.size();
        if(chain.size() == 0) {
            chain.add(new Block(data, nonce));
        } else {
            chain.add(new Block(data, nonce, chain.get(length-1)));
        }
    }

    public void mine() {
        chain.parallelStream()
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
                .map(b -> b.proofIsHashCorrect(b.getHash()))
                .reduce(true, (a,b) -> a && b);
    }
}
