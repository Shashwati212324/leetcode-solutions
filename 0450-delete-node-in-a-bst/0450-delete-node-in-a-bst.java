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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(key<root.val)root.left = deleteNode(root.left, key);
        if(key>root.val)root.right = deleteNode(root.right, key);

        if(root.val == key){
            if(root.left ==null && root.right ==null) return null;

            if(root.left == null)
                return root.right;
            if(root.right == null){
                return root.left;
            }    

            else{
                TreeNode suc = findMin(root.right);
                root.val = suc.val;
                root.right = deleteNode(root.right, suc.val);
            }
            
        }
        return root;
        
                
    }
    public TreeNode findMin(TreeNode root){
        if(root == null)return null;
        while(root.left!=null)root = root.left;

        return root;
    }
}