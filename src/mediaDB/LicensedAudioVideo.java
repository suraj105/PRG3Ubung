package mediaDB;

import java.math.BigDecimal;
import java.time.Duration;

interface LicensedAudioVideoInterface extends LicensedInterface,AudioVideoInterface{}

public class LicensedAudioVideo extends AudioVideo implements LicensedAudioVideoInterface {
    Licensed licensed;

    public LicensedAudioVideo() {}
    public LicensedAudioVideo(String address, long bitrate, Duration length, BigDecimal size, Uploader uploader, int samplingRate, int resolution, String holderName ) {
        super(address, bitrate, length, size, uploader, samplingRate, resolution);
        this.licensed = new Licensed( address, uploader, holderName );
    }

    public String getHolder() {
        return this.licensed.getHolder();
    }
}

