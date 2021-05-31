import java.util.Random;

public class L398 {
    Random r = new Random();
    int[] a;
    public L398(int[] nums) {
        a = nums;
    }

    public int pick(int target) {
        int cnt=0, index=0;
        for (int i=0; i<a.length; i++) {
            if (a[i] != target) { continue; }
            if (r.nextInt(++cnt) == 0) { index = i; }
        }
        return index;
    }
}
