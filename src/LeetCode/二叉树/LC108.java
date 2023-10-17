package LeetCode.二叉树;

import LeetCode.Common.TreeNode;

public class LC108
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return backTrack(0,nums.length-1,nums);
    }

    public TreeNode backTrack(int start,int end,int[] nums)
    {
        if(start>end)
        {
            return null;
        }
        int mid=(start+end)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=backTrack(start,mid-1,nums);
        node.right=backTrack(mid+1,end,nums);
        return node;
    }

}
