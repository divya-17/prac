package LLD.bookMyShow;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Theatre {

    int theatreId;
    String theatreName;
    Address theatreAddress;
    List<Audi> audiList;

    public Map<Date,Movie> getMovies(List<Date> dateList){ return null; }
    public Map<Date,Show> getShows(List<Date> dateList){return null; }
}
