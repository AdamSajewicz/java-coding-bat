package string2;

public class String2 {
    /**
     * Given a string, return a string where for every char in the original, there are two chars.
     *
     * doubleChar("The") → "TThhee"
     * doubleChar("AAbb") → "AAAAbbbb"
     * doubleChar("Hi-There") → "HHii--TThheerree"
     *
     * @param str
     * @return
     */
    public String doubleChar(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    
    /**
     * Return the number of times that the string "hi" appears anywhere in the given string.
     *
     * countHi("abc hi ho") → 1
     * countHi("ABChi hi") → 2
     * countHi("hihi") → 2
     *
     * @param str
     * @return
     */
    public int countHi(String str) {
        if(str.length() < 2){
            return 0;
        }
        int counter = 0;
        for(int i = 0; i < str.length() - 1; i++){
            if("hi".equals(str.substring(i, i + 2))){
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * Return true if the string "cat" and "dog" appear the same number of times in the given string.
     *
     * catDog("catdog") → true
     * catDog("catcat") → false
     * catDog("1cat1cadodog") → true
     *
     * @param str
     * @return
     */
    public boolean catDog(String str) {
        int catCounter = 0;
        int dogCounter = 0;
        for(int i = 0; i < str.length() - 2; i++){
            String inspect = str.substring(i, i + 3);
            if("cat".equals(inspect)){
                catCounter++;
            }
            if("dog".equals(inspect)){
                dogCounter++;
            }
        }
        if(catCounter == dogCounter){
            return true;
        }
        return false;
    }
    
    /**
     * Return the number of times that the string "code" appears anywhere in the given string, except we'll accept
     * any letter for the 'd', so "cope" and "cooe" count.
     *
     * countCode("aaacodebbb") → 1
     * countCode("codexxcode") → 2
     * countCode("cozexxcope") → 2
     *
     * @param str
     * @return
     */
    public int countCode(String str) {
        if(str.length() < 4){
            return 0;
        }
        int codeCounter = 0;
        for(int i = 0; i < str.length() - 3; i++){
            String prefix = str.substring(i, i + 2);
            char postfix = str.charAt(i + 3);
            if("co".equals(prefix) && 'e' == postfix){
                codeCounter++;
            }
        }
        return codeCounter;
    }
    
    /**
     * Given two strings, return true if either of the strings appears at the very end of the other string,
     * ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
     * Note: str.toLowerCase() returns the lowercase version of a string.
     *
     * endOther("Hiabc", "abc") → true
     * endOther("AbC", "HiaBc") → true
     * endOther("abc", "abXabc") → true
     *
     * @param a
     * @param b
     * @return
     */
    public boolean endOther(String a, String b) {
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();
        return(aLower.endsWith(bLower) || bLower.endsWith(aLower));
    }
    
    /**
     * Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by
     * a period (.). So "xxyz" counts but "x.xyz" does not.
     *
     * xyzThere("abcxyz") → true
     * xyzThere("abc.xyz") → false
     * xyzThere("xyz.abc") → true
     *
     * @param str
     * @return
     */
    public boolean xyzThere(String str) {
        if(str.length() < 3) {
            return false;
        }
        if(str.startsWith("xyz")){
            return true;
        }
        for(int i = 0; i < str.length() - 2; i++) {
            String fourCharsInspection = str.substring(i, i + 3);
            if(fourCharsInspection.contains("xyz")
                    && (str.charAt(i - 1) != '.')){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
     *
     * bobThere("abcbob") → true
     * bobThere("b9b") → true
     * bobThere("bac") → false
     *
     * @param str
     * @return
     */
    public boolean bobThere(String str) {
        if(str.length() < 3){
            return false;
        }
        for(int i = 0; i < str.length() - 2; i++){
            if(str.charAt(i) == 'b' && str.charAt(i + 2) == 'b'){
                return true;
            }
        }
        return false;
    }
    
    /**
     * We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char
     * somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's.
     * Return true if the given string is xy-balanced.
     *
     * xyBalance("aaxbby") → true
     * xyBalance("aaxbb") → false
     * xyBalance("yaaxbb") → false
     *
     * @param str
     * @return
     */
    public boolean xyBalance(String str) {
        if(!str.contains("x")){
            return true;
        }
        if(str.endsWith("x")){
            return false;
        }
        int indexOfLastX = str.lastIndexOf("x");
        int indexOfLastY = str.indexOf("y", indexOfLastX);
        return (indexOfLastY != -1);
    }
    
    /**
     * Given two strings, a and b, create a bigger string made of the first char of a, the first char of b,
     * the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
     *
     * mixString("abc", "xyz") → "axbycz"
     * mixString("Hi", "There") → "HTihere"
     * mixString("xxxx", "There") → "xTxhxexre"
     *
     * @param a
     * @param b
     * @return
     */
    public String mixString(String a, String b) {
        int lesserLength = Math.min(a.length(), b.length());
        if(lesserLength == 0){
            return a + b;
        }
        String returnString = "";
        for(int i = 0; i < lesserLength; i++){
            returnString = returnString + a.charAt(i) + b.charAt(i);
        }
        if(a.length() != b.length()){
            if(a.length() > b.length()){
                returnString = returnString + a.substring(lesserLength);
            }
            else{
                returnString = returnString + b.substring(lesserLength);
            }
        }
        return returnString;
    }
    
    /**
     * Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
     * You may assume that n is between 0 and the length of the string, inclusive.
     *
     * repeatEnd("Hello", 3) → "llollollo"
     * repeatEnd("Hello", 2) → "lolo"
     * repeatEnd("Hello", 1) → "o"
     *
     * @param str
     * @param n
     * @return
     */
    public String repeatEnd(String str, int n) {
        if(n == 0){
            return "";
        }
        String repeated = str.substring(str.length() - n);
        String returnString = "";
        for(int i = 0; i < n; i++){
            returnString += repeated;
        }
        return returnString;
    }
    
    /**
     * Given a string and an int n, return a string made of the first n characters of the string,
     * followed by the first n-1 characters of the string, and so on. You may assume that n is between 0
     * and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
     *
     * repeatFront("Chocolate", 4) → "ChocChoChC"
     * repeatFront("Chocolate", 3) → "ChoChC"
     * repeatFront("Ice Cream", 2) → "IcI"
     *
     * @param str
     * @param n
     * @return
     */
    public String repeatFront(String str, int n) {
        if(str.length() == 0){
            return "";
        }
        int i = 0;
        int j = n;
        String returnString = "";
        do {
            returnString += str.substring(0, j);
            j--;
            i++;
        } while(i < n);
        return returnString;
    }
    
    /**
     * Given two strings, word and a separator sep, return a big string made of count occurrences of the word,
     * separated by the separator string.
     *
     * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
     * repeatSeparator("This", "And", 2) → "ThisAndThis"
     * repeatSeparator("This", "And", 1) → "This"
     *
     * @param word
     * @param sep
     * @param count
     * @return
     */
    public String repeatSeparator(String word, String sep, int count) {
        if(count == 0){
            return "";
        }
        if(count == 1){
            return word;
        }
        String returnString = "";
        for(int i = 0; i < count - 1; i++){
            returnString = returnString + word + sep;
        }
        return returnString + word;
    }
    
    /**
     * Given a string, consider the prefix string made of the first N chars of the string.
     * Does that prefix string appear somewhere else in the string? Assume that the string is not empty
     * and that N is in the range 1..str.length().
     *
     * prefixAgain("abXYabc", 1) → true
     * prefixAgain("abXYabc", 2) → true
     * prefixAgain("abXYabc", 3) → false
     *
     * @param str
     * @param n
     * @return
     */
    public boolean prefixAgain(String str, int n) {
        String prefix = str.substring(0, n);
        String rest = str.substring(n);
        return (rest.contains(prefix));
    }
    
    /**
     * Given a string, does "xyz" appear in the middle of the string? To define middle,
     * we'll say that the number of chars to the left and right of the "xyz" must differ by at most one.
     * This problem is harder than it looks.
     *
     * xyzMiddle("AAxyzBB") → true
     * xyzMiddle("AxyzBB") → true
     * xyzMiddle("AxyzBBB") → false
     *
     * @param str
     * @return
     */
    public boolean xyzMiddle(String str) {
        if(str.length() < 3) {
            return false;
        }
        if(str.length() < 5 && str.contains("xyz")){
            return true;
        }
        int length = str.length();
        int half = length / 2;
        String middle = "";
        if(length % 2 == 0){ //parzyste
            middle = str.substring(half - 2, half + 2);
        }
        else{
            middle = str.substring(half - 1, half + 2);
        }
        return middle.contains("xyz");
    }
    
    /**
     * A sandwich is two pieces of bread with something in between. Return the string that is between the first
     * and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
     *
     * getSandwich("breadjambread") → "jam"
     * getSandwich("xxbreadjambreadyy") → "jam"
     * getSandwich("xxbreadyy") → ""
     * @param str
     * @return
     */
    public String getSandwich(String str) {
        if(str.length() < 11){
            return "";
        }
        if(!str.contains("bread")){
            return "";
        }
        int indexOfFirstBread = str.indexOf("bread");
        int lastIndexOfBread = str.lastIndexOf("bread");
        if(indexOfFirstBread == lastIndexOfBread){
            return "";
        }
        else{
            return str.substring(indexOfFirstBread + 5, lastIndexOfBread);
        }
        
    }
    
    /**
     * Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.
     *
     * sameStarChar("xy*yzz") → true
     * sameStarChar("xy*zzz") → false
     * sameStarChar("*xa*az") → true
     *
     * @param str
     * @return
     */
    public boolean sameStarChar(String str) {
        if(str.length() < 3){
            return true;
        }
        for(int i = 1; i < str.length() - 1; i++){
            if(str.charAt(i) == '*'){
                if(str.charAt(i - 1) != str.charAt(i + 1)){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Given a string, compute a new string by moving the first char to come after the next two chars,
     * so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd".
     * Ignore any group of fewer than 3 chars at the end.
     *
     * oneTwo("abc") → "bca"
     * oneTwo("tca") → "cat"
     * oneTwo("tcagdo") → "catdog"
     *
     * @param str
     * @return
     */
    public String oneTwo(String str) {
        if(str.length() < 3){
            return "";
        }
        int originalLength = str.length();
        int ignoreGroupLength = originalLength % 3;
        String preparedStr = str;
        if(ignoreGroupLength != 0){
            preparedStr = str.substring(0, originalLength - ignoreGroupLength);
        }
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < preparedStr.length(); i += 3){
            strBuilder.append(preparedStr.substring(i + 1, i + 3));
            strBuilder.append(preparedStr.charAt(i));
        }
        return strBuilder.toString();
    }
    
    /**
     * Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'.
     * Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
     *
     * zipZap("zipXzap") → "zpXzp"
     * zipZap("zopzop") → "zpzp"
     * zipZap("zzzopzop") → "zzzpzp"
     *
     * @param str
     * @return
     */
    public String zipZap(String str) {
        if(str.length() < 3){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do{
            if(str.charAt(i) == 'z' && str.charAt(i + 2) == 'p'){
                sb.append("zp");
                i = i + 3;
            }
            else{
                sb.append(str.charAt(i));
                i = i + 1;
            }
        }while(i < str.length() - 2);
        sb.append(str.substring(i));
        
        return sb.toString();
    }
    
    /**
     * Return a version of the given string, where for every star (*) in the string the star and the chars immediately
     * to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
     *
     * starOut("ab*cd") → "ad"
     * starOut("ab**cd") → "ad"
     * starOut("sm*eilly") → "silly"
     *
     * @param str
     * @return
     */
    public String starOut(String str) {
        if(str.length() == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '*' && notStarNeighbour(str, i)){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    
    private boolean notStarNeighbour(String str, int i){
        if(i < 0 || i > str.length() - 1){
            return false;
        }
        if(str.length() == 1){
            return true;
        }
        if(i == 0){
            return str.charAt(1) != '*';
        }
        else if(i == str.length() - 1){
            return str.charAt(str.length() - 2) != '*';
        }
        else{
            return (str.charAt(i - 1) != '*' && str.charAt(i + 1) != '*');
        }
    }
    
    /**
     * Given a string and a non-empty word string, return a version of the original String where all chars have been replaced
     * by pluses ("+"), except for appearances of the word string which are preserved unchanged.
     *
     * plusOut("12xy34", "xy") → "++xy++"
     * plusOut("12xy34", "1") → "1+++++"
     * plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
     *
     * @param str
     * @param word
     * @return
     */
    public String plusOut(String str, String word) {
        if(str.length() == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do{
            if(str.substring(i).startsWith(word)){
                sb.append(word);
                i = i + word.length();
            }
            else{
                sb.append("+");
                i++;
            }
        }while (i < str.length());
        return sb.toString();
    }
    
    /**
     * Given a string and a non-empty word string, return a string made of each char just before and just after every
     * appearance of the word in the string. Ignore cases where there is no char before or after the word,
     * and a char may be included twice if it is between two words.
     *
     * wordEnds("abcXY123XYijk", "XY") → "c13i"
     * wordEnds("XY123XY", "XY") → "13"
     * wordEnds("XY1XY", "XY") → "11"
     *
     * @param str
     * @param word
     * @return
     */
    public String wordEnds(String str, String word) {
        if(str.length() == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            if(str.substring(i).startsWith(word)){
                //append before char
                appendBeforeChar(sb, str, word, i);
                //move i = i + word.length() to point to the last char of the current word
                i = i + word.length() - 1;
                //append after char
                appendAfterChar(sb, str, word, i);
                
            }
            i++;
        }while(i < str.length());
        return sb.toString();
    }
    
    private void appendBeforeChar(StringBuilder sb, String str, String word, int i){
        //if i == 0
        if(i == 0){
            sb.append("");
            return;
        }
        
        //if if there is no chars between words
        if(str.substring(0, i - 1).lastIndexOf(word) + word.length() == i){
            sb.append("");
            return;
        }
        
        sb.append(str.charAt(i - 1));
        return;
    }
    
    private void appendAfterChar(StringBuilder sb, String str, String word, int i){
        //if i == str.length() - 1
        if(i == str.length() - 1){
            sb.append("");
            return;
        }
        
        //if no chars between the next appearance of word
        if(str.substring(i + 1).indexOf(word) == i + 1){
            sb.append("");
            return;
        }
        
        sb.append(str.charAt(i + 1));
        return;
    }
}
