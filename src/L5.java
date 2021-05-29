public class L5 {
    //manchers's algorithm, get all odd palindromes & even palindromes
    // At the same time, we get the palindrome with max length
    int start, max;
    public String longestPalindrome(String s) {
        if (s.length() <= 1) { return s; }
        start=0; max = 1;
        char[] a = s.toCharArray();
        odd(a); even(a);
        return s.substring(start, start+max);
    }

    void odd(char[] a) {
        int[] d1 = new int[a.length];
        for (int i=0, l=0, r=-1; i<a.length; i++) {
            int k=(i>=r)?1: Math.min(r-i+1, d1[l+r-i]);
            while(i-k>=0 && i+k<a.length && a[i-k]==a[i+k]) {
                k++;
            }
            d1[i] = k--;
            if (i+k > r) { l = i-k; r = i+k; }
            if (2*k+1 > max) { max = 2*k+1; start = l; }
        }
    }

    void even(char[] a) {
        int[] d2 = new int[a.length];
        for (int i=0, l=0, r=-1; i<a.length; i++) {
            int k=(i>=r)?0: Math.min(r-i+1, d2[l+r-i+1]);
            while(i-k-1>=0 && i+k<a.length && a[i-k-1]==a[i+k]) {
                k++;
            }
            d2[i] = k--;
            if (i+k > r) { l=i-k-1; r=i+k; }
            if (2*k+2 > max) { max = 2*k+2; start = l; }
        }
    }

    public static void main(String[] args) {
        L5 sol = new L5();
        String s="aaaaaa";
        System.out.print(sol.longestPalindrome(s));
    }

}


//brute forece approach
//int start, max;
//    public String longestPalindrome(String s) {
//        if (s.length() <= 1) { return s; }
//        start=0; max =1;
//        for (int i=0; i<s.length(); i++) {
//            findPalindrome(s, i, i);
//            findPalindrome(s, i, i+1);
//        }
//        return s.substring(start, start+max);
//    }
//
//    void findPalindrome(String s, int i, int j) {
//        for (; i>=0 && j<s.length() && s.charAt(i)==s.charAt(j);
//             i--, j++) {
//        }
//        if (max < j-i-1) { max = j-i-1; start=i+1; }
//    }
