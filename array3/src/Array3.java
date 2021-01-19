package array3.src;

import java.util.Arrays;

public class Array3 {
    
    /**
     * Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span"
     * is the number of elements between the two inclusive. A single value has a span of 1.
     * Returns the largest span found in the given array. (Efficiency is not a priority.)
     *
     * maxSpan([1, 2, 1, 1, 3]) → 4
     * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
     * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     *
     * @param nums
     * @return
     */
    public int maxSpan(int[] nums) {
        int maxSpan = 0;
        if(nums.length == 0){
            return maxSpan;
        }
        for(int i = 0; i < nums.length; i++){
            int span = 0;
            span = findSpan(nums, i);
            if(span > maxSpan){
                maxSpan = span;
            }
        }
        return maxSpan;
    }
    
    private int findSpan(int[] nums, int i){
        int value = nums[i];
        int firstIndex = indexOfFirstAppearence(nums, value);
        int lastIndex = indexOfLastAppearence(nums, value);
        return lastIndex - firstIndex + 1;
    }
    
    private int indexOfFirstAppearence(int[] nums, int value){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == value){
                return i;
            }
        }
        return - 1;
    }
    
    private int indexOfLastAppearence(int[] nums, int value){
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == value){
                return i;
            }
        }
        return - 1;
    }
    
    /**
     * Return an array that contains exactly the same numbers as the given array, but rearranged
     * so that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may move.
     * The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3,
     * and a 3 appears in the array before any 4.
     *
     * fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
     * fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
     * fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
     *
     * @param nums
     * @return
     */
    public int[] fix34(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 3){
                int index4 = find4From(nums, i);
                move4After3(nums, i + 1, index4);
                i++;
            }
        }
        return nums;
    }
    
    private int find4From(int[] nums, int i){
        if(nums[i + 1] == 4){
            return i + 1;
        }
        for(int j = 1; j < nums.length; j++){
            if(nums[j] == 4  && nums[j - 1] != 3){
                return j;
            }
        }
        return -1;
    }
    
    private void move4After3(int[] nums, int i, int index4){
        int temp = nums[i];
        nums[i] = nums[index4];
        nums[index4] = temp;
    }
    
    /**
     * (This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers
     * as the given array, but rearranged so that every 4 is immediately followed by a 5.
     * Do not move the 4's, but every other number may move. The array contains the same number of 4's and 5's,
     * and every 4 has a number after it that is not a 4. In this version, 5's may appear anywhere in the original array.
     *
     * fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
     * fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
     * fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
     *
     * @param nums
     * @return
     */
    public int[] fix45(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        int[] newNums = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 5){
                newNums[i] = nums[i];
                nums[i] = -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(newNums[i] == 4){
                int index5 = findFirst5(nums);
                if(newNums[i + 1] == 0){
                    newNums[i + 1] = 5;
                    nums[index5] = -1;
                }
                else {
                    int temp = newNums[i + 1];
                    newNums[i + 1] = 5;
                    nums[index5] = -1;
                    int j = 0;
                    while(newNums[j] != 0){
                        j++;
                    }
                    newNums[j] = temp;
                }
            }
        }
        return newNums;
    }
    
    private int findFirst5(int[] nums){
        int i = 0;
        while(nums[i] != 5){
            i++;
        };
        return i;
    }
    
    /**
     * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers
     * on one side is equal to the sum of the numbers on the other side.
     *
     * canBalance([1, 1, 1, 2, 1]) → true
     * canBalance([2, 1, 1, 2, 1]) → false
     * canBalance([10, 10]) → true
     *
     * @param nums
     * @return
     */
    public boolean canBalance(int[] nums) {
        if(nums.length < 2){
            return false;
        }
        int i = 0;
        int j = nums.length - 1;
        int counter = 0;
        int sumLeft = 0;
        int sumRight = 0;
        
        while(counter < nums.length){
            if(sumLeft == sumRight){
                if(i == j){
                    return false;
                }
                sumLeft += nums[i];
                sumRight += nums[j];
                i++;
                j--;
                counter += 2;
            }
            else if(sumLeft < sumRight){
                sumLeft += nums[i];
                i++;
                counter++;
            }
            else{
                sumRight += nums[j];
                j--;
                counter++;
            }
        };
        
        return sumLeft == sumRight;
        
    }
    
    /**
     * Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers
     * in inner appear in outer. The best solution makes only a single "linear" pass of both arrays,
     * taking advantage of the fact that both arrays are already in sorted order.
     *
     * linearIn([1, 2, 4, 6], [2, 4]) → true
     * linearIn([1, 2, 4, 6], [2, 3, 4]) → false
     * linearIn([1, 2, 4, 4, 6], [2, 4]) → true
     *
     * @param outer
     * @param inner
     * @return
     */
    public boolean linearIn(int[] outer, int[] inner) {
        if(inner.length > outer.length){
            return false;
        }
        if(outer.length == 0){
            return inner.length == 0;
        }
        if(inner.length == 0){
            return true;
        }
        boolean flag = true;
        int i = 0;
        do{
            if(Arrays.binarySearch(outer, inner[i]) < 0){
                flag = false;
            }
            i++;
        } while(i < inner.length && flag);
        return flag;
    }
    
    /**
     * Given n>=0, create an array length n*n with the following pattern,
     * shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
     *
     * squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
     * squareUp(2) → [0, 1, 2, 1]
     * squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
     *
     * @param n
     * @return
     */
    public int[] squareUp(int n) {
        int[] squared = new int[n*n];
        if(n == 0){
            return squared;
        }
        if(n == 1){
            squared[0] = 1;
            return squared;
        }
        int number = n;
        int[] stempel = new int[n];
        for(int i = 0; i < n; i++){
            stempel[i] = number;
            number--;
        }
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            matrix[i] = Arrays.copyOf(stempel, n);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i < n - 1 && j < n - 1 && i + j < n - 1){
                    squared[(i * n) + j] = 0;
                }
                else{
                    squared[(i * n) + j] = matrix[i][j];
                }
            }
        }
        return squared;
    }
    
    /**
     * Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n}
     * (spaces added to show the grouping).
     * Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n + 1)/2.
     *
     * seriesUp(3) → [1, 1, 2, 1, 2, 3]
     * seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
     * seriesUp(2) → [1, 1, 2]
     *
     * @param n
     * @return
     */
    public int[] seriesUp(int n) {
        int[] stempel = new int[n];
        if(n == 0){
            return stempel;
        }
        if(n == 1){
            stempel[0] = 1;
            return stempel;
        }
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            stempel[i] = i + 1;
            matrix[i] = Arrays.copyOf(stempel, n);
        }
        int[] series = new int[n*(n + 1)/2];
        int pointer = 0;
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < n; j++){
                if(matrix[i][j] != 0){
                    series[pointer] = matrix[i][j];
                    pointer++;
                }
            }
        }
        return series;
    }
    
    /**
     * We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array,
     * the same group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1}
     * is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
     *
     * maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
     * maxMirror([1, 2, 1, 4]) → 3
     * maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
     *
     * @param nums
     * @return
     */
    public int maxMirror(int[] nums) {
        int length = nums.length;
        if(length < 2){
            return length;
        }
        int[] base = new int[3 * length];
        Arrays.fill(base, -1);
        for(int i = length; i < length * 2; i++){
            base[i] = nums[i - length];
        }
        int[] smun = new int[length];
        for(int i = 0; i < length; i++){
            smun[i] = nums[length - i - 1];
        }
        int[] smunBase = new int[length * 3];
        int[] smunBaseChecker = new int[length * 3];
        resetSmunBase(smunBase, length);
        resetBaseChecker(smunBaseChecker, length);
        
        
        int maxMirror = 0;
        int candidateMirror = 0;
        int localMirror = 0;
        
        for(int baseIndex = 1; baseIndex < length * 2; baseIndex++){
            setSmunBase(smunBase, smun, baseIndex);
            
            for(int i = length; i < length * 2; i++){
                if(smunBase[i] != -1 && base[i] == smunBase[i]){
                    smunBaseChecker[i] = 1;
                }
            }
            localMirror = 0;
            for(int i = length; i < length * 2; i++){
                if(smunBaseChecker[i] == 1){ // dodac warunek, ze nie koniec smunBaseChecker'a
                    localMirror++;
                }
                else {
                    if(localMirror > candidateMirror){
                        candidateMirror = localMirror;
                        //spr dokładnie, kiedy powinien być zerowany localMirror
                    }
                    localMirror = 0;
                }
            }
            if(localMirror > candidateMirror){
                candidateMirror = localMirror;
                
            }
            localMirror = 0;
            if(candidateMirror > maxMirror){
                maxMirror = candidateMirror;
            }
            candidateMirror = 0;
            resetSmunBase(smunBase, length);
            resetBaseChecker(smunBaseChecker, length);
        }
        
        
        
        
        return maxMirror;
    }
    
    private void resetSmunBase(int[] smunArray, int len){
        for(int i = 0; i < len * 3; i++){
            smunArray[i] = -1;
        }
    }
    
    private void resetBaseChecker(int[] numsArray, int len){
        for(int i = 0; i < len * 3; i++){
            numsArray[i] = 0;
        }
    }
    
    private void setSmunBase(int[] smunBaseArray, int[] smun, int fromIndex){
        
        int j = 0;
        for(int i = fromIndex; i < fromIndex + smun.length; i++){
            smunBaseArray[i] = smun[j];
            j++;
        }
    }
    
    /**
     * Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
     * Return the number of clumps in the given array.
     *
     * countClumps([1, 2, 2, 3, 4, 4]) → 2
     * countClumps([1, 1, 2, 1, 1]) → 2
     * countClumps([1, 1, 1, 1, 1]) → 1
     *
     * @param nums
     * @return
     */
    public int countClumps(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        boolean[] clumpChecker = new boolean[nums.length];
        Arrays.fill(clumpChecker, false);
        boolean[] valueChange = new boolean[nums.length];
        Arrays.fill(valueChange, false);
        for(int i = 0; i < nums.length; i++){
            clumpChecker[i] = checkNums(nums, i);
            valueChange[i] = checkValueChanges(nums, i);
        }
        
        int clumpCounter = 0;
        for(int i = 0; i < nums.length; i++){
            if(clumpStart(valueChange, clumpChecker, i)){
                clumpCounter++;
            }
        }
        return clumpCounter;
    }
    
    private boolean checkNums(int[] nums, int i){
        int valueInQuestion = nums[i];
        if(i == 0){
            if(nums[i + 1] == valueInQuestion){
                return true;
            }
            else {
                return false;
            }
        }
        else if(i > 0 && i < nums.length - 1){
            if(nums[i - 1] == valueInQuestion){
                return true;
            }
            else{
                if(nums[i + 1] == valueInQuestion){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            if(nums[i - 1] == valueInQuestion){
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    private boolean checkValueChanges(int[] nums, int i){
        if(i == 0){
            return true;
        }
        if(nums[i] != nums[i - 1]){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean clumpStart(boolean[] valueChange, boolean[] checker, int i){
        if(valueChange[i]){
            if(checker[i]){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    
}
