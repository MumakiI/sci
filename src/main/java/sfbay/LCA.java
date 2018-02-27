package sfbay;

/**not passed all tests*/
public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null)
            return null;

        TreeNode fromDeepLeft = lowestCommonAncestor(root.left, p, q);
        if (fromDeepLeft != null)
            return fromDeepLeft;
        TreeNode fromDeepRight = lowestCommonAncestor(root.right, p, q);
        if (fromDeepRight != null)
            return fromDeepRight;

        TreeNode leftContains = contains(root.left, p, q);
        TreeNode rightContains = contains(root.right, p, q);

        if (leftContains!=null && rightContains != null && leftContains.val != rightContains.val)
            return root;
        if (leftContains!=null && rightContains == null
                && ((leftContains.val==p.val && root.val==q.val)
                    ||(leftContains.val==q.val&& root.val==p.val)))
            return root;

        if (leftContains==null && rightContains != null
                && ((rightContains.val==p.val && root.val==q.val)
                ||(rightContains.val==q.val&& root.val==p.val)))
            return root;

        return null;
    }

    public TreeNode contains(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode n = contains(root.left, p, q);
        if (n != null)
            return n;

        n = contains(root.right, p, q);
        if (n != null)
            return n;

        if (root.val==p.val || root.val == q.val)
            return root;
        return null;
    }

    public static void main(String ... a) {
        TreeNode r = new TreeNode(3);

        r.left = new TreeNode(5); r.right = new TreeNode(1);
        r.left.left = new TreeNode(6); r.left.right= new TreeNode(2); r.right.left = new TreeNode(0); r.right.right = new TreeNode(8);

        r.left.right.left = new TreeNode(7); r.left.right.right = new TreeNode(4);

        System.out.println(new LCA_CrackCI().lowestCommonAncestor(r, new TreeNode(5), new TreeNode(1)));

        r = new TreeNode(1);

        r.left = new TreeNode(2); r.right = new TreeNode(3);
        /*r.left.left = new TreeNode(6);*/ r.left.right= new TreeNode(4);

       // r.left.right.left = new TreeNode(7); r.left.right.right = new TreeNode(4);

        System.out.println(new LCA_CrackCI().lowestCommonAncestor(r, new TreeNode(4), new TreeNode(3)));


//                  37,
//                -34,-48,
//                null,-100,-100,48,
//                null,null,null,null,	-54,null,-71,-22,
        r = new TreeNode(37);

        r.left = new TreeNode(-34); r.right = new TreeNode(-48);
        r.left.left = null; r.left.right= new TreeNode(-100); r.right.left = new TreeNode(-100); r.right.right = new TreeNode(48);

        r.right.left.left = new TreeNode(-54); r.right.right.left = new TreeNode(-71);

        System.out.println(new LCA_CrackCI().lowestCommonAncestor(r, new TreeNode(-100), new TreeNode(-71)));


    }

}

class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "{" +
                val +
                '}';
    }
}

class LCA_CrackCI {
    boolean covers(TreeNode root, TreeNode p) {
        if (root==null) return false;
        if (p.val==root.val) return  true;
        return covers(root.left, p)|| covers(root.right, p);
    }

    TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
            return null;
        if (root.val==p.val || root.val==q.val)
            return root;

        boolean isPOnLeft = covers(root.left, p);
        boolean isQOnLeft = covers(root.left, q);

        if (isPOnLeft != isQOnLeft)
            return root;

        TreeNode childSide = isPOnLeft ? root.left : root.right;
        return helper(childSide, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p)||!covers(root,q))
            return null;
        return helper(root, p, q);
    }
}