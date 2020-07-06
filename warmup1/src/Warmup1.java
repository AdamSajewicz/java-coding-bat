package warmup1.src;

/**
 * Simple warmup problems to get started
 */
public class Warmup1 {
    /**
     * The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
     *
     * sleepIn(false, false) → true
     * sleepIn(true, false) → false
     * sleepIn(false, true) → true
     *
     * @param weekday
     * @param vacation
     * @return
     */
    public boolean sleepIn(boolean weekday, boolean vacation) {
        return (!weekday || vacation);
    }
    
    /**
     * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.
     *
     * monkeyTrouble(true, true) → true
     * monkeyTrouble(false, false) → true
     * monkeyTrouble(true, false) → false
     *
     * @param aSmile
     * @param bSmile
     * @return
     */
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return (aSmile == bSmile);
    }
    
    /**
     * Given two int values, return their sum. Unless the two values are the same, then return double their sum.
     *
     * sumDouble(1, 2) → 3
     * sumDouble(3, 2) → 5
     * sumDouble(2, 2) → 8
     *
     * @param a
     * @param b
     * @return
     */
    public int sumDouble(int a, int b) {
        int suma = a + b;
        if(a == b){
            return suma * 2;
        }
        return suma;
    }
    
    /**
     * Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.
     *
     * diff21(19) → 2
     * diff21(10) → 11
     * diff21(21) → 0
     *
     * @param n
     * @return
     */
    public int diff21(int n) {
        int absoluteDiference;
        if (n < 0) {
            absoluteDiference = n * (-1) + 21;
        }
        else if (n >= 0 && n < 21) {
            absoluteDiference = 21 - n;
        }
        else {
            absoluteDiference = n - 21;
        }
        if (n >= 21) return absoluteDiference * 2;
        return absoluteDiference;
    }
    
    /**
     * We have a loud talking parrot. The "hour" parameter is the current hour time in the range 0..23. We are in trouble if the parrot is talking and the hour is before 7 or after 20. Return true if we are in trouble.
     *
     * parrotTrouble(true, 6) → true
     * parrotTrouble(true, 7) → false
     * parrotTrouble(false, 6) → false
     *
     * @param talking
     * @param hour
     * @return
     */
    public boolean parrotTrouble(boolean talking, int hour) {
        boolean trouble;
        trouble = (talking && (hour < 7 || hour > 20));
        return trouble;
    }
    
    /**
     * Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.
     *
     * makes10(9, 10) → true
     * makes10(9, 9) → false
     * makes10(1, 9) → true
     *
     * @param a
     * @param b
     * @return
     */
    public boolean makes10(int a, int b) {
        int c = a + b;
        return (a == 10 || b == 10 || c == 10);
    }
    
    /**
     * Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes the absolute value of a number.
     *
     * nearHundred(93) → true
     * nearHundred(90) → true
     * nearHundred(89) → false
     *
     * @param n
     * @return
     */
    public boolean nearHundred(int n) {
        int distanceTo100 = Math.abs(n - 100);
        int distanceTo200 = Math.abs(n - 200);
        return ((distanceTo100 <= 10) || (distanceTo200 <= 10));
    }
    
    /**
     * Given 2 int values, return true if one is negative and one is positive. Except if the parameter "negative" is true, then return true only if both are negative.
     *
     * posNeg(1, -1, false) → true
     * posNeg(-1, 1, false) → true
     * posNeg(-4, -5, true) → true
     *
     * @param a
     * @param b
     * @param negative
     * @return
     */
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0);
        }
        else {
            return (a * b < 0);
        }
    }
    
    /**
     * Given a string, return a new string where "not " has been added to the front. However, if the string already begins with "not", return the string unchanged. Note: use .equals() to compare 2 strings.
     *
     * notString("candy") → "not candy"
     * notString("x") → "not x"
     * notString("not bad") → "not bad"
     *
     * @param str
     * @return
     */
    public String notString(String str) {
        String prefix = "not";
        int firstIndexOfPrefix = str.indexOf(prefix);
        if (firstIndexOfPrefix == 0) {
            return str;
        } else {
            return prefix + " " + str;
        }
    }
    
    /**
     * Given a non-empty string and an int n, return a new string where the char at index n has been removed. The value of n will be a valid index of a char in the original string (i.e. n will be in the range 0..str.length()-1 inclusive).
     *
     * missingChar("kitten", 1) → "ktten"
     * missingChar("kitten", 0) → "itten"
     * missingChar("kitten", 4) → "kittn"
     *
     *
     *
     * @param str
     * @param n
     * @return
     */
    public String missingChar(String str, int n) {
        if(n == 0) {
            return str.substring(1);
        }
        else if (n == str.length() - 1) {
            return str.substring(0, str.length() - 1);
        }
        else {
            return str.substring(0, n) + str.substring(n+1);
        }
    }
    
    /**
     * Given a string, return a new string where the first and last chars have been exchanged.
     *
     * frontBack("code") → "eodc"
     * frontBack("a") → "a"
     * frontBack("ab") → "ba"
     *
     * @param str
     * @return
     */
    public String frontBack(String str) {
        if(str.isEmpty() || str.length() == 1){
            return str;
        }
        else {
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            String inside = str.substring(1, str.length() - 1);
            return last + inside + first;
        }
    }
    
    /**
     * Given a string, we'll say that the front is the first 3 chars of the string. If the string length is less than 3, the front is whatever is there. Return a new string which is 3 copies of the front.
     *
     * front3("Java") → "JavJavJav"
     * front3("Chocolate") → "ChoChoCho"
     * front3("abc") → "abcabcabc"
     *
     * @param str
     * @return
     */
    public String front3(String str) {
        if(str.length() <= 3) {
            return str + str + str;
        }
        else {
            String front = str.substring(0, 3);
            return front + front + front;
        }
    }
    
    /**
     * Given a string, take the last char and return a new string with the last char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more.
     *
     * backAround("cat") → "tcatt"
     * backAround("Hello") → "oHelloo"
     * backAround("a") → "aaa"
     *
     * @param str
     * @return
     */
    public String backAround(String str) {
        if(str.length() == 1){
            return str + str + str;
        }
        else{
            char last = str.charAt(str.length() - 1);
            return last + str + last;
        }
    }
    
    /**
     * Return true if the given non-negative number is a multiple of 3 or a multiple of 5. Use the % "mod" operator -- see Introduction to Mod
     *
     * or35(3) → true
     * or35(10) → true
     * or35(8) → false
     *
     * @param n
     * @return
     */
    public boolean or35(int n) {
        int divideBy3 = n % 3;
        int divideBy5 = n % 5;
        return (divideBy3 * divideBy5 == 0);
    }
    
    /**
     * Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back, so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.
     *
     * front22("kitten") → "kikittenki"
     * front22("Ha") → "HaHaHa"
     * front22("abc") → "ababcab"
     *
     * @param str
     * @return
     */
    public String front22(String str) {
        
        if(str.length() <= 2){
            return str + str + str;
        }
        else{
            String prefix = str.substring(0, 2);
            return prefix + str + prefix;
        }
    }
    
    /**
     * Given a string, return true if the string starts with "hi" and false otherwise.
     *
     * startHi("hi there") → true
     * startHi("hi") → true
     * startHi("hello hi") → false
     *
     * @param str
     * @return
     */
    public boolean startHi(String str) {
        if(str.length() < 2) {
            return false;
        }
        else {
            String actualPrefix = str.substring(0, 2);
            return ("hi".equals(actualPrefix));
        }
    }
    
    /**
     * Given two temperatures, return true if one is less than 0 and the other is greater than 100.
     *
     * icyHot(120, -1) → true
     * icyHot(-1, 120) → true
     * icyHot(2, 120) → false
     *
     * @param temp1
     * @param temp2
     * @return
     */
    public boolean icyHot(int temp1, int temp2) {
        boolean lessZeroCondition = (temp1 * temp2 < 0);
        boolean greater100Condition = (temp1 > 100 || temp2 > 100);
        return lessZeroCondition && greater100Condition;
    }
    
    /**
     * Given 2 int values, return true if either of them is in the range 10..20 inclusive.
     *
     * in1020(12, 99) → true
     * in1020(21, 12) → true
     * in1020(8, 99) → false
     *
     * @param a
     * @param b
     * @return
     */
    public boolean in1020(int a, int b) {
        boolean firstInRange = (a >= 10 && a <= 20);
        boolean secondInRange = (b >= 10 && b <= 20);
        return firstInRange || secondInRange;
    }
    
    /**
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 3 int values, return true if 1 or more of them are teen.
     *
     * hasTeen(13, 20, 10) → true
     * hasTeen(20, 19, 10) → true
     * hasTeen(20, 10, 13) → true
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public boolean hasTeen(int a, int b, int c) {
        boolean aTeen = (a >= 13 && a <= 19);
        boolean bTeen = (b >= 13 && b <= 19);
        boolean cTeen = (c >= 13 && c <= 19);
        return (aTeen || bTeen || cTeen);
    }
    
    /**
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 2 int values, return true if one or the other is teen, but not both.
     *
     * loneTeen(13, 99) → true
     * loneTeen(21, 19) → true
     * loneTeen(13, 13) → false
     *
     * @param a
     * @param b
     * @return
     */
    public boolean loneTeen(int a, int b) {
        boolean aTeen = (a >= 13 && a <= 19);
        boolean bTeen = (b >= 13 && b <= 19);
        return (aTeen || bTeen) && (!aTeen || !bTeen);
    }
    
    /**
     * Given a string, if the string "del" appears starting at index 1, return a string where that "del" has been deleted. Otherwise, return the string unchanged.
     *
     * delDel("adelbc") → "abc"
     * delDel("adelHello") → "aHello"
     * delDel("adedbc") → "adedbc"
     *
     * @param str
     * @return
     */
    public String delDel(String str) {
        if(str.length() < 4) {
            return str;
        }
        else {
            String inclusion = str.substring(1, 4);
            if("del".equals(inclusion)){
                return str.charAt(0) + str.substring(4);
            }
            else {
                return str;
            }
        }
    }
    
    /**
     * Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.
     *
     * mixStart("mix snacks") → true
     * mixStart("pix snacks") → true
     * mixStart("piz snacks") → false
     *
     * @param str
     * @return
     */
    public boolean mixStart(String str) {
        if(str.length() < 3){
            return false;
        }
        else {
            String inclusion = str.substring(1, 3);
            return("ix".equals(inclusion));
        }
    }
    
    /**
     * Given a string, return a string made of the first 2 chars (if present), however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".
     *
     * startOz("ozymandias") → "oz"
     * startOz("bzoo") → "z"
     * startOz("oxx") → "o"
     *
     * @param str
     * @return
     */
    public String startOz(String str) {
        if(str.isEmpty()){
            return str;
        }
        else if(str.length() == 1){
            if(str.charAt(0) == 'o' || str.charAt(0) == 'z'){
                return "" +str.charAt(0);
            }
            else{
                return "";
            }
        }
        else {
            char firstChar = str.charAt(0);
            char secondChar = str.charAt(1);
            String returnString = "";
            if(firstChar == 'o'){
                returnString = returnString + firstChar;
            }
            if(secondChar == 'z'){
                returnString = returnString + secondChar;
            }
            return returnString;
        }
    }
    
    /**
     * Given three int values, a b c, return the largest.
     *
     * intMax(1, 2, 3) → 3
     * intMax(1, 3, 2) → 3
     * intMax(3, 2, 1) → 3
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int intMax(int a, int b, int c) {
        int largest = a;
        if(largest < b){
            largest = b;
        }
        if(largest < c){
            largest = c;
        }
        return largest;
    }
    
    /**
     * Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie. Note that Math.abs(n) returns the absolute value of a number.
     *
     * close10(8, 13) → 8
     * close10(13, 8) → 8
     * close10(13, 7) → 0
     *
     * @param a
     * @param b
     * @return
     */
    public int close10(int a, int b) {
        int aDistance10 = Math.abs(10 - a);
        int bDistance10 = Math.abs(10 - b);
        if(aDistance10 == bDistance10){
            return 0;
        }
        else if (aDistance10 < bDistance10){
            return a;
        }
        else {
            return b;
        }
    }
    
    /**
     * Given 2 int values, return true if they are both in the range 30..40 inclusive, or they are both in the range 40..50 inclusive.
     *
     * in3050(30, 31) → true
     * in3050(30, 41) → false
     * in3050(40, 50) → true
     *
     * @param a
     * @param b
     * @return
     */
    public boolean in3050(int a, int b) {
        boolean aIn3040 = (a >= 30 && a <= 40);
        boolean bIn3040 = (b >= 30 && b <= 40);
        boolean aIn4050 = (a >= 40 && a <= 50);
        boolean bIn4050 = (b >= 40 && b <= 50);
        return (aIn3040 && bIn3040) || (aIn4050 && bIn4050);
    }
    
    /**
     * Given 2 positive int values, return the larger value that is in the range 10..20 inclusive, or return 0 if neither is in that range.
     *
     * max1020(11, 19) → 19
     * max1020(19, 11) → 19
     * max1020(11, 9) → 11
     *
     * @param a
     * @param b
     * @return
     */
    public int max1020(int a, int b) {
        boolean aIn1020 = (a >= 10 && a <= 20);
        boolean bIn1020 = (b >= 10 && b <= 20);
        if(!aIn1020 && !bIn1020){
            return 0;
        }
        else if(aIn1020 && bIn1020) {
            return Math.max(a,b);
        }
        else if(aIn1020){
            return a;
        }
        else {
            return b;
        }
    }
    
    /**
     * Return true if the given string contains between 1 and 3 'e' chars.
     *
     * stringE("Hello") → true
     * stringE("Heelle") → true
     * stringE("Heelele") → false
     *
     * @param str
     * @return
     */
    public boolean stringE(String str) {
        int eCounter = 0;
        if(str.length() < 1){
            return false;
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'e'){
                eCounter++;
            }
        }
        if(eCounter >= 1 && eCounter <= 3){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Given two non-negative int values, return true if they have the same last digit, such as with 27 and 57. Note that the % "mod" operator computes remainders, so 17 % 10 is 7.
     *
     * lastDigit(7, 17) → true
     * lastDigit(6, 17) → false
     * lastDigit(3, 113) → true
     *
     * @param a
     * @param b
     * @return
     */
    public boolean lastDigit(int a, int b) {
        String aStr = Integer.toString(a);
        String bStr = Integer.toString(b);
        char aLastDigit = aStr.charAt(aStr.length() - 1);
        char bLastDigit = bStr.charAt(bStr.length() - 1);
        return aLastDigit == bLastDigit;
    }
    
    /**
     * Given a string, return a new string where the last 3 chars are now in upper case. If the string has less than 3 chars, uppercase whatever is there. Note that str.toUpperCase() returns the uppercase version of a string.
     *
     * endUp("Hello") → "HeLLO"
     * endUp("hi there") → "hi thERE"
     * endUp("hi") → "HI"
     *
     * @param str
     * @return
     */
    public String endUp(String str) {
        if(str.length() < 4) {
            return str.toUpperCase();
        }
        else {
            int strLen = str.length();
            int indexBeginPostfix = strLen - 3;
            String postfix = str.substring(indexBeginPostfix);
            String prefix = str.substring(0, indexBeginPostfix);
            return prefix + postfix.toUpperCase();
        }
    }
    
    /**
     * Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
     *
     * everyNth("Miracle", 2) → "Mrce"
     * everyNth("abcdefg", 2) → "aceg"
     * everyNth("abcdefg", 3) → "adg"
     *
     * @param str
     * @param n
     * @return
     */
    public String everyNth(String str, int n) {
        String returnString = "";
        for(int i = 0; i < str.length(); i = i + n){
            returnString = returnString + str.charAt(i);
        }
        return returnString;
    }
}
