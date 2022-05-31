package LLD.splitWiseApp.model;

public class User {

    int userId;
    String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
