package SystemDesignQues.vendingMachine;

import SystemDesignQues.vendingMachine.bo.Bucket;
import SystemDesignQues.vendingMachine.bo.Inventory;
import SystemDesignQues.vendingMachine.enums.Coins;
import SystemDesignQues.vendingMachine.enums.Item;

import java.util.List;

public interface VendingMachine {

    public long selectItemAndGetPrice(Item item);
    public void insertCoin(Coins coin);
    public List<Coins> refund();
    public Bucket<Item,List<Coins>> collectItemAndChange();
    public void reset();
    public Inventory<Coins> getCashInventory();
    public Inventory<Item> getItemInventory();

}
