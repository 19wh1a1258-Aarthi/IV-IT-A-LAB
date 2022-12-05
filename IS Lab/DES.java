import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.*;
public class DES
{
        static Scanner sc = new Scanner(System.in);
        public static void main(String[] argv)
        {
                try
                {
                        System.out.println("Message Encryption Using DES Algorithm\n-------");
                        KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
                        SecretKey myDesKey = keygenerator.generateKey();
                        Cipher desCipher;
                        desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
                        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
                        System.out.println("Enter the message to be encrypted:");
                        String msg = sc.nextLine();
                        byte[] text = msg.getBytes();
                        System.out.println("Message to be encrypted[Byte Format] : " + text);
                        System.out.println("Message to be encrypted : " + new String(text));
                        byte[] textEncrypted = desCipher.doFinal(text);
                        System.out.println("Encrypted Message: " + textEncrypted);
                        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
                        byte[] textDecrypted = desCipher.doFinal(textEncrypted);
                        System.out.println("Decrypted Message: " + new String(textDecrypted));
                }
                catch(NoSuchAlgorithmException e)
                {
                        e.printStackTrace();
                }
                catch(NoSuchPaddingException e)
                {
                        e.printStackTrace();
                }
                catch(InvalidKeyException e)
                {
                        e.printStackTrace();
                }
                catch(IllegalBlockSizeException e)
                {
                        e.printStackTrace();
                }
                catch(BadPaddingException e)
                {
                        e.printStackTrace();
                }
        }
}

