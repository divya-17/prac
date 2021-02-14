package SystemDesignQues.vendingMachine;

public class VendingMachineFactory {

    public static VendingMachine createVendingMachine(){
        return new VendingMachineImpl();
    }
}
