package DesignPatterns.statePattern;

public class Exec {


    public static void main(String[] args) {

        KidContext kid = new KidContext();

        kid.setAge(1);
        kid.eat();
        kid.play();

        kid.setAge(2);
        kid.eat();
        kid.play();

        kid.setAge(3);
        kid.eat();
        kid.play();


    }
}
