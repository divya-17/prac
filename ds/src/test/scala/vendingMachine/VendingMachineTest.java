package vendingMachine;

import SystemDesignQues.vendingMachine.VendingMachine;
import SystemDesignQues.vendingMachine.VendingMachineFactory;
import SystemDesignQues.vendingMachine.bo.Bucket;
import SystemDesignQues.vendingMachine.enums.Coins;
import SystemDesignQues.vendingMachine.enums.Item;
import SystemDesignQues.vendingMachine.exceptions.NotSufficientChangeException;
import SystemDesignQues.vendingMachine.exceptions.SoldOutException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class VendingMachineTest {


    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void setup(){
        vendingMachine = VendingMachineFactory.createVendingMachine();
    }

    @AfterClass
    public static void tearDown(){
        vendingMachine = null;
    }

    @Test
    public void testBuyItemWithExactPrice(){

        long price = vendingMachine.selectItemAndGetPrice(Item.COKE);
        assertEquals(Item.COKE.getPrice(), price);
        vendingMachine.insertCoin(Coins.QUARTER);
        Bucket<Item, List<Coins>> itemAndChange = vendingMachine.collectItemAndChange();
        assertEquals(itemAndChange.getFirstElem(),Item.COKE);
        //assertTrue(itemAndChange.getSecondElem().isEmpty());
    }


    @Test
    public void testBuyItemWithMorePrice(){

        long price = vendingMachine.selectItemAndGetPrice(Item.SODA);
        assertEquals(Item.SODA.getPrice(), price);
        vendingMachine.insertCoin(Coins.QUARTER);
        vendingMachine.insertCoin(Coins.QUARTER);
        Bucket<Item, List<Coins>> bucket = vendingMachine.collectItemAndChange();
        Item item = bucket.getFirstElem();
        List<Coins> change = bucket.getSecondElem();
        assertEquals(Item.SODA,item);
        assertTrue(!change.isEmpty());
        assertEquals(50-Item.SODA.getPrice(),getTotal(change));

    }

    @Test(expected = SoldOutException.class)
    public void testSoldOut(){

        vendingMachine.reset();

        for(int i=0;i<10;i++){
            vendingMachine.selectItemAndGetPrice(Item.COKE);
            vendingMachine.insertCoin(Coins.QUARTER);
            vendingMachine.collectItemAndChange();
        }
    }


    @Test(expected= NotSufficientChangeException.class)
    public void testNotSufficientChange(){

        for(int i = 0; i < 5; i++){

            vendingMachine.selectItemAndGetPrice(Item.SODA);
            vendingMachine.insertCoin(Coins.QUARTER);
            vendingMachine.insertCoin(Coins.QUARTER);
            vendingMachine.collectItemAndChange();

            vendingMachine.selectItemAndGetPrice(Item.PEPSI);
            vendingMachine.insertCoin(Coins.QUARTER);
            vendingMachine.insertCoin(Coins.QUARTER);
            vendingMachine.collectItemAndChange();
        }


    }

    public long getTotal(List<Coins> change){
        long total=0;
        for(Coins coins: change){
            total=total+coins.getDenomination();
        }
        return total;
    }

}
