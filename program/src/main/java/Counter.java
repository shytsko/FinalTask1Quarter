public class Counter implements AutoCloseable
{
    private int counter;
    private boolean open;

    public Counter() {
        this.counter = 0;
        this.open = false;
    }

    public void add() {
        if(this.open)
            counter++;
        else
            throw new RuntimeException("Counter not open");
    }

    @Override
    public void close() throws Exception {
        this.open = false;
    }
}
