package mediaDB;

import java.math.BigDecimal;
import java.time.Duration;

interface LicensedVideoInterface extends LicensedInterface,VideoInterface {}

public class LicensedVideo extends Video implements LicensedVideoInterface {
    Licensed licensed;

    public LicensedVideo() {
        super();
    }
    public LicensedVideo(String address, long bitrate, Duration length, BigDecimal size, Uploader uploader, int resolution,String holder) {
        super( address, bitrate, length, size, uploader, resolution);
        this.licensed = new Licensed( address, uploader, holder);
    }

    public String getHolder() {
        return this.licensed.getHolder();
    }
}