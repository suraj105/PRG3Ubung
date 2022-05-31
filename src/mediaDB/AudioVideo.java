package mediaDB;


import java.math.BigDecimal;
import java.time.Duration;

interface AudioVideoInterface extends AudioInterface,VideoInterface {}

public class AudioVideo extends Video implements AudioVideoInterface {
    Audio audio;


    public AudioVideo() {
        super(); }

    public AudioVideo(String address, long bitrate, Duration length, BigDecimal size, Uploader uploader, int samplingRate, int resolution) {
        super(address, bitrate, length, size, uploader, resolution);
        this.audio = new Audio( address, bitrate, length, size, uploader, samplingRate);
    }

    public int getSamplingRate() {
        return this.audio.getSamplingRate();
    }

}

