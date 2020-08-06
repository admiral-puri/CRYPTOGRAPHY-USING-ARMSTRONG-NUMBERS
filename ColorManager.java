package cryptography;

public class ColorManager 
{
    static int[] getColor(String key)
    {
        int color[] = new int[3];
        color[0] = (Integer.parseInt(key.substring(12)) + Integer.parseInt(key.substring(0, 4)))%256;
        color[1] = (Integer.parseInt(key.substring(12)) + Integer.parseInt(key.substring(4, 8)))%256;
        color[2] = (Integer.parseInt(key.substring(12)) + Integer.parseInt(key.substring(8, 12)))%256;
        
        return color;
        
    }
}
