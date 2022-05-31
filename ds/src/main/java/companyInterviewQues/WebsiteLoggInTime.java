package companyInterviewQues;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/*
Spinny Interview Ques:

Given the details of user login and logout activity, find the duration in which all the users were logged in at
the same time
 */
public class WebsiteLoggInTime {

    public static void main(String[] args) {

        List<LoginDetail> loginDetailList = new ArrayList<>();

        loginDetailList.add(new LoginDetail("U1","12:20am","logged_in"));
        loginDetailList.add(new LoginDetail("U2","12:40am","logged_in"));
        loginDetailList.add(new LoginDetail("U1","01:40am","logged_out"));
        loginDetailList.add(new LoginDetail("U1","04:00am","logged_in"));
        loginDetailList.add(new LoginDetail("U2","05:00am","logged_out"));


        List<String> users = new ArrayList<>();
        users.add("U1");
        users.add("U2");

        List<Pair<String,String>> durations = getLoggedInDuration(loginDetailList,users);

        System.out.println(durations);
    }

    private static List<Pair<String, String>> getLoggedInDuration(List<LoginDetail> loginDetailList, List<String> users) {

        List<Pair<String,String>> durations = new ArrayList<>();
        int currentNumOfLoggedInUser = 0;

        for(int i =0; i < loginDetailList.size(); i++){

            if (loginDetailList.get(i).getState() == "logged_in"){
                currentNumOfLoggedInUser = currentNumOfLoggedInUser+1;
            }
            else if(loginDetailList.get(i).getState() == "logged_out"){
                currentNumOfLoggedInUser = currentNumOfLoggedInUser-1;
            }

            if(currentNumOfLoggedInUser == users.size()){
                if(i+1 < loginDetailList.size()) {
                    durations.add(new Pair(loginDetailList.get(i).getTimeStamp(), loginDetailList.get(i + 1).getTimeStamp()));
                }
            }
        }
        return durations;
    }


}

class LoginDetail{

    String user;
    String timeStamp;
    String state;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LoginDetail(String user, String timeStamp, String state){

        this.user = user;
        this.timeStamp = timeStamp;
        this.state=state;
    }

}

