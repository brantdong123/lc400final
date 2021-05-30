public class L123 {
    // main idea: dynamic programming
    // for each stock i, we have 4 choices:
    // 1. sell for the 2nd time
    // 2. buy for the 2nd time
    // 3. sell for the 1st time
    // 4. buy for the 1st time
    // The 2nd sell must be based on previous 2nd buy.
    // The 2nd buy must be based on previous 1st sell
    // The 1st sell must be based on previous 1st sell
    // the 1st buy don't need to based on anything
    // the corner case: buy1 & buy2 equal to Integer.MIN_VALUE
    public int maxProfit(int[] prices) {
        int buy1=Integer.MIN_VALUE, buy2=Integer.MIN_VALUE,
                sell1=0, sell2=0;

        for(int i: prices) {
            sell2 = Math.max(sell2, buy2+i);
            buy2 = Math.max(buy2, sell1-i);
            sell1 = Math.max(sell1, buy1+i);
            buy1 = Math.max(buy1, -i);
        }
        return sell2;
    }
}