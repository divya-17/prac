package DesignPatterns.builderPattern;

public class Main {


    public static void main(String[] args) {

        User user1 = new User.UserBuilder("harry","potter")
                .age(20)
                .phone("3442133")
                .address("Street 719 Bali").build();


        System.out.println(user1);

        User user2 = new User.UserBuilder("Jack","Reacher")
                .age(50)
                .phone("332237")
                .build(); // no address


        System.out.println(user2);
    }
}
