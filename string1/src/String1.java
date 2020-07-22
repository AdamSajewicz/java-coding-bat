package string1.src;

public class String1 {
    /**
     * Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
     *
     * helloName("Bob") → "Hello Bob!"
     * helloName("Alice") → "Hello Alice!"
     * helloName("X") → "Hello X!"
     *
     * @param name
     * @return
     */
    public String helloName(String name) {
        return "Hello " + name + '!';
    }
    
    /**
     * Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
     *
     * makeAbba("Hi", "Bye") → "HiByeByeHi"
     * makeAbba("Yo", "Alice") → "YoAliceAliceYo"
     * makeAbba("What", "Up") → "WhatUpUpWhat"
     *
     * @param a
     * @param b
     * @return
     */
    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }
    
    /**
     * The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example, the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>".
     *
     * makeTags("i", "Yay") → "<i>Yay</i>"
     * makeTags("i", "Hello") → "<i>Hello</i>"
     * makeTags("cite", "Yay") → "<cite>Yay</cite>"
     *
     * @param tag
     * @param word
     * @return
     */
    public String makeTags(String tag, String word) {
        return '<' + tag + '>' + word + "</" + tag + '>';
    }
    
    /**
     * Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting at index i and going up to but not including index j.
     *
     * makeOutWord("<<>>", "Yay") → "<<Yay>>"
     * makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
     * makeOutWord("[[]]", "word") → "[[word]]"
     *
     * @param out
     * @param word
     * @return
     */
    public String makeOutWord(String out, String word) {
        String beginOut = out.substring(0, 2);
        String endOut = out.substring(2);
        return beginOut + word + endOut;
    }
    
    /**
     * Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string length will be at least 2.
     *
     * extraEnd("Hello") → "lololo"
     * extraEnd("ab") → "ababab"
     * extraEnd("Hi") → "HiHiHi"
     *
     * @param str
     * @return
     */
    public String extraEnd(String str) {
        String ending = str.substring(str.length() - 2);
        return ending + ending + ending;
    }
    
    /**
     * Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string "" yields the empty string "". Note that str.length() returns the length of a string.
     *
     * firstTwo("Hello") → "He"
     * firstTwo("abcdefg") → "ab"
     * firstTwo("ab") → "ab"
     *
     * @param str
     * @return
     */
    public String firstTwo(String str) {
        if(str.length() < 2) {
            return str;
        }
        return str.substring(0, 2);
    }
    
    /**
     * Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
     *
     * firstHalf("WooHoo") → "Woo"
     * firstHalf("HelloThere") → "Hello"
     * firstHalf("abcdef") → "abc"
     *
     * @param str
     * @return
     */
    public String firstHalf(String str) {
        if(str.isEmpty()){
            return "";
        }
        int lengthOfTheHalf = str.length() / 2;
        return str.substring(0, lengthOfTheHalf);
    }
    
    /**
     * Given a string, return a version without the first and last char, so "Hello" yields "ell". The string length will be at least 2.
     *
     * withoutEnd("Hello") → "ell"
     * withoutEnd("java") → "av"
     * withoutEnd("coding") → "odin"
     *
     * @param str
     * @return
     */
    public String withoutEnd(String str) {
        if(str.length() <= 2){
            return "";
        }
        return str.substring(1, str.length() - 1);
    }
    
    /**
     * Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string on the outside and the longer string on the inside. The strings will not be the same length, but they may be empty (length 0).
     *
     * comboString("Hello", "hi") → "hiHellohi"
     * comboString("hi", "Hello") → "hiHellohi"
     * comboString("aaa", "b") → "baaab"
     *
     * @param a
     * @param b
     * @return
     */
    public String comboString(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        if(aLength < bLength){
            return a + b + a;
        }
        else {
            return b + a + b;
        }
    }
    
    /**
     * Given 2 strings, return their concatenation, except omit the first char of each. The strings will be at least length 1.
     *
     * nonStart("Hello", "There") → "ellohere"
     * nonStart("java", "code") → "avaode"
     * nonStart("shotl", "java") → "hotlava"
     *
     * @param a
     * @param b
     * @return
     */
    public String nonStart(String a, String b) {
        String aPart = "";
        String bPart = "";
        if(a.length() != 1){
            aPart = aPart + a.substring(1);
        }
        if(b.length() != 1){
            bPart = bPart + b.substring(1);
        }
        return aPart + bPart;
    }
    
    /**
     * Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. The string length will be at least 2.
     *
     * left2("Hello") → "lloHe"
     * left2("java") → "vaja"
     * left2("Hi") → "Hi"
     *
     * @param str
     * @return
     */
    public String left2(String str) {
        if(str.length() < 3){
            return str;
        }
        String first2 = str.substring(0, 2);
        String theRest = str.substring(2);
        return theRest + first2;
    }
    
    /**
     *  Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start. The string length will be at least 2.
     *
     * right2("Hello") → "loHel"
     * right2("java") → "vaja"
     * right2("Hi") → "Hi"
     *
     * @param str
     * @return
     */
    public String right2(String str) {
        if(str.length() < 3){
            return str;
        }
        String last2 = str.substring(str.length() - 2);
        String firstPart = str.substring(0, str.length() - 2);
        return last2 + firstPart;
    }
    
    /**
     * Given a string, return a string length 1 from its front, unless front is false, in which case return a string length 1 from its back. The string will be non-empty.
     *
     * theEnd("Hello", true) → "H"
     * theEnd("Hello", false) → "o"
     * theEnd("oh", true) → "o"
     *
     * @param str
     * @param front
     * @return
     */
    public String theEnd(String str, boolean front) {
        if(str.length() == 1) {
            return str;
        }
        if(front){
            return "" + str.charAt(0);
        }
        else {
            return "" + str.charAt(str.length() - 1);
        }
    }
    
    /**
     * Given a string, return a version without both the first and last char of the string. The string may be any length, including 0.
     *
     * withouEnd2("Hello") → "ell"
     * withouEnd2("abc") → "b"
     * withouEnd2("ab") → ""
     *
     * @param str
     * @return
     */
    public String withouEnd2(String str) {
        if(str.length() < 3){
            return "";
        }
        return str.substring(1, str.length() - 1);
    }
    
    /**
     * Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri". The string length will be at least 2.
     *
     * middleTwo("string") → "ri"
     * middleTwo("code") → "od"
     * middleTwo("Practice") → "ct"
     *
     * @param str
     * @return
     */
    public String middleTwo(String str) {
        int startIndex = (str.length() / 2) - 1;
        return str.substring(startIndex, startIndex + 2);
    }
    
    /**
     * Given a string, return true if it ends in "ly".
     *
     * endsLy("oddly") → true
     * endsLy("y") → false
     * endsLy("oddy") → false
     *
     * @param str
     * @return
     */
    public boolean endsLy(String str) {
        return (str.endsWith("ly"));
    }
    
    /**
     * Given a string and an int n, return a string made of the first and last n chars from the string. The string length will be at least n.
     *
     * nTwice("Hello", 2) → "Helo"
     * nTwice("Chocolate", 3) → "Choate"
     * nTwice("Chocolate", 1) → "Ce"
     *
     * @param str
     * @param n
     * @return
     */
    public String nTwice(String str, int n) {
        if(str.length() == 0){
            return "";
        }
        if(str.length() == 1){
            return str + str;
        }
        return str.substring(0, n) + str.substring(str.length() - n);
    }
    
    /**
     * Given a string and an index, return a string length 2 starting at the given index. If the index is too big or too small to define a string length 2, use the first 2 chars. The string length will be at least 2.
     *
     * twoChar("java", 0) → "ja"
     * twoChar("java", 2) → "va"
     * twoChar("java", 3) → "ja"
     *
     * @param str
     * @param index
     * @return
     */
    public String twoChar(String str, int index) {
        if(index <= 0 || index > str.length() - 2){
            return str.substring(0, 2);
        }
        return str.substring(index, index + 2);
    }
    
    /**
     * Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and". The string length will be at least 3.
     *
     * middleThree("Candy") → "and"
     * middleThree("and") → "and"
     * middleThree("solving") → "lvi"
     *
     * @param str
     * @return
     */
    public String middleThree(String str) {
        int startIndex = (str.length() - 3) / 2;
        return str.substring(startIndex, startIndex + 3);
    }
    
    /**
     * Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals() to compare 2 strings.
     *
     * hasBad("badxx") → true
     * hasBad("xbadxx") → true
     * hasBad("xxbadxx") → false
     *
     * @param str
     * @return
     */
    public boolean hasBad(String str) {
        if(str.length() < 3) {
            return false;
        }
        String from0 = str.substring(0 , 3);
        String from1 = "";
        if(str.length() >= 4){
            from1 = from1 + str.substring(1, 4);
        }
        return (from0.equals("bad") || from1.equals("bad"));
    }
    
    /**
     * Given a string, return a string length 2 made of its first 2 chars. If the string length is less than 2, use '@' for the missing chars.
     *
     * atFirst("hello") → "he"
     * atFirst("hi") → "hi"
     * atFirst("h") → "h@"
     *
     * @param str
     * @return
     */
    public String atFirst(String str) {
        if(str.length() == 0){
            return "@@";
        }
        if(str.length() == 1){
            return str + '@';
        }
        if(str.length() == 2){
            return str;
        }
        return str.substring(0, 2);
    }
    
    /**
     * Given 2 strings, a and b, return a new string made of the first char of a and the last char of b, so "yo" and "java" yields "ya". If either string is length 0, use '@' for its missing char.
     *
     * lastChars("last", "chars") → "ls"
     * lastChars("yo", "java") → "ya"
     * lastChars("hi", "") → "h@"
     *
     * @param a
     * @param b
     * @return
     */
    public String lastChars(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        String resultingString = "";
        if(aLength == 0){
            resultingString = resultingString + '@';
        }
        else {
            resultingString = resultingString + a.charAt(0);
        }
        if(bLength == 0){
            resultingString = resultingString + '@';
        }
        else{
            resultingString = resultingString + b.substring(bLength - 1, bLength);
        }
        return resultingString;
    }
    
    /**
     * Given two strings, append them together (known as "concatenation") and return the result. However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and "cat" yields "abcat".
     *
     * conCat("abc", "cat") → "abcat"
     * conCat("dog", "cat") → "dogcat"
     * conCat("abc", "") → "abc"
     *
     * @param a
     * @param b
     * @return
     */
    public String conCat(String a, String b) {
        if(a.isEmpty()){
            return b;
        }
        String resultingString = a;
        if(b.isEmpty() || (a.endsWith("" + b.charAt(0)) && b.length() == 1)){
            return resultingString;
        }
        else {
            if(a.endsWith("" + b.charAt(0))){
                resultingString += b.substring(1);
            }
            else {
                resultingString += b;
            }
        }
        return resultingString;
    }
    
    /**
     * Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding" yields "codign".
     *
     * lastTwo("coding") → "codign"
     * lastTwo("cat") → "cta"
     * lastTwo("ab") → "ba"
     *
     * @param str
     * @return
     */
    public String lastTwo(String str) {
        if(str.length() < 2){
            return str;
        }
        if(str.length() == 2){
            return "" + str.charAt(1) + str.charAt(0);
        }
        return str.substring(0, str.length() - 2) + str.charAt(str.length() - 1) + str.charAt(str.length() - 2);
    }
    
    /**
     * Given a string, if the string begins with "red" or "blue" return that color string, otherwise return the empty string.
     *
     * seeColor("redxx") → "red"
     * seeColor("xxred") → ""
     * seeColor("blueTimes") → "blue"
     *
     * @param str
     * @return
     */
    public String seeColor(String str) {
        if(str.startsWith("red")){
            return "red";
        }
        else if(str.startsWith("blue")){
            return "blue";
        }
        else{
            return "";
        }
    }
    
    /**
     * Given a string, return true if the first 2 chars in the string also appear at the end of the string, such as with "edited".
     *
     * frontAgain("edited") → true
     * frontAgain("edit") → false
     * frontAgain("ed") → true
     *
     * @param str
     * @return
     */
    public boolean frontAgain(String str) {
        if(str.length() == 2){
            return true;
        }
        else if(str.length() < 2){
            return false;
        }
        return (str.endsWith(str.substring(0,2)));
    }
    
    /**
     * Given two strings, append them together (known as "concatenation") and return the result. However, if the strings are different lengths, omit chars from the longer string so it is the same length as the shorter string. So "Hello" and "Hi" yield "loHi". The strings may be any length.
     *
     * minCat("Hello", "Hi") → "loHi"
     * minCat("Hello", "java") → "ellojava"
     * minCat("java", "Hello") → "javaello"
     *
     * @param a
     * @param b
     * @return
     */
    public String minCat(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        if(aLength * bLength == 0){
            return "";
        }
        
        if(aLength == bLength){
            return a + b;
        }
        int shorter = Math.min(aLength, bLength);
        if(aLength == shorter){
            return a + b.substring(bLength - aLength);
        }
        else{
            return a.substring(aLength - bLength) + b;
        }
    }
    
    /**
     * Given a string, return a new string made of 3 copies of the first 2 chars of the original string. The string may be any length. If there are fewer than 2 chars, use whatever is there.
     *
     * extraFront("Hello") → "HeHeHe"
     * extraFront("ab") → "ababab"
     * extraFront("H") → "HHH"
     *
     * @param str
     * @return
     */
    public String extraFront(String str) {
        if(str.length() < 3){
            return str + str + str;
        }
        String front2 = str.substring(0, 2);
        return front2 + front2 + front2;
    }
    
    /**
     * Given a string, if a length 2 substring appears at both its beginning and end, return a string without the substring at the beginning, so "HelloHe" yields "lloHe". The substring may overlap with itself, so "Hi" yields "". Otherwise, return the original string unchanged.
     *
     * without2("HelloHe") → "lloHe"
     * without2("HelloHi") → "HelloHi"
     * without2("Hi") → ""
     *
     * @param str
     * @return
     */
    public String without2(String str) {
        if(str.length() < 2){
            
            return str;
        }
        if(str.length() == 2){
            return "";
        }
        if(str.endsWith(str.substring(0, 2))){
            return str.substring(2);
        }
        else {
            return str;
        }
    }
    
    /**
     * Given a string, return a version without the first 2 chars. Except keep the first char if it is 'a' and keep the second char if it is 'b'. The string may be any length. Harder than it looks.
     *
     * deFront("Hello") → "llo"
     * deFront("java") → "va"
     * deFront("away") → "aay"
     *
     * @param str
     * @return
     */
    public String deFront(String str) {
        if(str.length() == 0){
            return str;
        }
        String ending = "";
        String firstChar = "";
        String secondChar = "";
        
        if(str.length() == 1){
            if(str.charAt(0) == 'a'){
                firstChar = "a";
            }
        } else {
            if(str.charAt(0) == 'a'){
                firstChar = "a";
            }
            if(str.charAt(1) == 'b'){
                secondChar = "b";
            }
            if(str.length() > 2){
                ending += str.substring(2);
            }
        }
        return "" + firstChar + secondChar + ending;
    }
    
    /**
     * Given a string and a second "word" string, we'll say that the word matches the string if it appears at the front of the string, except its first char does not need to match exactly. On a match, return the front of the string, or otherwise return the empty string. So, so with the string "hippo" the word "hi" returns "hi" and "xip" returns "hip". The word will be at least length 1.
     *
     * startWord("hippo", "hi") → "hi"
     * startWord("hippo", "xip") → "hip"
     * startWord("hippo", "i") → "h"
     *
     * @param str
     * @param word
     * @return
     */
    public String startWord(String str, String word) {
        if(str.isEmpty()){
            return str;
        }
        if(str.length() < word.length()){
            return "";
        }
        if(word.length() == 1){
            return "" + str.charAt(0);
        }
        String potentialFront = str.substring(0, word.length());
        if(potentialFront.substring(1).equals(word.substring(1))){
            return potentialFront;
        }
        else{
            return "";
        }
    }
    
    /**
     * Given a string, if the first or last chars are 'x', return the string without those 'x' chars, and otherwise return the string unchanged.
     *
     * withoutX("xHix") → "Hi"
     * withoutX("xHi") → "Hi"
     * withoutX("Hxix") → "Hxi"
     *
     * @param str
     * @return
     */
    public String withoutX(String str) {
        if(str.isEmpty()){
            return str;
        }
        if(str.length() == 1){
            if("x".equals(str)){
                return "";
            }
            else {
                return str;
            }
        }
        if(str.length() == 2){
            String first = "";
            String last = "";
            if(str.charAt(0) != 'x'){
                first += str.charAt(0);
            }
            if(str.charAt(1) != 'x'){
                last += str.charAt(1);
            }
            return first + last;
        }
        String first = "";
        String middle = str.substring(1, str.length() - 1);
        String last = "";
        if(str.charAt(0) != 'x'){
            first += str.charAt(0);
        }
        if(!str.endsWith("x")){
            last += str.charAt(str.length() - 1);
        }
        return first + middle + last;
    }
    
    /**
     * Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, and otherwise return the string unchanged. This is a little harder than it looks.
     *
     * withoutX2("xHi") → "Hi"
     * withoutX2("Hxi") → "Hi"
     * withoutX2("Hi") → "Hi"
     * 
     * @param str
     * @return
     */
    public String withoutX2(String str) {
        if(str.isEmpty()){
            return str;
        }
        if(str.length() == 1){
            if("x".equals(str)){
                return "";
            }
            else {
                return str;
            }
        }
        if(str.length() == 2){
            String first = "";
            String last = "";
            if(str.charAt(0) != 'x'){
                first += str.charAt(0);
            }
            if(str.charAt(1) != 'x'){
                last += str.charAt(1);
            }
            return first + last;
        }
        String first = "";
        String second = "";
        String theRest = str.substring(2);
        if(str.charAt(0) != 'x'){
            first += str.charAt(0);
        }
        if(str.charAt(1) != 'x'){
            second += str.charAt(1);
        }
        return first + second + theRest;
    }
    
}
