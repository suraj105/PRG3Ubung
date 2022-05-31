package mediaDB;

import java.math.BigDecimal;
import java.time.Duration;

interface VideoInterface extends MediaContentInterface,UploadableInterface{
    int getResolution();
}

public class Video extends MediaContent implements VideoInterface {

    int resolution;

    public Video() {}
    public Video(String address, long bitrate, Duration length, BigDecimal size, Uploader uploader, int resolution) {
        super(address, uploader, bitrate, length, size);
        this.resolution = resolution;
    }

    public int getResolution() {
        return this.resolution;
    }



}

