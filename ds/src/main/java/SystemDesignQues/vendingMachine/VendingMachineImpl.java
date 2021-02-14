package SystemDesignQues.vendingMachine;

import SystemDesignQues.vendingMachine.bo.Bucket;
import SystemDesignQues.vendingMachine.bo.Inventory;
import SystemDesignQues.vendingMachine.enums.Coins;
import SystemDesignQues.vendingMachine.enums.Item;
import SystemDesignQues.vendingMachine.exceptions.NotFullPaidException;
import SystemDesignQues.vendingMachine.exceptions.NotSufficientChangeException;
import SystemDesignQues.vendingMachine.exceptions.SoldOutException;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {


    private Inventory<Coins> cashInventory = new Inventory<Coins>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl(){
        init();

    }

    public void init(){

        // Add 5 coins of each type
        for(Coins coin: Coins.values()){
            cashInventory.put(coin,5);
        }

        //Add 5 items of each type
        for(Item item : Item.values()){
            itemInventory.put(item,5);
        }
    }
    @Override
    public long selectItemAndGetPrice(Item item) {

        if(itemInventory.hasItem(item)){
            currentItem=item;
            return currentItem.getPrice();
        }

        throw new SoldOutException("Sold out. Please buy another item");
    }


    @Override
    public void insertCoin(Coins coin) {

        currentBalance = currentBalance+coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coins> refund() {

        List<Coins> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;

    }

    public void updateCashInventory(List<Coins> refund){

        for(Coins coins: refund){
            cashInventory.deduct(coins);
        }

    }

    public List<Coins> getChange(long balance){

        List<Coins> change = new ArrayList<>();

        if(balance > 0) {
            long amt = balance;

            while (amt > 0) {

                if(amt >= Coins.QUARTER.getDenomination() && cashInventory.hasItem(Coins.QUARTER)){

                    change.add(Coins.QUARTER);
                    amt = amt - Coins.QUARTER.getDenomination();
                    cashInventory.deduct(Coins.QUARTER);
                    continue;
                }

                else if(amt >= Coins.DIME.getDenomination() && cashInventory.hasItem(Coins.DIME)){

                    change.add(Coins.DIME);
                    amt = amt - Coins.DIME.getDenomination();
                    cashInventory.deduct(Coins.DIME);
                    continue;
                }

                else if (amt >= Coins.NICKEL.getDenomination() && cashInventory.hasItem(Coins.NICKEL)) {

                    change.add(Coins.NICKEL);
                    amt = amt - Coins.NICKEL.getDenomination();
                    cashInventory.deduct(Coins.NICKEL);
                    continue;
                }
                else  if( amt >= Coins.PENNY.getDenomination() && cashInventory.hasItem(Coins.PENNY)){

                    change.add(Coins.PENNY);
                    amt = amt - Coins.PENNY.getDenomination();
                    cashInventory.deduct(Coins.PENNY);
                    continue;
                }
                else {
                    throw new NotSufficientChangeException("Don't have sufficient change. Please try some other item !!");
                }
            }
        }
      return change;

    }


    private Boolean isFullPaid(){

        if(currentBalance >= currentItem.getPrice()){
            return true;
        }
        else {
            return false;
        }

    }
    @Override
    public Bucket<Item, List<Coins>> collectItemAndChange() {

        List<Coins> change = new ArrayList<>();

        if(currentItem == null){
            System.out.println("No item selected! ");
        }
        else {

            if(currentBalance == currentItem.getPrice()){
                itemInventory.deduct(currentItem);
                Item item = currentItem;
                currentItem = null;
                currentBalance =0;
                return new Bucket<>(item,change);
            }

            else if(currentBalance > currentItem.getPrice()){

                if(hasSufficientChange()){
                    change = getChange(currentBalance-currentItem.getPrice());
                    itemInventory.deduct(currentItem);
                    Item item = currentItem;
                    currentItem = null;
                    currentBalance = 0;
                    return new Bucket<>(item,change);
                }
                else {
                    refund();
                    throw new NotSufficientChangeException("Don't have the sufficient change");
                    //System.out.println("Don't have sufficient change for this amount. Refunding back the paid amount. Please select some other item !");

                }
            }
            else if(currentBalance < currentItem.getPrice()){
                throw new NotFullPaidException("Paid amount is less than the actual price",(currentItem.getPrice()-currentBalance));
            }
        }
        return null;
    }


    @Override
    public void reset() {

        init();
        currentItem = null;
        currentBalance = 0;
    }


    private Boolean hasSufficientChange(){
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private Boolean hasSufficientChangeForAmount(long amt){

        boolean hasChange = true;
        try {

            getChange(amt);
        }
        catch (NotSufficientChangeException nsce){
            hasChange = false;
        }

        return hasChange;
    }

    public Inventory<Coins> getCashInventory(){
        return cashInventory;
    }

    public Inventory<Item> getItemInventory(){
        return itemInventory;
    }
}



