public class Counter implements AutoCloseable {
    static private int counter = 0;
    static private boolean openStatus = false;

    public Counter() throws Exception {
        open();
    }

    public static int GetCount() {
        return counter;
    }

    public void add() throws Exception {
        if (openStatus)
            counter++;
        else
            throw new RuntimeException("Counter closed");
    }

    public void open() throws Exception {
        if (openStatus)
            throw new RuntimeException("Counter busy");
        else
            openStatus = true;
    }

    @Override
    public void close() throws Exception {
        if(openStatus)
            openStatus = false;
        else
            throw new RuntimeException("Counter closed");
    }
}
