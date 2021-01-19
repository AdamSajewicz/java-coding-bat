package recursion2.src;

public class Recursion2 {
    
    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
     * This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem,
     * you can use the same pattern for many problems to search a space of choices.
     * Rather than looking at the whole array, our convention is to consider the part of the array starting at index start
     * and continuing to the end of the array. The caller can specify the whole array simply by passing start as 0.
     * No loops are needed -- the recursive calls progress down the array.
     *
     * groupSum(0, [2, 4, 8], 10) → true
     * groupSum(0, [2, 4, 8], 14) → true
     * groupSum(0, [2, 4, 8], 9) → false
     *
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length){
            return (target == 0);
        }
        if (groupSum(start + 1, nums, target - nums[start])){
            return true;
        }
        if (groupSum(start + 1, nums, target)){
            return true;
        }
        return false;
    }
    
    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index,
     * such that the group sums to the given target? However, with the additional constraint that all 6's must be chosen. (No loops needed.)
     *
     * groupSum6(0, [5, 6, 2], 8) → true
     * groupSum6(0, [5, 6, 2], 9) → false
     * groupSum6(0, [5, 6, 2], 7) → false
     *
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start >= nums.length){
            if(target == 0){
                return true;
            }
            else {
                return false;
            }
        }
        if(nums[start] == 6){
            return groupSum6(start + 1, nums, target - 6);
        }
        else {
            if(groupSum6(start + 1, nums, target - nums[start])){
                return true;
            }
            if (groupSum6(start + 1, nums, target))  {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums
     * to the given target with this additional constraint: If a value in the array is chosen to be in the group,
     * the value immediately following it in the array must not be chosen. (No loops needed.)
     *
     * groupNoAdj(0, [2, 5, 10, 4], 12) → true
     * groupNoAdj(0, [2, 5, 10, 4], 14) → false
     * groupNoAdj(0, [2, 5, 10, 4], 7) → false
     *
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length){
            if(target == 0){
                return true;
            }
            else {
                return false;
            }
        }
        if(groupNoAdj(start + 2, nums, target - nums[start])){
            return true;
        }
        if(groupNoAdj(start + 1, nums, target)){
            return true;
        }
        return false;
    }
    
    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target
     * with these additional constraints: all multiples of 5 in the array must be included in the group.
     * If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
     *
     * groupSum5(0, [2, 5, 10, 4], 19) → true
     * groupSum5(0, [2, 5, 10, 4], 17) → true
     * groupSum5(0, [2, 5, 10, 4], 12) → false
     *
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupSum5(int start, int[] nums, int target) {
        if(start >= nums.length){
            if(target == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        if(nums[start]%5 == 0){
            if(nums.length - start == 1){ //start is the last element
                return target == nums[start];
            }
            else { // start is not the last element
                if(nums[start + 1] != 1){
                    return groupSum5(start + 1, nums, target - nums[start]);
                }
                else{
                    return groupSum5(start + 2, nums, target - nums[start]);
                }
            }
        }
        else{
            if(groupSum5(start + 1, nums, target - nums[start])) {
                return true;
            }
            if(groupSum5(start + 1, nums, target)) {
                return true;
            }
            return false;
        }
        
    }
    
    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target,
     * with this additional constraint: if there are numbers in the array that are adjacent and the identical value,
     * they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2},
     * either all three 2's in the middle must be chosen or not, all as a group.
     * (one loop can be used to find the extent of the identical values).
     *
     * groupSumClump(0, [2, 4, 8], 10) → true
     * groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
     * groupSumClump(0, [2, 4, 4, 8], 14) → false
     *
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length){
            if(target == 0){
                return true;
            }
            else {
                return false;
            }
        }
        if(isBeginningOfClump(start, nums)){
            if(groupSumClump(start + clumpSize(start, nums), nums, target - clumpValue(start, nums))){
                return true;
            }
            if(groupSumClump(start + clumpSize(start, nums), nums, target)){
                return true;
            }
            return false;
        }
        else {
            if(groupSumClump(start + 1, nums, target - nums[start])){
                return true;
            }
            if(groupSumClump(start + 1, nums, target)){
                return true;
            }
            return false;
        }
    }
    
    private boolean isBeginningOfClump(int index, int[] nums){
        if(index == nums.length - 1){
            return false;
        }
        if(nums[index] == nums[index + 1]){
            return true;
        }
        else {
            return false;
        }
    }
    
    private int clumpValue(int start, int[] nums){
        int returnValue = 0;
        int i = start;
        do{
            returnValue += nums[i];
            i++;
        }
        while (nums[i - 1] == nums[i] && i < nums.length);
        return returnValue;
    }
    
    private int clumpSize(int start, int[] nums){
        int returnSize = 0;
        int i = start;
        do{
            returnSize++;
            i++;
        }
        while (nums[i - 1] == nums[i] && i < nums.length);
        return returnSize;
    }
    
    /**
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same.
     * Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like,
     * and make the initial call to your recursive helper from splitArray(). (No loops needed.)
     *
     * splitArray([2, 2]) → true
     * splitArray([2, 3]) → false
     * splitArray([5, 2, 3]) → true
     *
     * @param nums
     * @return
     */
    public boolean splitArray(int[] nums) {
        return splitArrayHelper(0, nums, 0, 0);
    }
    
    public boolean splitArrayHelper(int start, int[] nums, int group1,
                                    int group2) {
        if(start >= nums.length)
            return group1 == group2;
        
        if(splitArrayHelper(start+1, nums, group1 + nums[start], group2))
            return true;
        
        if(splitArrayHelper(start+1, nums, group1, group2 + nums[start]))
            return true;
        
        return false;
    }
    
    /**
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group is a multiple of 10,
     * and the sum of the other group is odd. Every int must be in one group or the other. Write a recursive helper method
     * that takes whatever arguments you like, and make the initial call to your recursive helper from splitOdd10().
     * (No loops needed.)
     *
     * splitOdd10([5, 5, 5]) → true
     * splitOdd10([5, 5, 6]) → false
     * splitOdd10([5, 5, 6, 1]) → true
     *
     * @param nums
     * @return
     */
    public boolean splitOdd10(int[] nums) {
        return splitOdd10Helper(0, nums, 0, 0);
    }
    
    private boolean splitOdd10Helper(int start, int[] nums, int group10, int groupOdd){
        if(start >= nums.length){
            if(group10%10 == 0 && groupOdd%2 == 1){
                return true;
            }
            else {
                return false;
            }
        }
        if(splitOdd10Helper(start + 1, nums, group10 + nums[start], groupOdd)){
            return true;
        }
        if(splitOdd10Helper(start + 1, nums, group10, groupOdd + nums[start])){
            return true;
        }
        return false;
    }
    
    /**
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of the two groups is the same,
     * with these constraints: all the values that are multiple of 5 must be in one group, and all the values that are a multiple of 3
     * (and not a multiple of 5) must be in the other. (No loops needed.)
     *
     * split53([1, 1]) → true
     * split53([1, 1, 1]) → false
     * split53([2, 4, 2]) → true
     *
     * @param nums
     * @return
     */
    public boolean split53(int[] nums) {
        return split53Helper(0, nums, 0, 0);
    }
    
    private boolean split53Helper(int start, int[] nums, int group5, int group3){
        if(start >= nums.length){
            if(group5 == group3){
                return true;
            }
            else {
                return false;
            }
        }
        if(nums[start]%5 == 0){
            return split53Helper(start + 1, nums, group5 + nums[start], group3);
        }
        else if(nums[start]%3 == 0){
            return split53Helper(start + 1, nums, group5, group3 + nums[start]);
        }
        else {
            if(split53Helper(start + 1, nums, group5 + nums[start], group3)){
                return true;
            }
            if(split53Helper(start + 1, nums, group5, group3 + nums[start])){
                return true;
            }
            return false;
        }
    }
    
}
