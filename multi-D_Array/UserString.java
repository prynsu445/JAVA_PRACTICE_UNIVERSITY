import java.util.Scanner;

class UserString {
    
    // a) Count characters [cite: 21]
    int countChars(String s) { return s.length(); }

    // b) Count words [cite: 22]
    int countWords(String s) {
        if (s == null || s.isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }

    // c) Compare strings [cite: 23]
    boolean compare(String s1, String s2) { return s1.equals(s2); }

    // d) Uppercase [cite: 24]
    String toUpper(String s) { return s.toUpperCase(); }

    // e) Lowercase [cite: 25]
    String toLower(String s) { return s.toLowerCase(); }

    // f) Concatenate [cite: 26]
    String concat(String s1, String s2) { return s1.concat(s2); }

    // g) Palindrome check [cite: 27]
    boolean isPalindrome(String s) {
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    // h) Find position [cite: 28]
    int findPos(String s, char c) { return s.indexOf(c); }

    // i) Substring [cite: 29]
    String getSub(String s, int start, int end) { return s.substring(start, end); }

    // j) Search presence [cite: 30]
    boolean containsSub(String s, String sub) { return s.contains(sub); }

    // k) Replace substring [cite: 31]
    String replaceSub(String s, String oldS, String newS) { return s.replace(oldS, newS); }

    // l) Swap substrings between two strings [cite: 32]
    // Note: This logic assumes replacing occurrences in both strings
    void swapSubstrings(String s1, String s2, String sub1, String sub2) {
        String newS1 = s1.replace(sub1, sub2);
        String newS2 = s2.replace(sub2, sub1);
        System.out.println("String 1 after swap: " + newS1);
        System.out.println("String 2 after swap: " + newS2);
    }

    public static void main(String[] args) {
        UserString us = new UserString();
        String test = "Hello World";
        
        System.out.println("Total Chars: " + us.countChars(test)); // [cite: 21]
        System.out.println("Word Count: " + us.countWords(test)); // [cite: 22]
        System.out.println("Is 'radar' palindrome? " + us.isPalindrome("radar")); // [cite: 27]
        System.out.println("Substring (0,5): " + us.getSub(test, 0, 5)); // [cite: 29]
    }
}