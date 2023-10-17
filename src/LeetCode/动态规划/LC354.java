package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;

public class LC354 implements LeetCodeBase
{
    public int maxEnvelopes(int[][] envelopes)
    {
        //以下方法部分测试用例未通过===============
//        int m=0,n=0;
//        //获得dp数组的长度和宽度
//        for (int i=0;i<envelopes.length;i++)
//        {
//            m=Math.max(m,envelopes[i][0]);
//            n=Math.max(n,envelopes[i][1]);
//        }

//        int[][] dp=new int[m+1][n+1];
//
//
//        for (int[] i:envelopes)
//        {
//            dp[i[0]][i[1]]=1;
//        }
//
//        for (int i=1;i<m+1;i++)
//        {
//            for (int j=1;j<n+1;j++)
//            {
//                int max=0;
//                for(int k=1;k<i;k++)
//                {
//                    max=Math.max(max,dp[k][j-1]);
//                }
//                for (int k=1;k<j;k++)
//                {
//                    max=Math.max(max,dp[i-1][k]);
//                }
//                dp[i][j]=dp[i][j]+max;
//            }
//        }
//
//        return dp[m][n];

        //先按照第0个元素进行升序排序，遇到第0个元素相同的情况下，按照降序排列
        if(envelopes.length==1)
        {
            return 1;
        }
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] dp=new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++)
        {
            dp[i]=envelopes[i][1];
        }
        return getMaxLength(dp);
    }

    public int getMaxLength(int[] nums)
    {
        int[] cell=new int[nums.length];
        cell[0]=nums[0];
        //要插入的点的索引
        int res=1;
        for (int i=1;i<nums.length;i++)
        {
            if(nums[i]>cell[res-1])
            {
                cell[res]=nums[i];
                res++;
            }
            else
            {
                //将当前元素与cell中比当前元素大的第一个元素进行交换
                int index=Arrays.binarySearch(cell,0,res,nums[i]);
                if(index<0)
                {
                    int index1=-index-1;
                    cell[index1]=nums[i];
                }
            }
        }
        return res;
    }




    @Override
    public void test() {
        System.out.println(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
//        System.out.println(maxEnvelopes(new int[][]{{1,1},{1,1},{1,1},{1,1}}));
//        System.out.println(maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
//        System.out.println(getMaxLength(new int[]{10,9,2,5,3,7,101,18}));
    }
}
