
import io.FileSystem;
import mediaDB.MediaContent;
import java.util.List;

public class AppIO {
    static FileSystem file;
    public static void main(String[] args) {
        read(file);
    }

    static void read(FileSystem file){
        List<MediaContent> list1 = file.readJOS("dump.txt");
        list1.forEach(e->{
            System.out.println(e);
        });

        List<MediaContent> list2 = file.readJBP("dump.xml");
        list2.forEach(e->{
            System.out.println(e);
        });
    }

}
