public class L396 {
    //f0=0*a0+1*a1+2*a2+...+(n-1)a(n-1)
    //f1=0*a(n-1)+1*a0+2*a1+...+(n-1)a(n-2)
    //f2=0*a(n-2)+1*a(n-1)+2*a0+...(n-1)a(n-3)
    //f1-f0=a0+a1+...+an-2+an-1-n*a(n-1)
    //f2-f1=a0+a1+...-(n-1)an-2+an-1=a0+...+-a[n-2]
    public int maxRotateFunction(int[] A) {
        int f0=0, sum=0;
        for (int i=0; i<A.length; i++) {
            f0 += i*A[i]; sum += A[i];
        }
        int ans = f0;
        for (int i=1, n=A.length;i<n; i++) {
            //todo: overflow problem
            f0 += sum-n*A[n-i];
            ans = Math.max(ans, f0);
        }
        return ans;
    }
}
