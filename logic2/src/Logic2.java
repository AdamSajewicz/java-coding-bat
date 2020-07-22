package logic2.src;

public class Logic2 {
    /**
     * We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big bricks (5 inches each). Return true if it is possible to make the goal by choosing from the given bricks. This is a little harder than it looks and can be done without any loops. See also: Introduction to MakeBricks
     *
     * makeBricks(3, 1, 8) → true
     * makeBricks(3, 1, 9) → false
     * makeBricks(3, 2, 10) → true
     *
     * @param small
     * @param big
     * @param goal
     * @return
     */
    public boolean makeBricks(int small, int big, int goal) {
        int maxInchesPossible = big * 5 + small;
        if(goal > maxInchesPossible){
            return false;
        }
        int amountOfSmallToFillGoal = goal % 5;
        int bigFromSmall = small / 5;
        int needForBig = goal / 5;
        if(needForBig > big && bigFromSmall > 0){
            int missingBigToFillGoal = needForBig - big;
            if(bigFromSmall >= missingBigToFillGoal){
                int remainingSmall = small - (missingBigToFillGoal * 5);
                if(amountOfSmallToFillGoal <= remainingSmall){
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
        else if(needForBig > big && bigFromSmall == 0){
            return false;
        }
        else if(needForBig <= big){
            if(amountOfSmallToFillGoal <= small){
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
    
    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values, it does not count towards the sum.
     *
     * loneSum(1, 2, 3) → 6
     * loneSum(3, 2, 3) → 2
     * loneSum(3, 3, 3) → 0
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int loneSum(int a, int b, int c) {
        int sum = 0;
        //examine a
        if(a != b && a != c){
            sum += a;
        }
        //examine b
        if(b != a && b != c){
            sum += b;
        }
        //examine c
        if(c != a && c != b){
            sum += c;
        }
        return sum;
    }
    
    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count.
     *
     * luckySum(1, 2, 3) → 6
     * luckySum(1, 2, 13) → 3
     * luckySum(1, 13, 3) → 1
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int luckySum(int a, int b, int c) {
        int aa = a;
        int bb = b;
        int cc = c;
        if(a == 13){
            aa = 0;
            bb = 0;
            cc = 0;
        }
        if(b == 13){
            bb = 0;
            cc = 0;
        }
        if(c == 13){
            cc = 0;
        }
        return aa + bb + cc;
    }
    
    /**
     * Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15 and 16 do not count as a teens. Write a separate helper "public int fixTeen(int n) {"that takes in an int value and returns that value fixed for the teen rule. In this way, you avoid repeating the teen code 3 times (i.e. "decomposition"). Define the helper below and at the same indent level as the main noTeenSum().
     *
     * noTeenSum(1, 2, 3) → 6
     * noTeenSum(2, 13, 1) → 3
     * noTeenSum(2, 1, 14) → 3
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }
    
    public int fixTeen(int n){
        if((n >= 13 && n < 15) || (n > 16 && n <= 19)){
            return 0;
        }
        return n;
    }
    
    /**
     * For this problem, we'll round an int value up to the next multiple of 10 if its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, a b c, return the sum of their rounded values. To avoid code repetition, write a separate helper "public int round10(int num) {" and call it 3 times. Write the helper entirely below and at the same indent level as roundSum().
     *
     * roundSum(16, 17, 18) → 60
     * roundSum(12, 13, 14) → 30
     * roundSum(6, 4, 4) → 10
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int roundSum(int a, int b, int c) {
        return round10(a) + round10(b) + round10(c);
    }
    
    public int round10(int num){
        int reminder = num % 10;
        int decimalPart = num / 10;
        if(reminder < 5){
            return decimalPart * 10;
        }
        else{
            return (decimalPart + 1) * 10;
        }
    }
    
    /**
     * Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1), while the other is "far", differing from both other values by 2 or more. Note: Math.abs(num) computes the absolute value of a number.
     *
     * closeFar(1, 2, 10) → true
     * closeFar(1, 2, 3) → false
     * closeFar(4, 1, 3) → true
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public boolean closeFar(int a, int b, int c) {
        boolean bOrCCloseA = (Math.abs(b - a) <= 1 || (Math.abs(c - a) <= 1));
        boolean otherFar = (Math.abs(b - a) >= 2 && Math.abs(b - c) >= 2) ||
                (Math.abs(c - a) >= 2 && Math.abs(c - b) >= 2);
        return bOrCCloseA && otherFar;
    }
    
    /**
     * Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.
     *
     * blackjack(19, 21) → 21
     * blackjack(21, 19) → 21
     * blackjack(19, 22) → 19
     *
     * @param a
     * @param b
     * @return
     */
    public int blackjack(int a, int b) {
        boolean aLess21 = a <= 21;
        boolean bLess21 = b <= 21;
        if(!(aLess21 || bLess21)){
            return 0;
        }
        if(aLess21 && bLess21){
            return Math.max(a, b);
        }
        else {
            if(aLess21){
                return a;
            }
            else{
                return b;
            }
        }
    }
    
    /**
     * Given three ints, a b c, one of them is small, one is medium and one is large. Return true if the three values are evenly spaced, so the difference between small and medium is the same as the difference between medium and large.
     *
     * evenlySpaced(2, 4, 6) → true
     * evenlySpaced(4, 6, 2) → true
     * evenlySpaced(4, 6, 3) → false
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public boolean evenlySpaced(int a, int b, int c) {
        int aa = min3(a, b, c);
        int bb = mid3(a, b, c);
        int cc = max3(a, b, c);
        return (bb - aa == cc - bb);
    }
    
    public int min3(int a, int b, int c){
        int minAB = Math.min(a, b);
        return Math.min(minAB, c);
    }
    
    public int mid3(int a, int b, int c){
        if((b <= a && a <= c) || (c <= a && a <= b)){
            return a;
        }
        if((a <= b && b <= c) || (c <= b && b <= a)){
            return b;
        }
        return c;
    }
    
    public int max3(int a, int b, int c){
        int maxAB = Math.max(a, b);
        return Math.max(maxAB, c);
    }
    
    /**
     * We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each). Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.
     *
     * makeChocolate(4, 1, 9) → 4
     * makeChocolate(4, 1, 10) → -1
     * makeChocolate(4, 1, 7) → 2
     *
     * @param small
     * @param big
     * @param goal
     * @return
     */
    public int makeChocolate(int small, int big, int goal) {
        if((big * 5 + small) < goal){
            return -1;
        }
        int desiredNumberOfBig = goal / 5;
        int neededSmallAfterUseBig = goal % 5;
        if(desiredNumberOfBig <= big){
            if(neededSmallAfterUseBig <= small){
                return neededSmallAfterUseBig;
            }
            else{
                return -1; // maybe needs to focus on more deeply
            }
        }
        else{
            neededSmallAfterUseBig = goal - (big * 5);
            if(neededSmallAfterUseBig <= small){
                return neededSmallAfterUseBig;
            }
            else {
                return -1;
            }
        }
    }
    
}
