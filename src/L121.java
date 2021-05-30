public class L121 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, ans=0;
        for (int price: prices) {
            //#1. get the minimum so far
            min=Math.min(min, price);
            //#2. update max value
            ans=Math.max(ans, price-min);
        }
        return ans;
    }
}
