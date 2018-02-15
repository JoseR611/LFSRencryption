/**
 * @author Jose Romero
 * @version (a version number or a date)
 */
public class LFSR
{
    private String register;
    private String[] binaryDigits;
    private int tap;
    /**
     * Modifies the attributes of the class
     * @param seed A string used to put into the attribute register
     * posOfTapBit An int used to put into the attribute tap
     * @exception Any exception
     * @return No return value
     */

    public LFSR(String seed, int posOfTapBit){
        register = seed;
        tap = posOfTapBit;
    }
    /**
     * Gives the object a String name when printing on terminal
     * @param None
     * @exception Any exception
     * @return Returns a String, which is the register of the class
     */
    public String toString(){
        return register;
    }
    /**
     * Shifts the register by a value of one, with the last value being the xor of the first value and 
     * the value at the tap position
     * @param None
     * @exception Any exception
     * @return Returns an int, which is the bit that was shifted on the rightmost side
     */
    public int step(){
        binaryDigits = register.split("");
        int[] afterStep = new int [binaryDigits.length];
        int zeroBinary = Integer.parseInt(binaryDigits[0]);
        int tapBinary = Integer.parseInt(binaryDigits[tap]);
        for(int i = 0; i < register.length(); i++){
            if(i < register.length() - 1){
                afterStep[i] = Integer.parseInt(binaryDigits[i + 1]);
            }else{
                afterStep[i] = zeroBinary ^ tapBinary; 
            }
        }
        register = "";
        for(int i = 0; i < afterStep.length; i++){
            register = register + afterStep[i];
        }
        return afterStep[register.length() - 1];
    }
    /**
     * Runs the step method a certain number of times
     * @param numOfSteps An int determining the number of times the step method should be run
     * @exception Any exception
     * @return An int, which is the base 10 representation of all the new bits shifted in
     */
    public int generate(int numOfSteps){
        int[] binaryShift = new int [numOfSteps];
        for(int i = 0; i < numOfSteps; i++){
            binaryShift[i] = step();
        }
        String newBinary = "";
        for(int i = 0; i < binaryShift.length; i++){
            newBinary = newBinary + binaryShift[i];
        }
        return Helper.binaryToDec(newBinary);
    }
    /**
     * Tests out each method in the LFSR class
     * @param args An array of strings inputted from the console
     * @exception Any exception
     * @return Void
     */
    public static void main(String args[]){
        LFSR lfsr = new LFSR("01101000010", 2);
        //System.out.println(lfsr);
        /*
        for(int i = 0; i < 10 ; i++){
            int bit = lfsr.step();
            System.out.println(lfsr + " " + bit);
        }
        */
        
        for (int i = 0; i < 10; i++){
            int r = lfsr.generate(5);
            System.out.println(lfsr + " " + r);
        }
        
    }
}
