package utiliries;

import cli.CReader;

import java.util.LinkedList;
import java.util.List;

public class EventHandler {
     List<CReader> list = new LinkedList<>();

    public EventHandler(CReader listeners) {
        list.add(listeners);
    }

    public void add(CReader listener ) {
        this.list.add( listener );
    }
    public void remove( CReader listener ) {
        this.list.remove( listener );
    }
    public void handle( int event ) {
        for ( CReader listener : this.list )
            listener.onEvent( event );
    }

}