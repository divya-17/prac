package LLD.videoPlayer;

/*
Strategy design pattern used.
 */
abstract public class VideoPlayer {

    Device currDevice;
    Resolution currResolution;

    abstract void display();

    void getDevice(){
         currDevice.device();
    }

    void getResolution(){
        currResolution.resolution();
    }
}
