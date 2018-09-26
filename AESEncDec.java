import java.security.Key;
import java.security.Security;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncDec {

private static SecretKey key = null;         
   private static Cipher cipher = null; 

   public static void main(String[] args) throws Exception
   {

      KeyGenerator keyGenerator =
         KeyGenerator.getInstance("AES"); //Key Generator

      keyGenerator.init(128);
      SecretKey secretKey = keyGenerator.generateKey();
      cipher = Cipher.getInstance("AES"); //Cipher

      String clearText = "AES encryption";  // Plain text to be encrypted
      byte[] clearTextBytes = clearText.getBytes("UTF8");

      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      byte[] cipherBytes = cipher.doFinal(clearTextBytes);
      String cipherText = new String(cipherBytes, "UTF8");

      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      byte[] decryptedBytes = cipher.doFinal(cipherBytes);
      String decryptedText = new String(decryptedBytes, "UTF8");

      System.out.println("Before encryption: " + clearText);
      System.out.println("After encryption: " + cipherText);
      System.out.println("After decryption: " + decryptedText);
   }
}
