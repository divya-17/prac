package DesignPatterns.statePattern;

public class KidContext {

    KidState kidState;
    int age;

    public void Kid(){
        kidState = new FirstYearKid();
    }


    public void setAge(int age) {

        if(age == 1){
            kidState = new FirstYearKid();
        } else if (age == 2) {
            kidState = new SecondYearKid();
        }
        else if(age == 3){
            kidState = new ThirdYearKid();
        }
        else if(age == 4){
            kidState = new FourthYearKid();
        }
    }

    public void eat(){
        kidState.eat();
    }

    public void play(){
        kidState.play();
    }
}
