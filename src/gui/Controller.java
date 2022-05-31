package gui;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import mediaDB.*;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    static Action m = new Action();

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
        updateLists();

    }

    @FXML
    public void updateLists(){
        MediaList.getItems().clear();
        MediaList.getItems().addAll(m.getAllFromList());
    }


    public void populate(){
        addMedia();
        updateLists();
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

}