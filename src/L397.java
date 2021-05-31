public class L397 {
    // main idea: 1. bfs, using queue, for each #, if its an even,
    // just right shift 1; if its even, add n+1 & n-1 to the queue
    // until we get 1. then the count is the answer
    // 2. recursive: r(n) = Math.min(r(n+1), r(n-1))
    // 3. logical: bit manipulation, see pattern 01 & 11,
    //    if the former -1 will lead to quick answer. However, for the latter
    //    +1 will lead to quick answer. There is a special case, 3, if we
    //    decrement -1, then we will get 2, and then right shift one bit,
    //   then we will get the answer. we only need two steps. However, if
    //   we add one, then it will 4, and two more steps for right shift,
    //   we will need 3 steps.
    // 4. it seems as a dynamic programming, since there are many duplicate
    //    sub-problems. However, n is too large, we cannot use simple dynamic
    //    programming. It will consume too much memory.
    public int integerReplacement(int n) {
        if (n <= 3) { return n-1; }
        if (n == Integer.MAX_VALUE) { return 32; }
        if (n % 2 == 0) { return integerReplacement(n>>1)+1; }
        else if ((n & 3) == 3) {
            //note that we need to make sure there is no overflow
            // for n+1
            return integerReplacement(n+1)+1;
        } else {
            return integerReplacement(n-1)+1;
        }
    }
}
