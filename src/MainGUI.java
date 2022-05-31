import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {

    @Override
    public void start(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui/display.fxml"));
        Stage.setTitle("GUI CRUD");
        Stage.setScene(new Scene(root, 700, 500));
        Stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
