package warmup2.src;

public class Warmup2 {
    /**
     * Given a string and a non-negative int n, return a larger string that is n copies of the original string.
     *
     * stringTimes("Hi", 2) → "HiHi"
     * stringTimes("Hi", 3) → "HiHiHi"
     * stringTimes("Hi", 1) → "Hi"
     *
     * @param str
     * @param n
     * @return
     */
    public String stringTimes(String str, int n) {
        if (n == 0){
            return "";
        }
        String resultingString = "";
        for(int i = 0; i < n; i++){
            resultingString = resultingString + str;
        }
        return resultingString;
    }
    
    /**
     * Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;
     *
     * frontTimes("Chocolate", 2) → "ChoCho"
     * frontTimes("Chocolate", 3) → "ChoChoCho"
     * frontTimes("Abc", 3) → "AbcAbcAbc"
     *
     * @param str
     * @param n
     * @return
     */
    public String frontTimes(String str, int n) {
        int strLength = str.length();
        if (strLength == 0){
            return "";
        }
        else if (strLength < 4){
            String returnString = "";
            for (int i = 0; i < n; i++){
                returnString = returnString + str;
            }
            return returnString;
        }
        else {
            String front = str.substring(0, 3);
            String returnString = "";
            for (int i = 0; i < n; i++){
                returnString = returnString + front;
            }
            return returnString;
        }
    }
    
    /**
     * Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
     *
     * countXX("abcxx") → 1
     * countXX("xxx") → 2
     * countXX("xxxx") → 3
     *
     * @param str
     * @return
     */
    int countXX(String str) {
        if(str.length() < 2) {
            return 0;
        }
        else {
            int counter = 0;
            for(int i = 0; i < str.length() - 1; i++){
                String actual = str.substring(i, i + 2);
                if("xx".equals(actual)){
                    counter++;
                }
            }
            return counter;
        }
    }
    
    /**
     * Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
     *
     * doubleX("axxbb") → true
     * doubleX("axaxax") → false
     * doubleX("xxxxx") → true
     *
     * @param str
     * @return
     */
    boolean doubleX(String str) {
        if(str.length() < 2) {
            return false;
        }
        else {
            int indexOfFirstXInstance = str.indexOf('x');
            if(indexOfFirstXInstance == str.length() - 1 || indexOfFirstXInstance == - 1) {
                return false;
            }
            else {
                return str.charAt(indexOfFirstXInstance + 1) == 'x';
            }
        }
    }
    
    /**
     * Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
     *
     * stringBits("Hello") → "Hlo"
     * stringBits("Hi") → "H"
     * stringBits("Heeololeo") → "Hello"
     *
     * @param str
     * @return
     */
    public String stringBits(String str) {
        if(str.isEmpty()) {
            return "";
        }
        else {
            String returnString = "";
            for(int i = 0; i < str.length(); i = i + 2){
                returnString = returnString + str.charAt(i);
            }
            return returnString;
        }
    }
    
    /**
     * Given a non-empty string like "Code" return a string like "CCoCodCode".
     *
     * stringSplosion("Code") → "CCoCodCode"
     * stringSplosion("abc") → "aababc"
     * stringSplosion("ab") → "aab"
     *
     * @param str
     * @return
     */
    public String stringSplosion(String str) {
        String resultingString = "";
        for(int i = 1;i < str.length() + 1; i++){
            resultingString = resultingString + str.substring(0, i);
        }
        return resultingString;
    }
    
    /**
     * Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
     *
     * last2("hixxhi") → 1
     * last2("xaxxaxaxx") → 1
     * last2("axxxaaxx") → 2
     *
     * @param str
     * @return
     */
    public int last2(String str) {
        if(str.length() < 3){
            return 0;
        }
        int counter = 0;
        String endingString = str.substring(str.length() - 2);
        for(int i = 0; i < str.length() - 2; i++){
            String examinedSubString = str.substring(i, i + 2);
            if(examinedSubString.equals(endingString)){
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * Given an array of ints, return the number of 9's in the array.
     *
     * arrayCount9([1, 2, 9]) → 1
     * arrayCount9([1, 9, 9]) → 2
     * arrayCount9([1, 9, 9, 3, 9]) → 3
     *
     * @param nums
     * @return
     */
    public int arrayCount9(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        else {
            int counter = 0;
            for (int num : nums) {
                if (num == 9) {
                    counter++;
                }
            }
            return counter;
        }
    }
    
    /**
     * Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.
     *
     * arrayFront9([1, 2, 9, 3, 4]) → true
     * arrayFront9([1, 2, 3, 4, 9]) → false
     * arrayFront9([1, 2, 3, 4, 5]) → false
     *
     * @param nums
     * @return
     */
    public boolean arrayFront9(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        else {
            for(int i = 0; (i < nums.length && i < 4); i++){
                if(nums[i] == 9){
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
     *
     * array123([1, 1, 2, 3, 1]) → true
     * array123([1, 1, 2, 4, 1]) → false
     * array123([1, 1, 2, 1, 2, 3]) → true
     *
     * @param nums
     * @return
     */
    public boolean array123(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        else {
            for(int i = 0; i < nums.length - 2; i++){
                if(nums[i] == 1 && nums[i+1] == 2 && nums[i+2] == 3){
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
     *
     * stringMatch("xxcaazz", "xxbaaz") → 3
     * stringMatch("abc", "abc") → 2
     * stringMatch("abc", "axc") → 0
     *
     * @param a
     * @param b
     * @return
     */
    public int stringMatch(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if(aLen < 2 || bLen < 2){
            return 0;
        }
        else {
            int safeLength = Math.min(aLen, bLen);
            int counter = 0;
            for(int i = 0; i < safeLength - 1; i++){
                if(a.charAt(i) == b.charAt(i) && a.charAt(i + 1) == b.charAt(i + 1)){
                    counter++;
                }
            }
            return counter;
        }
    }
    
    /**
     * Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed.
     *
     * stringX("xxHxix") → "xHix"
     * stringX("abxxxcd") → "abcd"
     * stringX("xabxxxcdx") → "xabcdx"
     *
     * @param str
     * @return
     */
    public String stringX(String str) {
        if(str.length() < 3){
            return str;
        }
        else {
            String returnString = "" + str.charAt(0);
            for(int i = 1; i < str.length() - 1; i++){
                if(str.charAt(i) != 'x'){
                    returnString = returnString + str.charAt(i);
                }
            }
            returnString = returnString + str.charAt(str.length() - 1);
            return returnString;
        }
    }
    
    /**
     * Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
     *
     * altPairs("kitten") → "kien"
     * altPairs("Chocolate") → "Chole"
     * altPairs("CodingHorror") → "Congrr"
     *
     * @param str
     * @return
     */
    public String altPairs(String str) {
        if(str.isEmpty()){
            return str;
        }
        else {
            String returnString = "";
            for(int i = 0; i < str.length(); i = i + 4){
                returnString = returnString + str.charAt(i);
                if(i + 1 <= str.length() - 1){
                    returnString = returnString + str.charAt(i + 1);
                }
            }
            return returnString;
        }
    }
    
    /**
     * Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap.
     *
     * stringYak("yakpak") → "pak"
     * stringYak("pakyak") → "pak"
     * stringYak("yak123ya") → "123ya"
     *
     * @param str
     * @return
     */
    public String stringYak(String str) {
        if(str.length() < 3){
            return str;
        }
        else{
            char[] strAsTable = str.toCharArray();
            
            int i = 0;
            while(i < str.length() - 2){
                if(strAsTable[i] == 'y' && strAsTable[i + 2] == 'k'){
                    strAsTable[i] = ' ';
                    strAsTable[i + 1] = ' ';
                    strAsTable[i + 2] = ' ';
                    i = i + 3;
                }
                else {
                    i++;
                }
            }
            String resultingString = "";
            for(int j = 0; j < strAsTable.length; j++){
                if(strAsTable[j] != ' '){
                    resultingString = resultingString + strAsTable[j];
                }
            }
            return resultingString;
        }
    }
    
    /**
     * Given an array of ints, return the number of times that two 6's are next to each other in the array. Also count instances where the second "6" is actually a 7.
     *
     * array667([6, 6, 2]) → 1
     * array667([6, 6, 2, 6]) → 1
     * array667([6, 7, 2, 6]) → 1
     *
     * @param nums
     * @return
     */
    public int array667(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int counter = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)){
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. Return true if the array does not contain any triples.
     *
     * noTriples([1, 1, 2, 2, 1]) → true
     * noTriples([1, 1, 2, 2, 2, 1]) → false
     * noTriples([1, 1, 1, 2, 2, 2, 1]) → false
     *
     * @param nums
     * @return
     */
    public boolean noTriples(int[] nums) {
        if(nums.length < 3){
            return true;
        }
        for(int i = 0; i < nums.length - 2; i++){
            if((nums[i] == nums[i + 1]) && (nums[i] == nums[i + 2])){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value, followed by the value plus 5, followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
     *
     * has271([1, 2, 7, 1]) → true
     * has271([1, 2, 8, 1]) → false
     * has271([2, 7, 1]) → true
     *
     * @param nums
     * @return
     */
    public boolean has271(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        for(int i = 0; i < nums.length - 2; i++){
            int aValue = nums[i];
            int aValuePlus5 = nums[i + 1];
            int aValueMinus1 = nums[i + 2];
            if((aValuePlus5 == aValue + 5) && (aValueMinus1 <= aValue + 1) && (aValueMinus1 >= aValue - 3)){
                return true;
            }
        }
        return false;
    }
    
}
