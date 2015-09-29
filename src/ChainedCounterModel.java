/**
 * Created by Niklas on 2015-09-29.
 */
public class ChainedCounterModel extends CounterModel{

    private CounterInterface next;

    public ChainedCounterModel(int init, int modulus, CounterInterface next) {
        super(modulus);
        this.next = next;
        for (int k = 0; k < init; k++) {
            this.increment();
        }
    }

    @Override
    public void increment() {
        super.increment();
        if (this.getValue() == 0 && next != null) {
            next.increment();
        }
    }
}
