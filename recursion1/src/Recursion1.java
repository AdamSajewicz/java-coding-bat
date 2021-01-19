package recursion1.src;

public class Recursion1 {
    
    /**
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
     * Compute the result recursively (without loops).
     *
     * factorial(1) → 1
     * factorial(2) → 2
     * factorial(3) → 6
     *
     * @param n
     * @return
     */
    public int factorial(int n) {
        if(n > 1){
            return n * factorial(n - 1);
        }
        else {
            return 1;
        }
    }
    
    /**
     * We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of
     * ears across all the bunnies recursively (without loops or multiplication).
     *
     * bunnyEars(0) → 0
     * bunnyEars(1) → 2
     * bunnyEars(2) → 4
     *
     * @param bunnies
     * @return
     */
    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        else {
            return 2 + bunnyEars(bunnies - 1);
        }
    }
    
    /**
     * The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
     * The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of
     * the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
     * Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
     *
     * fibonacci(0) → 0
     * fibonacci(1) → 1
     * fibonacci(2) → 1
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    /**
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
     * The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
     * Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     *
     * bunnyEars2(0) → 0
     * bunnyEars2(1) → 2
     * bunnyEars2(2) → 5
     *
     * @param bunnies
     * @return
     */
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        if(bunnies % 2 == 0){
            return bunnyEars2(bunnies - 1) + 3;
        }
        else {
            return bunnyEars2(bunnies - 1) + 2;
        }
    }
    
    /**
     * We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks,
     * the next row has 3 blocks, and so on.
     * Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
     *
     * triangle(0) → 0
     * triangle(1) → 1
     * triangle(2) → 3
     *
     * @param rows
     * @return
     */
    public int triangle(int rows) {
        if(rows == 0){
            return 0;
        }
        return triangle(rows - 1) + rows;
    }
    
    /**
     * Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10
     * yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     *
     * sumDigits(126) → 9
     * sumDigits(49) → 13
     * sumDigits(12) → 3
     * @param n
     * @return
     */
    public int sumDigits(int n) {
        if(n < 10){
            return n;
        }
        return sumDigits(n / 10) + n % 10;
    }
    
    /**
     * Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops).
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     *
     * count7(717) → 2
     * count7(7) → 1
     * count7(123) → 0
     *
     * @param n
     * @return
     */
    public int count7(int n) {
        if(n == 7){
            return 1;
        }
        if(n < 10 && n != 7){
            return 0;
        }
        int remainder = n%10;
        if(remainder == 7){
            return count7(n/10) + 1;
        }
        else {
            return count7(n/10);
        }
    }
    
    /**
     * Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
     * except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     *
     * count8(8) → 1
     * count8(818) → 2
     * count8(8818) → 4
     *
     * @param n
     * @return
     */
    public int count8(int n) {
        if(n == 8){
            return 1;
        }
        if(n < 10 && n != 8){
            return 0;
        }
        if((n/10)%10 == 8 && n%10 == 8){
            return count8(n/10) + count8(n%10) + 1;
        }
        return count8(n/10) + count8(n%10);
    }
    
    /**
     * Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
     *
     * powerN(3, 1) → 3
     * powerN(3, 2) → 9
     * powerN(3, 3) → 27
     * @param base
     * @param n
     * @return
     */
    public int powerN(int base, int n) {
        if(n == 1){
            return base;
        }
        return powerN(base, n - 1) * base;
    }
    
    /**
     * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
     *
     * countX("xxhixx") → 4
     * countX("xhixhix") → 3
     * countX("hi") → 0
     *
     * @param str
     * @return
     */
    public int countX(String str) {
        if(str.length() == 0){
            return 0;
        }
        if(str.length() == 1){
            if(str.charAt(0) == 'x'){
                return 1;
            }
            else {
                return 0;
            }
        }
        return countX("" + str.charAt(0)) + countX(str.substring(1));
    }
    
    /**
     * Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
     *
     * countHi("xxhixx") → 1
     * countHi("xhixhix") → 2
     * countHi("hi") → 1
     *
     * @param str
     * @return
     */
    public int countHi(String str) {
        if(str.length() < 2){
            return 0;
        }
        if(str.startsWith("hi")){
            return 1 + countHi(str.substring(2));
        }
        else{
            return countHi(str.substring(1));
        }
    }
    
    /**
     * Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
     *
     * changeXY("codex") → "codey"
     * changeXY("xxhixx") → "yyhiyy"
     * changeXY("xhixhix") → "yhiyhiy"
     *
     * @param str
     * @return
     */
    public String changeXY(String str) {
        if(!str.contains("x")){
            return str;
        }
        if(str.charAt(0) == 'x'){
            return "y" + changeXY(str.substring(1));
        }
        else {
            return "" + str.charAt(0) + changeXY(str.substring(1));
        }
    }
    
    /**
     * Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
     *
     * changePi("xpix") → "x3.14x"
     * changePi("pipi") → "3.143.14"
     * changePi("pip") → "3.14p"
     *
     * @param str
     * @return
     */
    public String changePi(String str) {
        if(!str.contains("pi")){
            return str;
        }
        if(str.startsWith("pi")){
            return "3.14" + changePi(str.substring(2));
        }
        else {
            return str.charAt(0) + changePi(str.substring(1));
        }
    }
    
    /**
     * Given a string, compute recursively a new string where all the 'x' chars have been removed.
     *
     * noX("xaxb") → "ab"
     * noX("abc") → "abc"
     * noX("xx") → ""
     *
     * @param str
     * @return
     */
    public String noX(String str) {
        if(!str.contains("x")){
            return str;
        }
        if(str.charAt(0) == 'x'){
            return "" + noX(str.substring(1));
        }
        else {
            return "" + str.charAt(0) + noX(str.substring(1));
        }
    }
    
    /**
     * Given an array of ints, compute recursively if the array contains a 6.
     * We'll use the convention of considering only the part of the array that begins at the given index.
     * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     *
     * array6([1, 6, 4], 0) → true
     * array6([1, 4], 0) → false
     * array6([6], 0) → true
     *
     * @param nums
     * @param index
     * @return
     */
    public boolean array6(int[] nums, int index) {
        if(nums.length == 0){
            return false;
        }
        if(index == nums.length - 1){
            return nums[index] == 6;
        }
        return nums[index] == 6 || array6(nums, index + 1);
    }
    
    /**
     * Given an array of ints, compute recursively the number of times that the value 11 appears in the array.
     * We'll use the convention of considering only the part of the array that begins at the given index.
     * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     *
     * array11([1, 2, 11], 0) → 1
     * array11([11, 11], 0) → 2
     * array11([1, 2, 3, 4], 0) → 0
     *
     * @param nums
     * @param index
     * @return
     */
    public int array11(int[] nums, int index) {
        if(nums.length == 0){
            return 0;
        }
        if(index == nums.length - 1){
            return (nums[index] == 11)? 1 : 0;
        }
        return (nums[index] == 11)? (1 + array11(nums, index + 1)):array11(nums, index + 1);
    }
    
    /**
     * Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10.
     * We'll use the convention of considering only the part of the array that begins at the given index.
     * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     *
     * array220([1, 2, 20], 0) → true
     * array220([3, 30], 0) → true
     * array220([3], 0) → false
     *
     * @param nums
     * @param index
     * @return
     */
    public boolean array220(int[] nums, int index) {
        if(nums.length < 2){
            return false;
        }
        if(index == nums.length - 2){
            return nums[nums.length - 1] == nums[nums.length - 2] * 10;
        }
        return array220(nums, index + 1) || nums[index + 1] == nums[index] * 10;
    }
    
    /**
     * Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
     *
     * allStar("hello") → "h*e*l*l*o"
     * allStar("abc") → "a*b*c"
     * allStar("ab") → "a*b"
     *
     * @param str
     * @return
     */
    public String allStar(String str) {
        if(str.length() < 2){
            return str;
        }
        if(str.length() == 2){
            return str.charAt(0) + "*" + str.charAt(1);
        }
        return str.charAt(0) + "*" + allStar(str.substring(1));
    }
    
    /**
     * Given a string, compute recursively a new string where identical chars that are adjacent in the original string
     * are separated from each other by a "*".
     *
     * pairStar("hello") → "hel*lo"
     * pairStar("xxyy") → "x*xy*y"
     * pairStar("aaaa") → "a*a*a*a"
     *
     * @param str
     * @return
     */
    public String pairStar(String str) {
        if(str.length() < 2){
            return str;
        }
        if(str.length() == 2){
            if(str.charAt(0) == str.charAt(1)){
                return str.charAt(0) + "*" + str.charAt(1);
            }
            else{
                return str;
            }
        }
        if(str.charAt(0) == str.charAt(1)){
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        }
        return str.charAt(0) + pairStar(str.substring(1));
    }
    
    /**
     * Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
     *
     * endX("xxre") → "rexx"
     * endX("xxhixx") → "hixxxx"
     * endX("xhixhix") → "hihixxx"
     *
     * @param str
     * @return
     */
    public String endX(String str) {
        if(str.length() < 2){
            return str;
        }
        if(str.length() == 1){
            return str;
        }
        if(str.charAt(0) == 'x'){
            return endX(str.substring(1)) + "x";
        }
        return str.charAt(0) + endX(str.substring(1));
    }
    
    /**
     * We'll say that a "pair" in a string is two instances of a char separated by a char.
     * So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x.
     * Recursively compute the number of pairs in the given string.
     *
     * countPairs("axa") → 1
     * countPairs("axax") → 2
     * countPairs("axbx") → 1
     *
     * @param str
     * @return
     */
    public int countPairs(String str) {
        if(str.length() < 3){
            return 0;
        }
        if(str.length() == 3){
            if(str.charAt(0) == str.charAt(2)){
                return 1;
            }
            else {
                return 0;
            }
        }
        if(str.charAt(0) == str.charAt(2)){
            return 1 + countPairs(str.substring(1));
        }
        else {
            return countPairs(str.substring(1));
        }
    }
    
    /**
     * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
     *
     * countAbc("abc") → 1
     * countAbc("abcxxabc") → 2
     * countAbc("abaxxaba") → 2
     *
     * @param str
     * @return
     */
    public int countAbc(String str) {
        if(str.length() < 3){
            return 0;
        }
        if(str.length() == 3){
            if(str.equals("aba") || (str.equals("abc"))){
                return 1;
            }
            return 0;
        }
        if(str.startsWith("aba") || (str.startsWith("abc"))){
            return 1 + countAbc(str.substring(1));
        }
        else {
            return countAbc(str.substring(1));
        }
    }
    
    /**
     * Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
     *
     * count11("11abc11") → 2
     * count11("abc11x11x11") → 3
     * count11("111") → 1
     *
     * @param str
     * @return
     */
    public int count11(String str) {
        if(str.length() < 2){
            return 0;
        }
        if(str.length() == 2){
            if(str.equals("11")){
                return 1;
            }
            else return 0;
        }
        if(str.startsWith("11")){
            return 1 + count11(str.substring(2));
        }
        else {
            return count11(str.substring(1));
        }
    }
    
    /**
     * Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced
     * to a single char. So "yyzzza" yields "yza".
     *
     * stringClean("yyzzza") → "yza"
     * stringClean("abbbcdd") → "abcd"
     * stringClean("Hello") → "Helo"
     *
     * @param str
     * @return
     */
    public String stringClean(String str) {
        if(str.length() < 2){
            return str;
        }
        if(str.length() == 2){
            if(str.charAt(0) == str.charAt(1)){
                return "" + str.charAt(0);
            }
            else {
                return str;
            }
        }
        if(str.charAt(0) == str.charAt(1)){
            return stringClean(str.substring(1));
        }
        else {
            return str.charAt(0) + stringClean(str.substring(1));
        }
    }
    
    /**
     * Given a string, compute recursively the number of times lowercase "hi" appears in the string,
     * however do not count "hi" that have an 'x' immedately before them.
     *
     * countHi2("ahixhi") → 1
     * countHi2("ahibhi") → 2
     * countHi2("xhixhi") → 0
     *
     * @param str
     * @return
     */
    public int countHi2(String str) {
        if(str.length() < 2){
            return 0;
        }
        if(str.equals("hi")){
            return 1;
        }
        if(str.equals("xhi")){
            return 0;
        }
        if(str.startsWith("hi")){
            return 1 + countHi2(str.substring(2));
        }
        if(str.startsWith("xhi")){
            return countHi2(str.substring(3));
        }
        return countHi2(str.substring(1));
    }
    
    /**
     * Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis
     * and their contents, so "xyz(abc)123" yields "(abc)".
     *
     * parenBit("xyz(abc)123") → "(abc)"
     * parenBit("x(hello)") → "(hello)"
     * parenBit("(xy)1") → "(xy)"
     *
     * @param str
     * @return
     */
    public String parenBit(String str) {
        if(str.length() < 2){
            return "";
        }
        if(str.charAt(0) != '('){
            return parenBit(str.substring(1));
        }
        else {
            int closingParenIndex = str.indexOf(')');
            return str.substring(0, closingParenIndex + 1) + parenBit(str.substring(closingParenIndex + 1));
        }
    }
    
    /**
     * Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))".
     * Suggestion: check the first and last chars, and then recur on what's inside them.
     *
     * nestParen("(())") → true
     * nestParen("((()))") → true
     * nestParen("(((x))") → false
     *
     * @param str
     * @return
     */
    public boolean nestParen(String str) {
        if(str.length() == 0){
            return true;
        }
        if(str.length() == 1){
            return false;
        }
        if(str.charAt(0) != '(' || str.charAt(str.length() - 1) != ')'){
            return false;
        }
        else {
            return (str.charAt(0) == '(' &&
                    str.charAt(str.length() - 1) == ')' &&
                    nestParen(str.substring(1, str.length() - 1)));
        }
        //}
    }
    
    /**
     * Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string,
     * without the sub strings overlapping.
     *
     * strCount("catcowcat", "cat") → 2
     * strCount("catcowcat", "cow") → 1
     * strCount("catcowcat", "dog") → 0
     *
     * @param str
     * @param sub
     * @return
     */
    public int strCount(String str, String sub) {
        if(str.length() < sub.length()){
            return 0;
        }
        if(str.equals(sub)){
            return 1;
        }
        if(str.startsWith(sub)){
            return 1 + strCount(str.substring(sub.length()), sub);
        }
        else {
            return strCount(str.substring(1), sub);
        }
    }
    
    /**
     * Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear
     * in the string somewhere, possibly with overlapping. N will be non-negative.
     *
     * strCopies("catcowcat", "cat", 2) → true
     * strCopies("catcowcat", "cow", 2) → false
     * strCopies("catcowcat", "cow", 1) → true
     *
     * @param str
     * @param sub
     * @param n
     * @return
     */
    public boolean strCopies(String str, String sub, int n) {
        if(str.length() < sub.length()){
            if(n != 0){
                return false;
            }
            else {
                return true;
            }
        }
        if(n == 0){
            return true;
        }
        if(str.startsWith(sub)) {
            return strCopies(str.substring(1), sub, n - 1);
        }
        else {
            return strCopies(str.substring(1), sub, n);
        }
    }
    
    /**
     * Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends
     * with sub and return its length.
     *
     * strDist("catcowcat", "cat") → 9
     * strDist("catcowcat", "cow") → 3
     * strDist("cccatcowcatxx", "cat") → 9
     *
     * @param str
     * @param sub
     * @return
     */
    public int strDist(String str, String sub) {
        if(str.length() < sub.length()){
            return 0;
        }
        if(str.equals(sub)){
            return sub.length();
        }
        if(str.startsWith(sub) && str.endsWith(sub)){
            return str.length();
        }
        if(!str.startsWith(sub)){
            return strDist(str.substring(1), sub);
        }
        else {
            return strDist(str.substring(0, str.length() - 1), sub);
        }
    }
    
}
