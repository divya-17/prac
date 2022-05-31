package LLD.videoPlayer;

public class PhoneVideoPlayer extends VideoPlayer {

    public PhoneVideoPlayer (Resolution resolution, Device device){
        this.currDevice = device;
        this.currResolution = resolution;
    }
    @Override
    void display() {
        getDevice();
        getResolution();
    }
}
