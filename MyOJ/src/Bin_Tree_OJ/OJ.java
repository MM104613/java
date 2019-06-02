package Bin_Tree_OJ;

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&t==null){
            return  true;
        }
        if(s != null && t!= null && t.val ==s.val){
           return isSameTree(t,s);
        }
        if(isSameTree(s.left,t)){
            return true;
        }
        if(isSameTree(s.right,t)){
            return true;
        }
        return false;
    }
    private boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null &&q==null){
            return true;
        }
        if(p!=null && q!=null && p.val==q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        else{
            return false;
        }
    }

}
