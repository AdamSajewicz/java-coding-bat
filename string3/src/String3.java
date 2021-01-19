package string3.src;

public class String3 {
    
    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word
     * if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char
     * is an alphabetic letter.)
     *
     * countYZ("fez day") → 2
     * countYZ("day fez") → 2
     * countYZ("day fyyyz") → 2
     *
     * @param str
     * @return
     */
    public int countYZ(String str) {
        if(str.length() == 0) {
            return 0;
        }
        int counter = 0;
        int i = 0;
        int j = 0;
        do{
            StringBuilder word = new StringBuilder();
            do{
                
                if(Character.isLetter(str.charAt(i))){
                    word.append(str.charAt(i));
                }
                i++;
            }while(Character.isLetter(str.charAt(i - 1)) && i < str.length());
            if(word.toString().endsWith("y") || word.toString().endsWith("z")
                    || word.toString().endsWith("Y") || word.toString().endsWith("Z")){
                counter++;
            }
            j = i;
        }while(j < str.length());
        
        return counter;
    }
    
    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string
     * have been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * withoutString("Hello there", "llo") → "He there"
     * withoutString("Hello there", "e") → "Hllo thr"
     * withoutString("Hello there", "x") → "Hello there"
     *
     * @param base
     * @param remove
     * @return
     */
    public String withoutString(String base, String remove) {
        if(base.length() == 0){
            return base;
        }
        StringBuilder sb = new StringBuilder(base);
        int indexOfRemove = pozycjaOf(sb.toString(), remove);
        do{
            
            
            if(indexOfRemove != -1){
                sb.delete(indexOfRemove, indexOfRemove + remove.length());
            }
            indexOfRemove = pozycjaOf(sb.toString(), remove);
        }while(indexOfRemove != -1);
        return sb.toString();
    }
    
    private int pozycjaOf(String base, String remove){
        String baseLow = base.toLowerCase();
        String removeLow = remove.toLowerCase();
        for(int i = 0; i < base.length(); i++){
            String probe = baseLow.substring(i);
            if(probe.startsWith(removeLow)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of
     * appearances of "not" anywhere in the string (case sensitive).
     *
     * equalIsNot("This is not") → false
     * equalIsNot("This is notnot") → true
     * equalIsNot("noisxxnotyynotxisi") → true
     *
     * @param str
     * @return
     */
    public boolean equalIsNot(String str) {
        if(str.length() == 0){
            return true;
        }
        if(str.length() < 5){
            return false;
        }
        
        int isCounter = 0;
        for(int i = 0; i < str.length() - 1; i++){
            if(str.substring(i).startsWith("is")){
                isCounter++;
            }
        }
        int notCounter = 0;
        for(int i = 0; i < str.length() - 2; i++){
            if(str.substring(i).startsWith("not")){
                notCounter++;
            }
        }
        return isCounter == notCounter;
    }
    
    public boolean gHappy(String str) {
        if(str.length() == 0){
            return true;
        }
        if(str.length() < 2){
            return false;
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'g'){
                if(gIsSadAtIndex(str, i)){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     *
     * gHappy("xxggxx") → true
     * gHappy("xxgxx") → false
     * gHappy("xxggyygxx") → false
     *
     * @param str
     * @param i
     * @return
     */
    private boolean gIsSadAtIndex(String str, int i){
        if(i == 0){
            return (str.charAt(i + 1) != 'g');
        }
        else if(i == str.length() - 1){
            return (str.charAt(i - 1) != 'g');
        }
        else {
            return (str.charAt(i + 1) != 'g' && str.charAt(i - 1) != 'g');
        }
    }
    
    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     *
     * countTriple("abcXXXabc") → 1
     * countTriple("xxxabyyyycd") → 3
     * countTriple("a") → 0
     *
     * @param str
     * @return
     */
    public int countTriple(String str) {
        if(str.length() < 3){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < str.length() - 2; i++){
            String probe3 = str.substring(i, i + 3);
            char c = probe3.charAt(0);
            if(probe3.charAt(1) == c && probe3.charAt(2) == c){
                count++;
            }
        }
        return count;
    }
    
    /**
     * Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters.
     * Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char
     * is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
     *
     * sumDigits("aa1bc2d3") → 6
     * sumDigits("aa11b33") → 8
     * sumDigits("Chocolate") → 0
     *
     * @param str
     * @return
     */
    public int sumDigits(String str) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                sb.append(str.charAt(i));
            }
        }
        if(sb.length() == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < sb.length(); i++){
            result += Integer.parseInt("" + sb.charAt(i));
        }
        return result;
    }
    
    /**
     * Given a string, return the longest substring that appears at both the beginning and end of the string
     * without overlapping. For example, sameEnds("abXab") is "ab".
     *
     * sameEnds("abXYab") → "ab"
     * sameEnds("xx") → "x"
     * sameEnds("xxx") → "x"
     *
     * @param string
     * @return
     */
    public String sameEnds(String string) {
        if(string.length() < 2){
            return "";
        }
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        int halfIndex = string.length()/2;
        first.append(string.substring(0, halfIndex));
        if(string.length() % 2 == 0){
            second.append(string.substring(halfIndex));
        }
        else{
            second.append(string.substring(halfIndex + 1));
        }
        int max = first.length();
        do{
            String checkFirst = first.toString();
            String checkSecond = second.toString();
            if(checkFirst.equals(checkSecond)){
                return checkFirst;
            }
            first.delete(first.length() - 1, first.length());
            second.delete(0, 1);
        }while(first.length() > 0);
        return "";
    }
    
    /**
     * Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string.
     * In other words, zero or more characters at the very begining of the given string, and at the very end
     * of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
     *
     * mirrorEnds("abXYZba") → "ab"
     * mirrorEnds("abca") → "a"
     * mirrorEnds("aba") → "aba"
     *
     * @param string
     * @return
     */
    public String mirrorEnds(String string) {
        if(string.length() == 0){
            return "";
        }
        if(string.length() == 1){
            return string;
        }
        StringBuilder sb = new StringBuilder(string);
        String reversed = sb.reverse().toString();
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) != reversed.charAt(i)){
                return string.substring(0, i);
            }
        }
        return string;
    }
    
    /**
     * Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
     *
     * maxBlock("hoopla") → 2
     * maxBlock("abbCCCddBBBxx") → 3
     * maxBlock("") → 0
     *
     * @param str
     * @return
     */
    public int maxBlock(String str) {
        if(str.length() == 0){
            return 0;
        }
        if(str.length() == 1){
            return 1;
        }
        int max = 1;
        for(int i = 0; i < str.length() - 1; i++){
            char c = str.charAt(i);
            int pretender = 1;
            int j = i + 1;
            boolean finito = false;
            do{
                if(str.charAt(j) == c){
                    if(j - i + 1 > pretender){
                        pretender++;
                    }
                }
                else{
                    finito = true;
                }
                j++;
            }while(!finito && j < str.length());
            if(max < pretender){
                max = pretender;
            }
        }
        return max;
    }
    
    /**
     * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
     * A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char
     * is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
     *
     * sumNumbers("abc123xyz") → 123
     * sumNumbers("aa11b33") → 44
     * sumNumbers("7 11") → 18
     *
     * @param str
     * @return
     */
    public int sumNumbers(String str) {
        if(str.length() == 0){
            return 0;
        }
        int counter = 0;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                int j = findLastIndexOfDigit(str, i);
                counter += Integer.parseInt(str.substring(i, j + 1));
                i = j;
            }
        }
        return counter;
    }
    
    private int findLastIndexOfDigit(String str, int i){
        if(i == str.length() - 1){
            return i;
        }
        int k = i;
        while((k + 1 < str.length())  && Character.isDigit(str.charAt(k + 1))){
            k++;
        }
        return k;
    }
    
    /**
     * Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not".
     * The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count.
     * (Note: Character.isLetter(char) tests if a char is a letter.)
     *
     * notReplace("is test") → "is not test"
     * notReplace("is-is") → "is not-is not"
     * notReplace("This is right") → "This is not right"
     *
     * @param str
     * @return
     */
    public String notReplace(String str) {
        if(str.length() < 2){
            return str;
        }
        if(str.length() == 2 && "is".equals(str)){
            return str + " not";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            String probe = str.substring(i);
            if(probe.startsWith("is")){
                if(okAtTheBeginning(str, i) && okAtTheEnd(str, i)){
                    sb.append(probe.substring(0, 2) + " not");
                    //i = i + 1;
                }
                else{
                    sb.append(probe.substring(0, 2));
                }
                i = i + 1;
            }
            else{
                sb.append(probe.charAt(0));
            }
        }
        return sb.toString();
    }
    
    private boolean okAtTheBeginning(String str, int i){
        // i == 0
        if(i == 0){
            return true;
        }
        else{
            return !Character.isLetter(str.charAt(i - 1));
        }
        // i > 0
    }
    
    private boolean okAtTheEnd(String str, int i){
        // i == str.length() - 2;
        if(i == str.length() - 2){
            return true;
        }
        else{
            return !Character.isLetter(str.charAt(i + 2));
        }
        // i < str.length() - 2;
    }
}
