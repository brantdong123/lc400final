public class L124 {
    // we can apply algorithm similar to Kadane's algorthm.
    // for every node, we check its max path sum & right path sum
    // and combine them to get current max at this root.
    // At the same, we update max path sum from the current node
    // return the result to the parent.
    // So we can see it as a bottom-up approach
    public int maxPathSum(TreeNode root) {
        return 0;
    }
}
