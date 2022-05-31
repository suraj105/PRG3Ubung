package mediaDB;

interface AccessCounterI {
    public void increaseCounter();
}

public class AccessCounter implements AccessCounterI {
    int counter;

    public int getCounter() {
        return counter;
    }

    @Override
    public void increaseCounter() {
    this.counter++;
    }
}
