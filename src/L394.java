import java.util.ArrayDeque;
import java.util.Deque;

public class L394 {
    public String decodeString(String s) {
        Deque<StringBuilder> st = new ArrayDeque<>();
        //#0. push a dummy string builder, consider use case: 3[a]
        st.push(new StringBuilder());

        for (int i=0; i<s.length(); i++) {
            //#case 1: if its a digit, we append the digit or new a digit buff
            if (Character.isDigit(s.charAt(i))) {
                if (st.peek().length()== 0 || !Character.isDigit(st.peek().charAt(0))) {
                    st.push(new StringBuilder());
                }
                st.peek().append(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                //#case 2: start of a new string, new a buffer
                st.push(new StringBuilder());
            } else if (s.charAt(i) == ']') {
                //case 3: the end of string, pop the string & number
                // & combine them & append to the parent
                StringBuilder tmp = st.pop();
                int cnt = Integer.parseInt(st.pop().toString());
                for (int j=0; j<cnt; j++) {
                    st.peek().append(tmp);
                }
            } else {
                //case 4: it's a character
                st.peek().append(s.charAt(i));
            }
        }
        return st.pop().toString();
    }
}
