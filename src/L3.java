public class L3 {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256];
        int ans = 0, j=1;
        // j from position, 1 based index
        for (int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            //the window's property is violated
            if (lastIndex[c] >= j) {
                ans = Math.max(ans, i+1-j);
                j = lastIndex[c]+1;  //shrink the window
            }
            lastIndex[c] = i+1;
        }
        //the last one
        return Math.max(ans, s.length()-j+1);
    }
}
