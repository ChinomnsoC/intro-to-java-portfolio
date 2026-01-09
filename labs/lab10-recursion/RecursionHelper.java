public class RecursionHelper {
    /**
     * Self Explanation - Remember to detail your base and recursive cases.
     * To reverse the string, we'd be returning the last character + the
     * reverseString of the string minus the last character
     * The base case would then be that if the string length is less than or equal
     * to 1, then we return the string.
     * 
     * @param str Holds current value of String
     * @return Reverse String
     * 
     */
    public String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }

        // Recursive case: last character + reverse of the rest
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    /**
     * Self Explanation - Remember to detail your base and recursive cases. -- it
     * may help to think of these as for/while loops first
     * The base case for this would be that when y = 0, return 1
     * Why, if for the recursion, we return x * pow(x, y - 1), then we'd keep
     * multiplying x by itself, y times.
     * so, x= 2, and y = 3 means that for the first iteration, we'd have 2 * pow(2,
     * 3-1).
     * Second iteration would be 2 * 2 * pow(2, 2-1)
     * Third iteration would be 2 * 2 * 2 * pow(2, 1-1)
     * Fourth iteration, we reach base case, and then we'd have 2 * 2 * 2 * 1
     */
    public int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }

        return x * pow(x, y - 1);
    }

    /**
     * Self Explanation - Remember to detail your base and recursive cases.
     * Base case: empty string or single character is a palindrome
     * The case for being a palindrome is that the first and last characters are the
     * same. If they're not, return false
     * The recursive case is that we'd call the method without the first and last
     * character because we've checked
     * and they are the same.
     * 
     */
    public boolean palindromeChecker(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return palindromeChecker(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        RecursionHelper helper = new RecursionHelper();

        System.out.println("=== Testing RecursionHelper Methods ===\n");

        System.out.println("--- Test 1: reverseString() ---");
        testReverseString(helper, "yield");
        testReverseString(helper, "hello");
        testReverseString(helper, "a");
        testReverseString(helper, "");
        testReverseString(helper, "racecar");
        System.out.println();

        System.out.println("--- Test 2: pow() ---");
        testPow(helper, 2, 3);
        testPow(helper, 5, 2);
        testPow(helper, 10, 0);
        testPow(helper, 3, 4);
        testPow(helper, 7, 1);
        testPow(helper, 2, 10);
        System.out.println();

        System.out.println("--- Test 3: palindromeChecker() ---");
        testPalindrome(helper, "tacocat");
        testPalindrome(helper, "sponge");
        testPalindrome(helper, "racecar");
        testPalindrome(helper, "level");
        testPalindrome(helper, "hello");
        testPalindrome(helper, "a");
        testPalindrome(helper, "aa");
        testPalindrome(helper, "ab");
        System.out.println();

        System.out.println("=== All Tests Complete ===");
    }

    private static void testReverseString(RecursionHelper helper, String input) {
        String result = helper.reverseString(input);
        System.out.println("reverseString(\"" + input + "\") = \"" + result + "\"");
    }

    private static void testPow(RecursionHelper helper, int x, int y) {
        int result = helper.pow(x, y);
        System.out.println("pow(" + x + ", " + y + ") = " + result);
    }

    private static void testPalindrome(RecursionHelper helper, String input) {
        boolean result = helper.palindromeChecker(input);
        System.out.println("palindromeChecker(\"" + input + "\") = " + result);
    }
}
