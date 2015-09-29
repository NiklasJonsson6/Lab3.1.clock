/**
 * Created by Niklas on 2015-09-21.
 */
public class CounterModel implements CounterInterface {

    private int value = 0; //start value
    private int modulus; //"wraps around" to 0 at:

    public CounterModel() {
        this.modulus = 15;
    }

    /**
     *
     * @param modulus   The counter's maximum value, where it will start over from 0
     */
    public CounterModel(int modulus) {
        if (modulus < 1) {
            throw new IllegalArgumentException("The counter's maximum value has to be > 1!");
        }
        this.modulus = modulus;
    }

    /**
     * Increases the value of the counter (+1)
     */
    public void increment() {
        this.value = (this.value + 1) % this.modulus;
    }

    /**
     * Decreases the value of the counter (+1)
     */
    public void decrement() {
        this.value--;
        if (this.value == this.modulus){
            this.value = 0;
        }
    }

    public void reset() {
        this.value = 0;
    }

    public int getValue() {
        return this.value;
    }

    public int getModulus() {
        return this.modulus;
    }

    @Override
    public String toString() {
        return "Current value: " + this.value;
    }

    @Override
    public boolean equals(Object r) {
        if (this == r) {
            return true;
        }
        if (r == null || this.getClass() != r.getClass()) {
            return false;
        }

        return this.value == ((CounterModel)r).value;

        //return super.equals(r) && this.value == ((CounterModel)r).value;
    }
}
