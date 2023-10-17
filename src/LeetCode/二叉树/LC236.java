package LeetCode.二叉树;

import LeetCode.Base.LeetCodeBase;
import LeetCode.Common.TreeNode;

public class LC236 implements LeetCodeBase
{
    //递归获得所有的前序节点再求交集，部分用例超时
//    HashMap<Integer, Deque<TreeNode>> map=new HashMap<>();
//    TreeNode result=null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
//    {
//        backTrack(root,p.val,q.val,new LinkedList<>());
//        return result;
//    }
//
//    public void backTrack(TreeNode root, int p, int q, Deque<TreeNode> list)
//    {
//        if(result!=null)
//        {
//            return;
//        }
//        if(root==null)
//        {
//            return;
//        }
//        list.addLast(root);
//        map.put(root.val,new LinkedList<>(list));
//
//        if(map.containsKey(p)&&map.containsKey(q))
//        {
//            while (!map.get(p).isEmpty())
//            {
//                TreeNode temp=map.get(p).pollLast();
//                if(map.get(q).contains(temp))
//                {
//                    result=temp;
//                    return;
//                }
//            }
//        }
//        backTrack(root.left,p,q,list);
//        backTrack(root.right,p,q,list);
//        list.remove(root);
//    }

    //分类讨论
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        //返回找到的P或Q的节点
        if(root==p||root==q||root==null)
        {
            return root;
        }
        //左子树中的查找结果
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        //右子树中的查找结果
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //p，q分别在当前节点的左右子树中
        if(left!=null&&right!=null)
        {
            //自身就是最近公共祖先
            return root;
        }
        else
        {
            //情况1：只在左子树中找到了，右子树中没找到，则找到的就是最近公共祖先
            //情况2：只在右子树中找到了p或q，则最近公共祖先就是右边那个节点，不用再往下找了
            //画图即可理解
            return left==null?right:left;
        }
    }
    @Override
    public void test()
    {


    }
}
