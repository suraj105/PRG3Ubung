package mediaDB;

interface LicensedInterface extends ContentInterface {
        String getHolder();
        }

public class Licensed extends Content implements LicensedInterface {
    String holder;
    public Licensed( String address, Uploader uploader, String holder ) {
        super(address, uploader);
        this.holder = holder;
    }

    public String getHolder() {
        return this.holder;
    }
}