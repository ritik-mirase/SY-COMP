package Puzzle;

import java.util.Scanner;

public class TextTransformer {

    // 1. Uppercase
    public static String upper(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] = (char)(ch[i] - 32);
            }
        }
        return new String(ch);
    }

    // 2. Lowercase
    public static String lower(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] + 32);
            }
        }
        return new String(ch);
    }

    // 3. Reverse
    public static String reverse(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;

        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }

    // 4. Compare
    public static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // 5. Extract digits
    public static void digits(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result += ch;
            }
        }
        System.out.println("Digits: " + result);
    }

    // 6. Count words
    public static void countWords(String s) {
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println("Words: " + count);
    }

    // 7. Substring
    public static void substring(String s, String sub) {
        boolean found = false;

        for (int i = 0; i <= s.length() - sub.length(); i++) {
            int j;

            for (j = 0; j < sub.length(); j++) {
                if (s.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }

            if (j == sub.length()) {
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }

    // 8. Replace
    public static String replace(String s, char oldc, char newc) {
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == oldc) {
                ch[i] = newc;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1. Upper\n2. Lower\n3. Reverse\n4. Compare\n5. Digits\n6. Words\n7. Substring\n8. Replace\n9. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.println(upper(sc.nextLine()));
                    break;

                case 2:
                    System.out.println(lower(sc.nextLine()));
                    break;

                case 3:
                    System.out.println(reverse(sc.nextLine()));
                    break;

                case 4:
                    String a = sc.nextLine();
                    String b = sc.nextLine();
                    System.out.println(compare(a, b));
                    break;

                case 5:
                    digits(sc.nextLine());
                    break;

                case 6:
                    countWords(sc.nextLine());
                    break;

                case 7:
                    String s = sc.nextLine();
                    String sub = sc.nextLine();
                    substring(s, sub);
                    break;

                case 8:
                    String text = sc.nextLine();
                    char o = sc.next().charAt(0);
                    char n = sc.next().charAt(0);
                    System.out.println(replace(text, o, n));
                    break;
            }

        } while (ch != 9);
    }
}

