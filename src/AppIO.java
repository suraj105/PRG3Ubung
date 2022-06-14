
import io.FileSystem;
import mediaDB.MediaContent;
import java.util.List;

public class AppIO {

    public static void main(String[] args) {

        FileSystem file = new FileSystem();


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
