package level2;

// This class checks whether a given string is palindrome using constructor

class CheckPalindrome {

    String text;

    // Parameterized Constructor
    CheckPalindrome(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String rev = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            rev += text.charAt(i);
        }
        return text.equals(rev);
    }

    void displayResult() {
        if (isPalindrome())
            System.out.println("Palindrome String");
        else
            System.out.println("Not Palindrome");
    }

    public static void main(String[] args) {
        CheckPalindrome p = new CheckPalindrome("madam");
        p.displayResult();
    }
}

