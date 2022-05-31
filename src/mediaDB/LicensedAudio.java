package mediaDB;


import java.math.BigDecimal;
import java.time.Duration;

interface LicensedAudioInterface extends LicensedInterface,AudioInterface {}

public class LicensedAudio extends Audio implements LicensedAudioInterface {
    Licensed licensed;

    public LicensedAudio() {}
    public LicensedAudio( String address, long bitrate, Duration length, BigDecimal size, Uploader uploader, int samplingRate, String holderName ) {
        super( address, bitrate, length, size, uploader, samplingRate);
        this.licensed = new Licensed( address, uploader, holderName );
    }

    public String getHolder() {
        return this.licensed.getHolder();
    }
}