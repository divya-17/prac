package SystemDesignQues.vendingMachine.bo;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {


    private Map<T,Integer> inventory = new HashMap<T,Integer>();


    public void add(T item){
        Integer c = inventory.get(item);
        inventory.put(item,c+1);
    }

    public int getQuantity(T item){
        Integer value = inventory.get(item);
        return value==null? 0 : value;
    }

    public void deduct(T item){
        Integer newValue = inventory.get(item)-1;
        inventory.put(item,newValue);
    }

    public Boolean hasItem(T item){
        return getQuantity(item) > 0;
    }

    public void clear(){
        inventory.clear();
    }

    public void put(T item, Integer quantity){

        inventory.put(item,quantity);
    }
}
