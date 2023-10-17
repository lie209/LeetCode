package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.awt.font.NumericShaper;

public class LC11 implements LeetCodeBase
{
    public int maxArea(int[] height)
    {
//        暴力法，超时
//        int result=0;
//        for (int i=0;i<height.length;i++)
//        {
//            for (int j=i+1;j<height.length;j++)
//            {
//                result=Math.max((j-i)*Math.min(height[i],height[j]),result);
//            }
//        }
//        return result;

        int result=0;
        int i=0,j=height.length-1;
        while (i<=j)
        {
            result=Math.max(result,Math.min(height[i],height[j])*(j-i));
            if(height[i]<=height[j])
            {
                i++;
            }
            else
            {
                j--;
            }

        }
        return result;
    }
    @Override
    public void test()
    {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

    }
}
