public class L121 {
    //main idea 1: greedy method. get minimum so far & then try to
    // sell it in day i, and get max profit of them
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, ans=0;
        for (int price: prices) {
            //#1. get the minimum so far, greedy method
            min=Math.min(min, price);
            //#2. update max value
            ans=Math.max(ans, price-min);
        }
        return ans;
    }

    //main idea 2: for each day i, get its max profit
    //  then get max of each day's max profit
    //Kadane's algorithm
    public int maxProfit2(int[] prices) {
        int currentMax=Integer.MAX_VALUE, max=0;
        for (int i=1; i<prices.length; i++) {
            //#1. max profit if we sell the stock at day i
            //    current max is previous's max plus the difference between
            //    today's stock price & yesterday's stock price
            currentMax=Math.max(0, currentMax+prices[i]-prices[i-1]);
            //#2. update max value
            max=Math.max(max, currentMax);
        }
        return max;
    }
}
