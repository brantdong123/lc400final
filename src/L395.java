public class L395 {
    //main idea:
    // 1. first get the cnt of all characters
    // 2. then character with less than k is a boundary
    // 3. do recursion until length is zero, or all characters cnt
    //    are greater than or equal to k
    int ans;
    public int longestSubstring(String s, int k) {
        if (s.length() < k) { return 0; }
        char[] a=s.toCharArray();

        ans = 0;
        helper(a, 0, a.length, k);
        return ans;
    }

    void helper(char[] a, int from, int to, int k) {
        //#1. branch & bound
        int n = to-from;
        if (n < Math.max(ans+1, k)) { return; }

        //#2. get character cnt
        int[] cnt = new int[26];
        for (int i=from; i<to; i++) { cnt[a[i]-'a']++; }

        boolean hasBoundary = false; //this flag means we have no boundary
        for (int i=from; i<to; i++) {
            if (cnt[a[i]-'a'] < k) {
                hasBoundary = true;
                //#3. split it into more segments
                helper(a, from, i, k);
                from = i+1;
            }
        }
        if (!hasBoundary) { ans = Math.max(ans, n); }
        else { helper(a, from, to, k); }
    }

    //main idea 2: sliding window, for each # of character in the window
    // do sliding window algorithm
}
