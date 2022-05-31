package sim;

import mediaDB.Action;
import utiliries.EventHandler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class CreateThread extends Thread {
    private EventHandler handler;
    private Action c;
    public CreateThread(EventHandler handler){
        this.handler = handler;
        this.c =c;
    }

    /**
     * tried not to use thread.sleep
     * @param 2 handle adds media content
     * @param random() generates Random number between 500 and 1000
     */

    public void run(){
        while (true){
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(random()));
            handler.handle(2);
        }
    }

    private int random(){
        int random = (int )(Math.random() * 500 + 1);
        random+= 500;
        return random;
    }
}
