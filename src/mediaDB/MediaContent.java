package mediaDB;


import java.math.BigDecimal;
import java.time.Duration;
import java.io.Serializable;

interface MediaContentInterface extends ContentInterface,Serializable{
    long getBitrate();
    Duration getLength();
    BigDecimal getSize();
}

public class MediaContent extends Content implements MediaContentInterface,AccessCounterI {
    private long bitrate;
    private Duration length;
    private BigDecimal size;

    public MediaContent() { super(); }
    public MediaContent( String address, Uploader uploader, long bitrate, Duration length, BigDecimal size ) {
        super( address, uploader );
        this.bitrate = bitrate;
        this.length = length;
        this.size = size;
    }

    public long getBitrate() {
        return this.bitrate;
    }

    public Duration getLength() { return this.length; }

    public BigDecimal getSize() { return this.size; }


    @Override
    public void increaseCounter() {

    }
}