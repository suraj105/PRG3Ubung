package mediaDB;

interface UploaderInterface{
    String getName();
}

public class Uploader implements UploaderInterface {
    private String name;

    public Uploader( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

