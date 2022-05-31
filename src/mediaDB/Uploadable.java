package mediaDB;

import java.util.Date;

interface UploadableInterface{
    UploaderInterface getUploader();
    Date getUploadDate();
}

public class Uploadable  implements UploadableInterface {
    Uploader uploader;
    Date date;

    public Uploadable() {}
    public Uploadable( Uploader uploader ) {
        this.uploader = uploader;
    }

    public Uploader getUploader() {
        return this.uploader;
    }

    public Date getUploadDate() { return this.date; }
}