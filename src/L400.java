public class L400 {
    public int findNthDigit(int n) {
        // The integer sequence is as following: 1-9, 10-99, 100-999, ...
        // so the number of digits is 9, 90*2, 900*3, 9000*4, ....
        // i.e 9*1, 9*20, 9*300, .....
        // so the main idea is first get the base, then get the specific digit

        //#1. get the base
        //int base = 1, cnt = 9, i = 1;
        long base = 1, cnt = 9, i = 1;
        //Note that, there will be overflow, so need to check if cnt > 0
        // or we can use a long type cnt
        while (n > cnt && cnt > 0) {
            n -= cnt;
            base *= 10;
            i++;
            cnt = base*i*9;
        }

        //#2. get the specific #
        base += (n-1)/i;

        //#3. get the specific digit, the (n-1)%i th digit from left to right
        // i-1-(n-i)%i digit from right to left
        i = i-1-(n-1)%i ;
        for (int j=0; j<i; j++) { base /= 10; }
        return (int)base%10;
    }

    public static void main(String[] args) {
        L400 sol = new L400();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(sol.findNthDigit(Integer.MAX_VALUE-1));
    }
}


//int ans=1, i=1;
//        for(int cnt=9;n-cnt>0 && cnt>0; n-=cnt, ans*=10, i++, cnt=i*ans*9) {}
//
//        //1000+13, 1000, 1001, 1002, 1003, 1004
//        ans += (n-1)/i; n=(n-1)%i; //suppose n=1, 2, 3, 4
//        for (i=i-n; i>1; i--) { ans /= 10; }
//        return ans%10;