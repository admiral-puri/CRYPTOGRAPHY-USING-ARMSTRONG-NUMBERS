package cryptography;

public class KeyManager 
{
    private static int getKeyValue(String str)
    {//ASCII SUM
        int sum =0 ; 
        int i, len;
        len = str.length();
        for(i = 0; i < len; i++)
            sum+=(int)str.charAt(i);
        
        return sum;
    }
    
    static String generateKey(String str)
    {
        int keyValue, permutation;
        int x;
        String key = "";
        keyValue = getKeyValue(str);
        permutation = ArmstrongManager.getPermutation(keyValue);
        while(permutation > 0)
        {
            key = ArmstrongManager.getArmstrongNumber(permutation%10-1)+ key;
            permutation/=10;
        }
        key = key + keyValue;
        return key;
    }
    
    
    
}
