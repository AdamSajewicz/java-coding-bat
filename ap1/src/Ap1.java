package ap1.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ap1 {
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 4};
        Boolean result = scoresIncreasing(nums);
        System.out.println("Result: " + result);
    }
    
    /**
     * Given an array of scores, return true if each score is equal or greater than the one before.
     * The array will be length 2 or more.
     *
     * scoresIncreasing([1, 3, 4]) → true
     * scoresIncreasing([1, 3, 2]) → false
     * scoresIncreasing([1, 1, 4]) → true
     *
     * @param scores
     * @return
     */
    public static boolean scoresIncreasing(int[] scores) {
        boolean increase = false;
        int i = 0;
        do{
            increase = scores[i + 1] >= scores[i];
            i++;
        } while(i < scores.length - 1 && increase);
        if(increase){
            return scores[i] >= scores[i -1];
        }
        return increase;
    }
    
    /**
     * Given an array of scores, return true if there are scores of 100 next to each other in the array.
     * The array length will be at least 2.
     *
     * scores100([1, 100, 100]) → true
     * scores100([1, 100, 99, 100]) → false
     * scores100([100, 1, 100, 100]) → true
     *
     * @param scores
     * @return
     */
    public boolean scores100(int[] scores) {
        boolean foundScores100 = false;
        int i = 0;
        do{
            if(scores[i] == 100 && scores[i + 1] == 100){
                foundScores100 = true;
            }
            i++;
        } while(!foundScores100 && i < scores.length - 1);
        return foundScores100;
    }
    
    /**
     * Given an array of scores sorted in increasing order, return true if the array contains 3 adjacent scores
     * that differ from each other by at most 2, such as with {3, 4, 5} or {3, 5, 5}.
     *
     * scoresClump([3, 4, 5]) → true
     * scoresClump([3, 4, 6]) → false
     * scoresClump([1, 3, 5, 5]) → true
     *
     * @param scores
     * @return
     */
    public boolean scoresClump(int[] scores) {
        if(scores.length < 3){
            return false;
        }
        boolean isClump = false;
        int i = 0;
        do{
            if(scores[i + 2] - scores[i] <= 2){
                isClump = true;
            }
            i++;
        } while(i < scores.length - 2 && !isClump);
        return isClump;
    }
    
    /**
     * Given an array of scores, compute the int average of the first half and the second half,
     * and return whichever is larger. We'll say that the second half begins at index length/2.
     * The array length will be at least 2. To practice decomposition, write a separate helper method
     * int average(int[] scores, int start, int end) { which computes the average of the elements
     * between indexes start..end. Call your helper method twice to implement scoresAverage().
     * Write your helper method after your scoresAverage() method in the JavaBat text area.
     * Normally you would compute averages with doubles, but here we use ints so the expected results are exact.
     *
     * scoresAverage([2, 2, 4, 4]) → 4
     * scoresAverage([4, 4, 4, 2, 2, 2]) → 4
     * scoresAverage([3, 4, 5, 1, 2, 3]) → 4
     *
     * @param scores
     * @return
     */
    public int scoresAverage(int[] scores) {
        return Math.max(average(scores, 0, (scores.length / 2) - 1), average(scores, (scores.length / 2), scores.length - 1));
    }
    
    private int average(int[] scores, int startIndex, int endIndex){
        int sum = 0;
        int counter = 0;
        for(int i = startIndex; i <= endIndex; i++){
            sum += scores[i];
            counter++;
        }
        return sum / counter;
    }
    
    /**
     * Given an array of strings, return the count of the number of strings with the given length.
     *
     * wordsCount(["a", "bb", "b", "ccc"], 1) → 2
     * wordsCount(["a", "bb", "b", "ccc"], 3) → 1
     * wordsCount(["a", "bb", "b", "ccc"], 4) → 0
     *
     * @param words
     * @param len
     * @return
     */
    public int wordsCount(String[] words, int len) {
        if(words.length == 0){
            return 0;
        }
        int[] lengthWector = new int[words.length];
        for(int i = 0; i < words.length; i++){
            lengthWector[i] = words[i].length();
        }
        int counter = 0;
        for(int i = 0; i < words.length; i++){
            if(lengthWector[i] == len){
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * Given an array of strings, return a new array containing the first N strings. N will be in the range 1..length.
     *
     * wordsFront(["a", "b", "c", "d"], 1) → ["a"]
     * wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
     * wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
     *
     * @param words
     * @param n
     * @return
     */
    public String[] wordsFront(String[] words, int n) {
        if(words.length == 1 && n == 1){
            return words;
        }
        String[] newWords = new String[n];
        for(int i = 0; i < n; i++){
            newWords[i] = words[i];
        }
        return newWords;
    }
    
    /**
     * Given an array of strings, return a new List (e.g. an ArrayList) where all the strings of the given length
     * are omitted. See wordsWithout() below which is more difficult because it uses arrays.
     *
     * wordsWithoutList(["a", "bb", "b", "ccc"], 1) → ["bb", "ccc"]
     * wordsWithoutList(["a", "bb", "b", "ccc"], 3) → ["a", "bb", "b"]
     * wordsWithoutList(["a", "bb", "b", "ccc"], 4) → ["a", "bb", "b", "ccc"]
     *
     * @param words
     * @param len
     * @return
     */
    public List wordsWithoutList(String[] words, int len) {
        List<String> returnList = new ArrayList<>();
        if(words.length == 0){
            return returnList;
        }
        for(int i = 0; i < words.length; i++){
            if(words[i].length() != len){
                returnList.add(words[i]);
            }
        }
        return returnList;
    }
    
    /**
     * Given a positive int n, return true if it contains a 1 digit. Note: use % to get the rightmost digit,
     * and / to discard the rightmost digit.
     *
     * hasOne(10) → true
     * hasOne(22) → false
     * hasOne(220) → false
     *
     * @param n
     * @return
     */
    public boolean hasOne(int n) {
        if(n == 1){
            return true;
        }
        boolean has1 = false;
        int nn = n;
        int remainder = 0;
        do{
            remainder = nn%10;
            nn = nn / 10;
            if(remainder == 1 || nn == 1){
                has1 = true;
            }
        } while(!has1 && nn > 10);
        return has1;
    }
    
    /**
     * We'll say that a positive int divides itself if every digit in the number divides into the number evenly.
     * So for example 128 divides itself since 1, 2, and 8 all divide into 128 evenly.
     * We'll say that 0 does not divide into anything evenly, so no number with a 0 digit divides itself.
     * Note: use % to get the rightmost digit, and / to discard the rightmost digit.
     *
     * dividesSelf(128) → true
     * dividesSelf(12) → true
     * dividesSelf(120) → false
     *
     * @param n
     * @return
     */
    public boolean dividesSelf(int n) {
        if(n == 0 || n % 10 == 0){
            return false;
        }
        if(n < 10){
            return true;
        }
        boolean digitPass = true;
        int nn = n;
        int remainder = 0;
        do{
            remainder = nn % 10;
            nn = nn / 10;
            digitPass = checkDigit(n, remainder);
        } while(nn > 10 && digitPass);
        return digitPass && (n % nn == 0);
    }
    
    private boolean checkDigit(int n, int remainder){
        if(remainder == 0){
            return false;
        }
        return n % remainder == 0;
    }
    
    /**
     * Given an array of positive ints, return a new array of length "count" containing the first even numbers
     * from the original array. The original array will contain at least "count" even numbers.
     *
     * copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
     * copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
     * copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
     *
     * @param nums
     * @param count
     * @return
     */
    public int[] copyEvens(int[] nums, int count) {
        int[] newNums = new int[nums.length];
        if(count == 0){
            return newNums;
        }
        Arrays.fill(newNums, -1);
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                newNums[j] = nums[i];
                j++;
            }
        }
        int[] copied = new int[count];
        copied = Arrays.copyOfRange(newNums, 0, count);
        return copied;
    }
    
    /**
     * We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive).
     * Given an array of positive ints, return a new array of length "count" containing the first endy numbers
     * from the original array. Decompose out a separate isEndy(int n) method to test if a number is endy.
     * The original array will contain at least "count" endy numbers.
     *
     * copyEndy([9, 11, 90, 22, 6], 2) → [9, 90]
     * copyEndy([9, 11, 90, 22, 6], 3) → [9, 90, 6]
     * copyEndy([12, 1, 1, 13, 0, 20], 2) → [1, 1]
     *
     * @param nums
     * @param count
     * @return
     */
    public int[] copyEndy(int[] nums, int count) {
        int[] endies = new int[nums.length];
        if(nums.length == 0){
            return endies;
        }
        Arrays.fill(endies, -1);
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(isEndy(nums[i])){
                endies[j] = nums[i];
                j++;
            }
        }
        j = 0;
        int[] arrayOfEndyNumbers = new int[count];
        arrayOfEndyNumbers = Arrays.copyOfRange(endies, 0, count);
        
        return arrayOfEndyNumbers;
    }
    
    private boolean isEndy(int number){
        if((number >= 0 && number <= 10) || (number >= 90 && number <= 100)){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Given 2 arrays that are the same length containing strings, compare the 1st string in one array to the 1st string
     * in the other array, the 2nd to the 2nd and so on. Count the number of times that the 2 strings are non-empty
     * and start with the same char. The strings may be any length, including 0.
     *
     * matchUp(["aa", "bb", "cc"], ["aaa", "xx", "bb"]) → 1
     * matchUp(["aa", "bb", "cc"], ["aaa", "b", "bb"]) → 2
     * matchUp(["aa", "bb", "cc"], ["", "", "ccc"]) → 1
     *
     * @param a
     * @param b
     * @return
     */
    public int matchUp(String[] a, String[] b) {
        if(a.length == 0){
            return 0;
        }
        int counter = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i].length() != 0 && b[i].length() != 0){
                if(a[i].charAt(0) == b[i].charAt(0)){
                    counter++;
                }
            }
        }
        return counter;
    }
    
    /**
     * The "key" array is an array containing the correct answers to an exam, like {"a", "a", "b", "b"}.
     * the "answers" array contains a student's answers, with "?" representing a question left blank.
     * The two arrays are not empty and are the same length. Return the score for this array of answers,
     * giving +4 for each correct answer, -1 for each incorrect answer, and +0 for each blank answer.
     *
     * scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
     *
     * @param key
     * @param answers
     * @return
     */
    public int scoreUp(String[] key, String[] answers) {
        int score = 0;
        for(int i = 0; i < key.length; i++){
            if(answers[i].equals(key[i])){
                score += 4;
            }
            else if(!"?".equals(answers[i])){
                score -= 1;
            }
        }
        return score;
    }
    
    /**
     * Given an array of strings, return a new array without the strings that are equal to the target string.
     * One approach is to count the occurrences of the target string, make a new array of the correct length,
     * and then copy over the correct strings.
     *
     * wordsWithout(["a", "b", "c", "a"], "a") → ["b", "c"]
     * wordsWithout(["a", "b", "c", "a"], "b") → ["a", "c", "a"]
     * wordsWithout(["a", "b", "c", "a"], "c") → ["a", "b", "a"]
     *
     * @param words
     * @param target
     * @return
     */
    public String[] wordsWithout(String[] words, String target) {
        
        if(words.length == 0){
            return new String[0];
        }
        boolean[] checker = new boolean[words.length];
        Arrays.fill(checker, true);
        int targetCounter = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                checker[i] = false;
                targetCounter++;
            }
        }
        String[] newWords = new String[words.length - targetCounter];
        int j = 0;
        for(int i = 0; i < words.length; i++){
            if(checker[i]){
                newWords[j] = words[i];
                j++;
            }
        }
        return newWords;
    }
    
    /**
     * Given two arrays, A and B, of non-negative int scores. A "special" score is one which is a multiple of 10,
     * such as 40 or 90. Return the sum of largest special score in A and the largest special score in B.
     * To practice decomposition, write a separate helper method which finds the largest special score in an array.
     * Write your helper method after your scoresSpecial() method in the JavaBat text area.
     *
     * scoresSpecial([12, 10, 4], [2, 20, 30]) → 40
     * scoresSpecial([20, 10, 4], [2, 20, 10]) → 40
     * scoresSpecial([12, 11, 4], [2, 20, 31]) → 20
     * @param a
     * @param b
     * @return
     */
    public int scoresSpecial(int[] a, int[] b) {
        return findSpecial(a) + findSpecial(b);
    }
    
    private int findSpecial(int[] scores){
        if(scores.length == 0){
            return 0;
        }
        int maxScore = 0;
        for(int i = 0; i < scores.length; i++){
            if(scores[i]%10 == 0){
                if(scores[i] > maxScore){
                    maxScore = scores[i];
                }
            }
        }
        return maxScore;
    }
    
    /**
     * We have an array of heights, representing the altitude along a walking trail. Given start/end indexes
     * into the array, return the sum of the changes for a walk beginning at the start index and ending at the end index.
     * For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6.
     * The start end end index will both be valid indexes into the array with start <= end.
     *
     * sumHeights([5, 3, 6, 7, 2], 2, 4) → 6
     * sumHeights([5, 3, 6, 7, 2], 0, 1) → 2
     * sumHeights([5, 3, 6, 7, 2], 0, 4) → 11
     *
     * @param heights
     * @param start
     * @param end
     * @return
     */
    public int sumHeights(int[] heights, int start, int end) {
        int[] counterTrack = new int[end - start];
        counterTrack = Arrays.copyOfRange(heights, start, end + 1);
        int counter = 0;
        for(int i = 0; i < counterTrack.length - 1; i++){
            counter += Math.abs(counterTrack[i + 1] - counterTrack[i]);
        }
        return counter;
    }
    
    /**
     * (A variation on the sumHeights problem.) We have an array of heights, representing the altitude along a walking trail.
     * Given start/end indexes into the array, return the sum of the changes for a walk beginning at the start index
     * and ending at the end index, however increases in height count double.
     * For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1*2 + 5 = 7.
     * The start end end index will both be valid indexes into the array with start <= end.
     *
     * sumHeights2([5, 3, 6, 7, 2], 2, 4) → 7
     * sumHeights2([5, 3, 6, 7, 2], 0, 1) → 2
     * sumHeights2([5, 3, 6, 7, 2], 0, 4) → 15
     *
     * @param heights
     * @param start
     * @param end
     * @return
     */
    public int sumHeights2(int[] heights, int start, int end) {
        int[] counterTrack = new int[end - start];
        counterTrack = Arrays.copyOfRange(heights, start, end + 1);
        int counter = 0;
        for(int i = 0; i < counterTrack.length - 1; i++){
            if(counterTrack[i + 1] - counterTrack[i] >= 0){
                counter += 2 * (counterTrack[i + 1] - counterTrack[i]);
            }
            else {
                counter += Math.abs(counterTrack[i + 1] - counterTrack[i]);
            }
        }
        return counter;
    }
    
    /**
     * (A variation on the sumHeights problem.) We have an array of heights, representing the altitude along a walking trail.
     * Given start/end indexes into the array, return the number of "big" steps for a walk starting at the start index
     * and ending at the end index. We'll say that step is big if it is 5 or more up or down.
     * The start end end index will both be valid indexes into the array with start <= end.
     *
     * bigHeights([5, 3, 6, 7, 2], 2, 4) → 1
     * bigHeights([5, 3, 6, 7, 2], 0, 1) → 0
     * bigHeights([5, 3, 6, 7, 2], 0, 4) → 1
     *
     * @param heights
     * @param start
     * @param end
     * @return
     */
    public int bigHeights(int[] heights, int start, int end) {
        int[] counterTrack = new int[end - start];
        counterTrack = Arrays.copyOfRange(heights, start, end + 1);
        int counter = 0;
        for(int i = 0; i < counterTrack.length - 1; i++){
            if(Math.abs(counterTrack[i + 1] - counterTrack[i]) >= 5){
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * We have data for two users, A and B, each with a String name and an int id. The goal is to order the users
     * such as for sorting. Return -1 if A comes before B, 1 if A comes after B, and 0 if they are the same.
     * Order first by the string names, and then by the id numbers if the names are the same.
     * Note: with Strings str1.compareTo(str2) returns an int value which is negative/0/positive to indicate
     * how str1 is ordered to str2 (the value is not limited to -1/0/1).
     * (On the AP, there would be two User objects, but here the code simply takes the two strings and two ints directly.
     * The code logic is the same.)
     *
     * userCompare("bb", 1, "zz", 2) → -1
     * userCompare("bb", 1, "aa", 2) → 1
     * userCompare("bb", 1, "bb", 1) → 0
     *
     * @param aName
     * @param aId
     * @param bName
     * @param bId
     * @return
     */
    public int userCompare(String aName, int aId, String bName, int bId) {
        int orderByName = compareByName(aName, bName);
        int orderById = compareById(aId, bId);
        return computeResult(orderByName, orderById);
    }
    
    private int compareByName(String nameA, String nameB){
        if(nameA.compareTo(nameB) < 0){
            return -1;
        }
        else if(nameA.compareTo(nameB) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    
    private int compareById(int idA, int idB){
        if(idA < idB){
            return -1;
        }
        else if(idA == idB){
            return 0;
        }
        else {
            return 1;
        }
    }
    
    private int computeResult(int orderByName, int orderById){
        if(orderByName == 0){
            return orderById;
        }
        else {
            return orderByName;
        }
    }
    
    /**
     * Start with two arrays of strings, A and B, each with its elements in alphabetical order and without duplicates.
     * Return a new array containing the first N elements from the two arrays. The result array should be
     * in alphabetical order and without duplicates. A and B will both have a length which is N or more.
     * The best "linear" solution makes a single pass over A and B, taking advantage of the fact
     * that they are in alphabetical order, copying elements directly to the new array.
     *
     * mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) → ["a", "b", "c"]
     * mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) → ["a", "c", "f"]
     * mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) → ["c", "f", "g"]
     *
     * @param a
     * @param b
     * @param n
     * @return
     */
    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] result = new String[n];
        int aIndex = 0;
        int bIndex = 0;
        for(int i = 0; i < n; i++){
            if(a[aIndex].compareTo(b[bIndex]) <= 0){
                result[i] = a[aIndex];
                if(aIndex < a.length - 1){
                    aIndex++;
                }
                
            }
            else{
                result[i] = b[bIndex];
                if(bIndex < b.length - 1){
                    bIndex++;
                }
            }
            if(result[i].equals(a[aIndex])){
                if(aIndex < a.length - 1){
                    aIndex++;
                }
            }
            if(result[i].equals(b[bIndex])){
                if(bIndex < b.length - 1){
                    bIndex++;
                }
            }
        }
        return result;
    }
    
    /**
     * Start with two arrays of strings, a and b, each in alphabetical order, possibly with duplicates.
     * Return the count of the number of strings which appear in both arrays. The best "linear" solution
     * makes a single pass over both arrays, taking advantage of the fact that they are in alphabetical order.
     *
     * commonTwo(["a", "c", "x"], ["b", "c", "d", "x"]) → 2
     * commonTwo(["a", "c", "x"], ["a", "b", "c", "x", "z"]) → 3
     * commonTwo(["a", "b", "c"], ["a", "b", "c"]) → 3
     *
     * @param a
     * @param b
     * @return
     */
    public  int commonTwo(String[] a, String[] b) {
        if(a.length == 0 || b.length == 0){
            return 0;
        }
        int aIndex = 0;
        int bIndex = 0;
        int counter = 0;
        while(aIndex != -1 && bIndex != -1){ //Wystarczy, że jedno będize -1, wtedy drugiej listy nie ma sensu sprawdzać.
            if(a[aIndex].equals(b[bIndex])){
                counter++;
                aIndex = indexOfNextLetter(a, aIndex);
                bIndex = indexOfNextLetter(b, bIndex);
            }
            else if(a[aIndex].compareTo(b[bIndex]) < 0){
                aIndex = indexOfNextLetter(a, aIndex);
            }
            else {
                bIndex = indexOfNextLetter(b, bIndex);
            }
        };
        return counter;
    }
    
    private  int indexOfNextLetter(String[] lista, int oldIndex){
        if(oldIndex == lista.length - 1){
            return -1;
        }
        String currentLetter = lista[oldIndex];
        int newIndex = oldIndex;
        if(oldIndex < lista.length - 1){
            do{
                newIndex++;
            } while(lista[newIndex].equals(currentLetter) && newIndex != lista.length - 1);
        }
        return newIndex;
    }
    
}
