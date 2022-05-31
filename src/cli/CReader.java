package cli;

import mediaDB.*;
import utiliries.EventHandler;
import utiliries.EventListenerInterface;


import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class CReader implements EventListenerInterface {
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final Set<String> identifiers = new HashSet<String>();

    Random rand = new Random();

    // pre definining values as mentioned in the ubung,
   // String sampleAddress = "Audio video file";
    //String sampleAddress2 = "Interactive Video file";
   // long sampleBitrate = 1L;
    //BigDecimal sampleSize = new BigDecimal( 1000 );
    //Duration sampleDuration = Duration.ofSeconds( 0 + 1 * 60 + 0 * 60 * 60); // taking as 1 min
    Scanner scan = new Scanner(System.in);
    EventHandler handler;
    Action c;
    public CReader(EventHandler handler) {
        this.handler = handler;
    }

    public CReader(Action c) {
        this.c = c;
    }

    public void start(){
        System.out.println("Welcome to JAVA CLI");
        while(true){


            System.out.println( ".... What do you want to do..... ");
            System.out.println();
            System.out.println("press 1 to add a producer");
            System.out.println("press 2 to add already defined media file");
            System.out.println("press 3 to update media file");
            System.out.println("press 4 to delete a media file");
            System.out.println("press 0 to exit program");
            Scanner scan = new Scanner(System.in);
            try{
                int a = scan.nextInt();
                if (a < 0 || a >5) {
                    System.out.println("Invalid number, please try again");
                }
                handler.handle(a);
            }
            catch (NumberFormatException e){
                System.out.println(e);
            }

        }
    }

    public void AddProducer(){
        Action c = new Action();
        System.out.println("Enter producer name");
        String name= scan.nextLine();
        c.createUploader(name);
        System.out.println(name + " producer added");

    }




    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
    @Override
    public void onEvent(int choose) {
        switch(choose){
            case 0:
                System.exit(0);
            case 1:
                System.out.println(randomIdentifier()+" Producer added");
                break;
            case 2:
                MediaContent media;
                Random rand = new Random();
                int n = rand.nextInt(4);
                switch ( n ){
                    case 0:
                        media = new Audio();
                        System.out.println("Random Audio added");
                        this.c.upload(media);
                        break;
                    case 1:
                        media = new AudioVideo();
                        System.out.println("Random AudioVideo added");
                        this.c.upload(media);
                        break;
                    case 2:
                        media = new InteractiveVideo();
                        System.out.println("Random InteracriveVideo added");
                        this.c.upload(media);
                        break;
                    case 3:
                        media = new LicensedAudio();
                        System.out.println("Random LicensedVideo added");
                        this.c.upload(media);
                        break;

                }
                break;
            case 3:
                try{
                    MediaContent mediaUpdate = this.c.getAllFromList().get(0);
                    this.c.update(mediaUpdate);
                    System.out.println("Media updated");

                }
                catch (Exception e){
                    System.out.println(e);
                    System.out.println("there is no item to update");
                }

                break;
            case 4:
                try{
                    MediaContent mediaDelete = this.c.getAllFromList().get(0);
                    this.c.delete(mediaDelete);
                    System.out.println("1 Media deleted");
                }
                catch (Exception e){
                    System.out.println(e);
                    System.out.println("List is empty, no item to delete");
                }

                break;

        }

    }


}
