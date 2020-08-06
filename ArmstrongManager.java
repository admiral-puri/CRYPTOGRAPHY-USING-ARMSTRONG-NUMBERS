package cryptography;

public class ArmstrongManager 
{
    private static int armstrongNumbers[] = {153,370,371,407};
    private static int baseTable[] = {1234,1243,1324,1342,1423,1432,2134,2143,2314,2341,2413,2431,3124,3142,3214,3241,3412,3421,4123,4132,4213,4231,4312,4321};
    
    static int getPermutation(int keyValue)
    {
        return baseTable[keyValue % baseTable.length];
    }
    
    static int getArmstrongNumber(int x)
    {
        return armstrongNumbers[x];
    }
    
}
