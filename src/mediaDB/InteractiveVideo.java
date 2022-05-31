package mediaDB;

import java.math.BigDecimal;
import java.time.Duration;

interface InteractiveVideoInterface extends VideoInterface,InteractiveInterface{}

public class InteractiveVideo extends Video implements InteractiveVideoInterface {
    Interactive interactive;

    public InteractiveVideo() {}
    public InteractiveVideo( String address, long bitrate, Duration length, BigDecimal size, Uploader uploader, int resolution, String type) {
        super(address, bitrate, length, size, uploader, resolution);
        this.interactive = new Interactive( address, uploader, type );
    }

    public String getType() {
        return this.interactive.getType();
    }
}

