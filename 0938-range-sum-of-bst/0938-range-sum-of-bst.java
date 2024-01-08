/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
    
        return traverse(root,low,high);
        
    }

    public int traverse(TreeNode root, int low, int high){
        if(root==null)
        return 0;
        
        if(root.val>=low && root.val<=high)
        return root.val + traverse(root.left,low,high) + traverse(root.right,low,high);

        if(root.val<low)
        return traverse(root.right,low,high);

        if(root.val>high)
        return traverse(root.left,low,high);

        return 1; 
    }
}