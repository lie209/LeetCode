package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC870 implements LeetCodeBase
{

    public int[] run(int[] nums1,int[] nums2)
    {
        //创建一个从大到小的优先级队列
        PriorityQueue<int[]> maxNums2=new PriorityQueue<>((int[] pairs1,int[] pairs2)->{
            return pairs2[1]-pairs1[1];
        });
        for (int i = 0; i < nums2.length; i++)
        {
            maxNums2.offer(new int[]{i,nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0,right = nums1.length-1;
        while (left<=right)
        {
            int[] currentNums2=maxNums2.poll();
            if(nums1[right]>currentNums2[1])
            {
                nums2[currentNums2[0]]=nums1[right];
                right--;
            }
            else
            {
                nums2[currentNums2[0]]=nums1[left];
                left++;
            }
        }
        return nums2;
    }
    @Override
    public void test()
    {
        int[] result = run(new int[]{12,24,8,32}, new int[]{13,25,32,11});
        for (int i:result)
        {
            System.out.println(i);
        }

    }
}
