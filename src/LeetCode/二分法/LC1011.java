package LeetCode.二分法;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;

public class LC1011 implements LeetCodeBase
{
    public int run(int[] weights,int days)
    {
        int maxWeight=0,sum = 0;
        for (int i = 0; i < weights.length; i++)
        {
            maxWeight=weights[i]>maxWeight?weights[i]:maxWeight;
            sum=sum+weights[i];
        }
        int left = Math.max(maxWeight, sum/days);
        int right = sum;
        int result = right;
        while (left<right)
        {
            int weight=(left+right)/2;
            int day=1;
            int index=0;
            int currentWeight=0;
            while (index < weights.length)
            {
                if(currentWeight+weights[index]<=weight)
                {
                    currentWeight=currentWeight+weights[index];
                    index++;
                }
                else
                {
                    currentWeight=weights[index];
                    day++;
                    index++;
                }
            }
            if(day<=days)
            {
                right=weight;
                result=weight;
            }
            else if (day>days)
            {
                left=left+1;
            }
        }
        return result;
    }

    @Override
    public void test()
    {
        System.out.println(run(new int[]{1,2,3,4,5,6,7,8,9,10},
        1));

    }
}
