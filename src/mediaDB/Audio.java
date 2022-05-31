package mediaDB;


import java.math.BigDecimal;
import java.time.Duration;

interface AudioInterface extends MediaContentInterface,UploadableInterface {
    int getSamplingRate();
}

public class Audio extends MediaContent implements AudioInterface{

    int samplingRate;

    public Audio() { super();
    }



    public Audio(String address, long bitrate, Duration length, BigDecimal size, Uploader uploader, int samplingRate) {
        super( address, uploader, bitrate, length, size );
        this.samplingRate = samplingRate;
    }

    public int getSamplingRate() {
        return this.samplingRate;
    }

}