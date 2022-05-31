package mediaDB;

import java.util.Collection;
import java.util.*;

interface ContentInterface {
    String getAddress();
    Collection<Tag> getTags();
    long getAccessCount();
}

public class Content extends Uploadable implements ContentInterface {
    private String address;
    private LinkedList<Tag> tags = new LinkedList<Tag>();
    public long accessCount;



    public Content() { super(); }
    public Content( String address, Uploader uploader ) {
        super( uploader );
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public Collection<Tag> getTags() { return this.tags; }

    public long getAccessCount() {
        return this.accessCount;
    }

}