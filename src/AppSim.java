import cli.CReader;
import mediaDB.Action;
import sim.CreateThread;
import sim.DeleteThread;
import utiliries.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class AppSim {


    public static void main(String[] args) {
        Action m = new Action();
        CReader listener = new CReader(m);
        EventHandler handler = new EventHandler(listener);

        List<CreateThread> createList = new ArrayList<>();
        List<DeleteThread> deleteList = new ArrayList<>();

        print("Starting Simulation ......... a Media gets added every 500-1000ms and a Media gets deleted every 1000-2000ms to replicate simulation");
        print("");

        createThreads(createList,handler);
        deleteThreads(deleteList,handler);

    }

    static void createThreads(List<CreateThread> list, EventHandler handler){
       list.add(new CreateThread(handler));;
        for (CreateThread e : list) {
            e.start();
        }
    }

    static void deleteThreads(List<DeleteThread> list, EventHandler handler){
            list.add(new DeleteThread(handler));
        for (DeleteThread e :list){
            e.start();
        }
    }

    static void print(String string){
        System.out.println(string);
    }
}
