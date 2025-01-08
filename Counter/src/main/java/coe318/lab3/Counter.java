/**
 *
 * @author Julian Goncalves
 */
package coe318.lab3;
public class Counter {  
    //Instance variables here
    private int modu;
    private int digi;
    private Counter digiLeft;
    public Counter(int modulus, Counter left) {
        modu = modulus;
        digiLeft = left;
    }


    /**
     * @return the modulus
     */
    public int getModulus() {
        return modu;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        if (digiLeft == null){
            return null;
        }else{
            return digiLeft;
        }
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return digi;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        digi = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        digi++;
        if(digi >= modu){
            digi = 0;
            if(digiLeft != null){
                digiLeft.increment();
            }
        }
    
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        if(digiLeft == null){
            return digi;
        }else{
            return((modu*digiLeft.getCount())+digi);
        }
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
