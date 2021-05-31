public class L392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) { return false; }

        int j=0, m=s.length(), n=t.length();
        for (int i=0; i<n&&j<m; i++) {
            if (s.charAt(j)==t.charAt(i)) { j++; }
        }
        return j==m;
    }
}
