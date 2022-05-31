package mediaDB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;

import static  org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionTest {
    Action c;
    int samplingRate;
    long testBitrate;
    String testAddress;
    Uploader uploader;
    MediaContent testItem;
    BigDecimal testSize;
    Duration testDuration ;
    MediaContent file = new MediaContent();




    @BeforeEach
    void startUp() {
        this.c = new Action( );
        this.uploader = this.c.createUploader( "Uploader" );

        this.testItem = new MediaContent( this.testAddress, this.uploader, this.testBitrate, this.testDuration, this.testSize );
    }

    @Test
    void upload() {
        this.c.upload(this.testItem);
        assertTrue(this.c.getAllFromList().contains(this.testItem));
    }

    @Test
    void uploader(){
        ArrayList<Uploader> uploaders = new ArrayList<Uploader>();
        Uploader a = new Uploader("habibi");
        Uploader b = new Uploader("habibi");
        uploaders.add(a);
        uploaders.add(b);
        Assertions.assertEquals(2, uploaders.size());

    }

    @Test
    void upload1(){
        Audio audio = new Audio(this.testAddress,this.testBitrate,this.testDuration,this.testSize,this.uploader,this.samplingRate);
        c.upload(audio);
        assertTrue(this.c.getAllFromList().contains(audio));

    }
    @Test
    void delete()
    {
        this.c.delete(this.testItem);
        assertFalse(this.c.getAllFromList().contains(this.testItem));
    }

    @Test
    void delete1(){
        Audio audio = new Audio(this.testAddress,this.testBitrate,this.testDuration,this.testSize,this.uploader,this.samplingRate);
        c.delete(audio);
        assertFalse(this.c.getAllFromList().contains(audio));

    }

    @Test
    void update(){
        MediaContent newSampleItem = new MediaContent("abc",this.uploader,(long)22,this.testDuration,this.testSize);
        this.c.upload(newSampleItem);
        this.c.update(this.c.getAllFromList().get(0));
        this.c.update(this.c.getAllFromList().get(0));
        assertTrue(this.c.getAllFromList().get(0).getAccessCount() != 1);

    }

    @Test
    public void testSize(){
        this.c.upload(file);
        Assertions.assertEquals(this.c.getAllFromList().get(0),file);
    }

    @Test
    public void hasUploader(){
        Uploader uploader = new Uploader("uploader1");
        this.c.setUploaders(uploader);
        Assertions.assertEquals(uploader,this.c.getUploader());
    }


}
