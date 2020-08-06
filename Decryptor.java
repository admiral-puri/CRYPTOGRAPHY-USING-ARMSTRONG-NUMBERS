package cryptography;
import java.io.*;

public class Decryptor 
{

    static void decrypt(String srcFile, String trgtFile, String key) throws Exception
    {
        //open the source file for reading
        FileInputStream fin = new FileInputStream(srcFile);
        //open the target file for writing
        FileOutputStream fout = new FileOutputStream(trgtFile);
        
        int n;
        byte buff[] = new byte[2048];
        
        while((n = fin.read(buff))!= -1)//read the source file
        {
            //decrypt : level2 
            level2(buff, n , key);
            //decrypt : level1
            level1(buff, n, key);
            //write into the target file
            fout.write(buff,0,n);
        }
        fout.flush();
        fin.close();
        fout.close();

    }

    private static void level1(byte buff[], int n, String key)
    {
        int i, keylength, data;
        keylength = key.length();
        for(i =0 ; i < n; i++)
        {
            data = (int)buff[i] & 0xff;
            data = data ^ (int)key.charAt(i%keylength);
            buff[i] = (byte)data;
        }
    }
    
    private static void level2(byte buff[], int n, String key)
    {
        int i,data, temp, r,c;
        int color[] = ColorManager.getColor(key);
        for(i =0 ; i < n; i++)
        {
            data = (int)buff[i] & 0xff;
            temp = (data - color[i%color.length] + 256)%256;
            r = temp/16;
            c = temp%16;
            buff[i] = (byte)merge(r, c);
        }
    }
    
    private static int merge(int nibble1, int nibble2)
    {
        return (nibble1 << 4) | nibble2;
    }
}
