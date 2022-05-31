package mediaDB;

import java.util.ArrayList;
import java.util.List;

public class Action extends MediaContent {

   static ArrayList<MediaContent> c = new ArrayList<MediaContent>();



    //for inserting into the list
    public synchronized void upload(MediaContent item) {
        this.c.add( item);
    }


    ArrayList<Uploader> uploaders = new ArrayList<>();


    public synchronized   Uploader createUploader( String name ) {
        Uploader upload = new Uploader( name );
      this.uploaders.add( upload );
        return upload;
    }

    //replace item 1 with item 2
    public synchronized void update( MediaContent item) {

        item.increaseCounter();

    }

    //deletes the searched item from the list.
    public synchronized void delete(MediaContent item) {
        if(this.c.size()< 0 ){

        }
        else

        try{
            this.c.remove(this.c.size()-1);
        }
        catch (Exception e) {
            System.out.println("There are no more Media Files in the list ");
        }

    }



    public synchronized List<MediaContent> getAllFromList(){
        return this.c;
    }

    public  void setUploaders(Uploader uploader){
        this.uploader=uploader;
    }


}
