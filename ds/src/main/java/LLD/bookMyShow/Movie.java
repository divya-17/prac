package LLD.bookMyShow;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Movie {

    int movieId;
    String movieName;
    int durationInMins;
    String language;
    Genre genre;
    Date releaseDate;
    Map<String, List<Show>> cityShowMap;
}
