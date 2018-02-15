/**
 * @author Jose Romero
 * @version 4/1/17
 */
import java.awt.Color; 
public class PhotoMagic
{
    /**
     * Encrypts or decrypts the picture by encrypting the values of each of the colors of each pixel
     * @param input A type Picture used as the image to be encrypted or decrypted
     * lfsrInput A type LFSR used to call the generate method and encrypt or decrypt the colors of the image
     * @exception Any exception
     * @return Returns the image inputted, but encrypted. If already was encrypted when run, returns the decrypted image
     */
    public static Picture transform(Picture input, LFSR lfsrInput){
        Picture outP = new Picture(input.width(), input.height());
        for(int i = 0; i < input.width(); i++){
            for(int j = 0; j < input.height(); j++){
                Color c = input.get(i,j);
                int redPart = c.getRed();//3 digit num
                int greenPart = c.getGreen();//3 digit num
                int bluePart = c.getBlue();//3 digit num
                int encryptNum1 = lfsrInput.generate(8);//generate(8) <-- gives a number for xoring
                int encryptNum2 = lfsrInput.generate(8);
                int encryptNum3 = lfsrInput.generate(8);
                Color encryptColor = new Color(redPart ^ encryptNum1, greenPart ^ encryptNum2, bluePart ^ encryptNum3);
                outP.set(i, j, encryptColor);
            }
        }
        return outP;
    }
    /**
     * Used for encrypting or decrypting an image with certain parameters, as well as saving the resulting image
     * @param args An array of Strings inputted from the console
     * @exception Any exception
     * @return Void
     */
    public static void main(String[] args){
        int tap = Integer.parseInt(args[2]);
        LFSR lfsr = new LFSR(args[1], tap);
        Picture p = new Picture (args[0]);
        Picture encrypted = transform(p, lfsr);
        encrypted.show();
        //encrypted.save("outdoorP.png");
    }
}
