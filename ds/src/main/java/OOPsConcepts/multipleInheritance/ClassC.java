package OOPsConcepts.multipleInheritance;

public class ClassC implements C {

    @Override
    public void display() {

        System.out.println("Display C");
    }

    @Override
    public void printA() {
        System.out.println("Print A");
    }

    @Override
    public void printB() {
        System.out.println("Print B");
    }
}
