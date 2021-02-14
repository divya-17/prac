package SystemDesignQues.vendingMachine;

import SystemDesignQues.vendingMachine.enums.Item;

public class Main {

    public static void main(String[] args) {

        VendingMachineFactory factory = new VendingMachineFactory();

        VendingMachine vendingMachine = factory.createVendingMachine();

        Item item = Item.COKE;

        long itemPrice = vendingMachine.selectItemAndGetPrice(item);




    }

}
