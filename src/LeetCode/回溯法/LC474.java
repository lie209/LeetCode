package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

public class LC474 implements LeetCodeBase
{

    public int findMaxForm(String[] strs, int m, int n)
    {
        int[] zeronums=new int[strs.length];
        int[] onenums=new int[strs.length];
        for (int i=0;i<strs.length;i++)
        {
            String s=strs[i];
            int count0=0;
            int count1=0;
            char[] chars=s.toCharArray();
            for (char c:chars)
            {
                if(c=='0')
                {
                    count0++;
                }
                else
                {
                    count1++;
                }
            }
            zeronums[i]=count0;
            onenums[i]=count1;
        }
        //装满m个0和n个1背包的物品最大数量（或者说每个物品价值都为1的最大价值）
        int[][] dp=new int[m+1][n+1];
        for (int i=0;i<strs.length;i++)
        {
            for (int j=m;j>=zeronums[i];j--)
            {
                for (int k=n;k>=onenums[i];k--)
                {
                    dp[j][k]=Math.max(dp[j][k],dp[j-zeronums[i]][k-onenums[i]]+1);
                }

            }
        }
        return dp[m][n];
    }

    @Override
    public void test() {
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"},3,4));
        System.out.println(findMaxForm(new String[]{"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0","0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"},9,80));
    }
}
