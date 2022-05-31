package LLD.bookMyShow;

import java.util.List;

public class User {

    int userId;
    Search searchObj;
}

class SystemMember extends User{

    Account account;
    String name;
    String email;
    Address address;
}

class Member extends SystemMember{

    public Booking makeBooking(Booking booking){return null;}
    public List<Booking> getBooking(){return null;}

}
class Admin extends SystemMember{

    public boolean addMovie(Movie movie){return false;}
    public boolean addShow(Show show){return false;}
}
