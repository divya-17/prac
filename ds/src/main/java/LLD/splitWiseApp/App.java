package LLD.splitWiseApp;
/*
Problem Statement:

You live with 3 other frnds.
You: User1 (id: u1)
Flatmates: User2(u2), User3(u3), User4(u4).

This month's electricity bill is Rs 1000.
Now you can just go to the app and add that you paid 1000,
select all the 4 people and then select split equally

Input: u1 1000 4 u1 u2 u3 u4 EQUAL

For this transaction, everyone owes Rs 250 to User1

The app should update the balance in each of the profiles accordingly

User2 owes User1: 250
User3 owes User1: 250
User4 owes User1: 250

Input: u1 1250 2 u2 u3 EXACT 370 880

Now app profiles for each user will be:

User2 owes User1: 620 (250+370)
User3 owes User1: 1130 (250+880)
User4 owes User1: 250

Input: u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20

Now app profiles for each user will be:

User1 owes User4: 230 (480-250)
User2 owes User1: 620
User2 owes User4: 240
User3 owes User1: 1130
User3 owes User4: 240
 */

import LLD.splitWiseApp.model.User;
import LLD.splitWiseApp.service.ExpenseManager;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        ExpenseManager expenseManager = new ExpenseManager();

        User u1 = new User(1,"u1");
        User u2 = new User(2,"u2");
        User u3 = new User(3,"u3");
        User u4 = new User(4,"u4");

        expenseManager.registerUsers(new ArrayList<>(Arrays.asList(u1,u2,u3,u4)));


    }
}
