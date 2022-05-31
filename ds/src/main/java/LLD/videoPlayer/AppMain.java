package LLD.videoPlayer;

/*
Strategy design pattern used.
 */

public class AppMain {

    public static void main(String[] args) {

        Resolution resolution = new Resol1080P();
        Device device = new TV();

        TVVideoPlayer tvVideoPlayer = new TVVideoPlayer(resolution,device);


        Resolution resolution1 = new Resol480P();
        Device device1 = new Phone();

        PhoneVideoPlayer phoneVideoPlayer = new PhoneVideoPlayer(resolution1,device1);

        tvVideoPlayer.display();
        phoneVideoPlayer.display();

    }
}
