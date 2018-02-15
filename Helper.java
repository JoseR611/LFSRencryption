/**
 * @author Jose Romero 
 * @version 4/1/17
 */
public class Helper
{
    /**
     * Prints error message if the inputs are not 0 or 1 or finds the XOR of a and b
     * @param a Contains a char
     * b Contains a char
     * @exception Any exception
     * @return The XOR of a and b if they are 0 or 1, or X if not
     */
    static char xor(char a, char b){
        if(a == '0' || a == '1' || b == '0' || b == '1'){
            return (char)((a ^ b) + 48);//add 48 to get 1 as char
        }else{
            System.out.println("Error: One or more of the inputs either non-one or non-zero characters");
            return 'X';
        }
    }
    /**
     * Converts a binary number to a base ten number 
     * @param s Contains a string
     * @exception Any exception
     * @return -1 if there is a non-zero or non-one character in s or return value of binary string as an int
     */
    static int binaryToDec (String s){
        int baseTen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0' || s.charAt(i) == '1'){
                if(s.charAt(i) == '1'){
                    baseTen = baseTen + (int)Math.pow(2, s.length() - 1 - i);//if 0 add nothing
                }
            }else{
                System.out.println("Error: One or more of the characters in the input string is not 0 or 1.");
                return -1;
            }
        }
        return baseTen;
    }
    /**
     * Tests the methods xor and binaryToDec and prints the results on screen
     * @param arg A string array containing the command line arguments
     * @exception Any exception
     * @return No return value
     */
    public static void main(String[] args){
        char a = xor('0', '1');
        char b = xor('1', '1');
        char c = xor('v', 's');
        char d = xor('1', '0');
        char e = xor('0', '0');
        System.out.println("XOR of 0 and 1. Expected output 1. Actual output " + a);
        System.out.println("XOR of 1 and 1. Expected output 0. Actual output " + b);
        System.out.println("XOR of v and s. Expected output X. Actual output " + c);
        System.out.println("XOR of 1 and 0. Expected output 1. Actual output " + d);
        System.out.println("XOR of 0 and 0. Expected output 0. Actual output " + e);
        int f = binaryToDec ("1111");//should store 15
        int g = binaryToDec ("1234");
        int h = binaryToDec ("10010101010");//should store 1194
        int i = binaryToDec ("101101010101010");//should store 23210
        int j = binaryToDec ("1");
        int k = binaryToDec ("0");
        System.out.println("Base ten of 1111. Expected output 15. Actual output " + f);
        System.out.println("Base ten of 1234. Expected output -1. Actual output " + g);
        System.out.println("Base ten of 10010101010. Expected output 1194. Actual output " + h);
        System.out.println("Base ten of 101101010101010. Expected output 23210. Actual output " + i);
        System.out.println("Base ten of 1. Expected output 1. Actual output " + j);
        System.out.println("Base ten of 0. Expected output 0. Actual output " + k);
    }
}
