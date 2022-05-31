package sim;

import mediaDB.Action;
import utiliries.EventHandler;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class DeleteThread extends Thread {

    private Action c;
    private EventHandler handler;

    public DeleteThread(EventHandler handler){
        this.handler = handler;
        this.c = c;
    }

    /**
     * tried not to use thread.sleep
     * @param 4 handle delete media content
     * @param random() generates Random number between 1000 and 2000
     */
    public void run(){
        while(true){
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(random()));
            handler.handle(4);

        }
    }

    private int random(){
        int random = (int )(Math.random() * 1000 + 1);
        random+= 1000;
        return random;
    }

}
