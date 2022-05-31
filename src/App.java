import  cli.CLI;
import cli.CReader;
import mediaDB.Action;
import utiliries.EventHandler;


public class App {
    public static void main(String[] args) {
        Action m = new Action();
        CReader listener = new CReader(m);
        EventHandler handler = new EventHandler(listener);
        CLI c = new CLI(handler);
        c.run();
    }
}
