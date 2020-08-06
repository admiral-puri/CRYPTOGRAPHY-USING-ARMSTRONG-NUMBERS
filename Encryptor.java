package cryptography;

import java.io.*;

public class Encryptor 
{
    static void encrypt(String srcFile, String trgtFile, String key) throws Exception
    {
        //open the source file for reading
        FileInputStream fin = new FileInputStream(srcFile);
        //open the target file for writing
        FileOutputStream fout = new FileOutputStream(trgtFile);
        int n;
        byte buff[] = new byte[2048];
        while((n = fin.read(buff))!= -1)//read the source file
        {
            //encrypt : level1
            level1(buff, n, key);
            //encrypt : level2
            level2(buff, n, key);
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
        int i,data,r,c;
        int color[] = ColorManager.getColor(key);
        for(i =0 ; i < n; i++)
        {
            data = (int)buff[i] & 0xff;
            r = getHigherNibble(data);
            c = getLowerNibble(data);
            data = (color[i%color.length] + r *16 + c ) % 256;
            buff[i] = (byte)data;
        }
    }
    
    private static int getHigherNibble(int x)
    {
        return (x & 240)>>4;  //240:11110000
    }
    
    private static int getLowerNibble(int x)
    {
        return x & 15;  //15:00001111
    }    
}
