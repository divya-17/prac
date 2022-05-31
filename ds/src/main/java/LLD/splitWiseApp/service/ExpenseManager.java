package LLD.splitWiseApp.service;

import LLD.splitWiseApp.exception.InvalidExpenseDetailException;
import LLD.splitWiseApp.model.ExpenseDetail;
import LLD.splitWiseApp.model.ExpenseProfile;
import LLD.splitWiseApp.model.User;

import java.util.*;

public class ExpenseManager {

    List<ExpenseProfile> allExpenseProfileList;
    Map<User,List<ExpenseProfile>> payerToExpenseProfilesMap;


    public void ExpenseManager(){
        allExpenseProfileList = new ArrayList<>();
        payerToExpenseProfilesMap = new HashMap<>();
    }


    public void registerUser(User user){
        payerToExpenseProfilesMap.put(user,new ArrayList<>());
    }

    public void registerUsers(List<User> userList){

        for(User user: userList){
            registerUser(user);
        }
    }

    public void addExpense(ExpenseDetail expenseDetail){

        if(expenseDetail.getDistributionAmounts() != null && !expenseDetail.getDistributionAmounts().isEmpty()){

            if(expenseDetail.getDistributionAmounts().size() != expenseDetail.getPayer().size()){
                throw new InvalidExpenseDetailException("Payer count doesn't match distribution amounts. Please check!")
            }
        }

        switch (expenseDetail.getDistributionType()){

            /*
                List<User> payer = [u1, u2, u3, u4]
                User recepient = u1
                Long amount = 1000
                DistributionType distributionType = 'EQUAL'
                List<Long> distributionAmounts=[];

             */
            case EQUAL:{

                Long amount = expenseDetail.getAmount()/expenseDetail.getPayer().size();


                for(User payer: expenseDetail.getPayer()){

                    List<ExpenseProfile> payerProfile = payerToExpenseProfilesMap.get(payer);
                    if(payerProfile == null || payerProfile.isEmpty()){
                        payerProfile = new ArrayList<>(Arrays.asList(new ExpenseProfile(payer,expenseDetail.getRecepient(),amount)));
                        payerToExpenseProfilesMap.put(payer,payerProfile);
                    }
                    else{
                        for(ExpenseProfile profile: payerProfile){
                            if(profile.getRecepient().equals(expenseDetail.getRecepient())){
                                profile.setAmount(profile.getAmount()+amount);
                            }
                        }
                    }
                }

            }

            case EXACT:

            case PERCENTAGE:
        }

    }

    public void showExpense(){

        for(Map.Entry<User,ExpenseProfile> entry: userToExpenseMap.entrySet()){
            System.out.println(entry.getValue().getPayer() +" owes "+entry.getValue().getAmount()+" to "+entry.getValue().getRecepient());
        }
    }

    public void showExpenseForUser(User user){

        ExpenseProfile userExpenseProfile = userToExpenseMap.get(user);
        System.out.println(userExpenseProfile.getPayer()+" owes "+userExpenseProfile.getAmount()+" to "+userExpenseProfile.getRecepient());
    }

}
