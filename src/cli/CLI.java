package cli;

import utiliries.EventHandler;

public class CLI {
    EventHandler handler;

    public CLI( EventHandler handler ) {
        this.handler = handler;
    }


    public void run() {
            new CReader( handler ).start();
    }
}
