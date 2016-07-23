package com.company;

public class Main {

    public static void main(String[] args) {
        String str1 = "BACDGABCDA";
        String str2 = "ABCD";
        hasAnagramSubstring(str1, str2);
    }

    public static void hasAnagramSubstring(String txt, String patt) {
        int countTXT[] = new int[128];
        int countPATT[] = new int[128];

        for (int i = 0; i < patt.length(); i++) {
            countTXT[txt.charAt(i)]++;
            countPATT[patt.charAt(i)]++;
        }

        for (int i = patt.length(); i < txt.length(); i++) {
            if (compareArr(countTXT, countPATT) == true)
                System.out.print((i - patt.length()) + " ");

            countTXT[txt.charAt(i)]++;
            countTXT[txt.charAt(i - patt.length())]--;
        }

        if (compareArr(countTXT, countPATT) == true) {
            System.out.print((txt.length() - patt.length()) + " ");
        }
    }

    static boolean compareArr(int[] countTXT, int[] countPATT) {
        for (int i = 0; i < countTXT.length; i++) {
            if (countTXT[i] != countPATT[i])
                return false;
        }
        return true;
    }

}