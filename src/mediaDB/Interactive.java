package mediaDB;

interface InteractiveInterface extends ContentInterface {
    String getType();
}

public class Interactive extends Content implements InteractiveInterface {
    String type;

    public Interactive( String address, Uploader uploader, String type ) {
        super( address, uploader );
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}