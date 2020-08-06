package cryptography;

public class Main 
{
    
    public static void main(String[] args) 
    {
        try
        {
            String original = "D:/Rahul classes/Java/Project/a.jpg";
            String secured= "D:/Rahul classes/Java/Project/secured_pb.jpg";
            String regained= "D:/Rahul classes/Java/Project/again_pb.jpg";
            String textKey = "secure MY data";
            String key = KeyManager.generateKey(textKey);

            Encryptor.encrypt(original, secured, key);
            Decryptor.decrypt(secured, regained, key);
            System.out.println("OK");
        }
        catch(Exception ex)
        {
            System.out.println("Err:"+ ex);
        }
    }
    
}
