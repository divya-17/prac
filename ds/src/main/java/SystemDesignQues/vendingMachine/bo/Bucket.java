package SystemDesignQues.vendingMachine.bo;

public class Bucket<E1,E2> {

    private E1 firstElem;
    private E2 secondElem;

    public E1 getFirstElem() {
        return firstElem;
    }

    public void setFirstElem(E1 firstElem) {
        this.firstElem = firstElem;
    }

    public E2 getSecondElem() {
        return secondElem;
    }

    public void setSecondElem(E2 secondElem) {
        this.secondElem = secondElem;
    }

    public Bucket(E1 firstElem, E2 secondElem) {
        this.firstElem = firstElem;
        this.secondElem = secondElem;
    }
}
