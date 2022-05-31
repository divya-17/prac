package LLD.videoPlayer;

public class TVVideoPlayer extends VideoPlayer{

    public TVVideoPlayer(Resolution resolution,Device device){
        this.currDevice = device;
        this.currResolution = resolution;
    }

    @Override
    void display() {
        getDevice();
        getResolution();
    }
}
