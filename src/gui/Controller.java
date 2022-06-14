package gui;


import io.FileSystem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import mediaDB.*;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    static Action m = new Action();
    static FileSystem file = new FileSystem();

    private MediaContent media;

    @FXML
    private ListView<MediaContent> MediaList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       MediaList.getSelectionModel().selectedItemProperty().addListener(
               new ChangeListener<MediaContent>() {
                   @Override
                   public void changed(ObservableValue<? extends MediaContent> observableValue, MediaContent mediaContent, MediaContent t1) {
                        media= MediaList.getSelectionModel().getSelectedItem();
                   }
               }
       );
    }

    @FXML
    public void deleteMedia(){
        m.delete(media);
        update();

    }

    @FXML
    public void update(){
        MediaList.getItems().clear();
        MediaList.getItems().addAll(m.getAllFromList());
    }


    public void populate(){
        addMedia();
        update();
    }

    @FXML
    public void exit(){
        Platform.exit();
     }

    public void addMedia() {

        MediaContent media;

        Random rand = new Random();
        int n = rand.nextInt(4);
        switch (n) {
            case 0:
                media = new Audio();
                this.m.upload(media);
                break;
            case 1:
                media = new AudioVideo();
                this.m.upload(media);
                break;
            case 2:
                media = new InteractiveVideo();
                this.m.upload(media);
                break;
            case 3:
                media = new LicensedAudio();
                this.m.upload(media);
                break;

        }

    }

    public void saveJOS(){
        List<MediaContent> item = m.getAllFromList();
        file.writeJOS("test.txt",item);
    }

    public void saveJBP(){
        List<MediaContent> item = m.getAllFromList();
        file.writeJBP("test.xml",item);
    }

    public void readJOS(){
        clearScreen();
        List<MediaContent> item = file.readJOS("test.txt");
        item.forEach(e->{
            m.upload(e);
        });
        this.update();
    }

    public void readJBP(){
        clearScreen();
        List<MediaContent> item = file.readJBP("test.xml");
        item.forEach(e->{
            m.upload(e);
        });
        this.update();

    }

    public void clearScreen(){
        m.removeAll();
        this.update();
    }

}