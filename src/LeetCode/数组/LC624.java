package LeetCode.数组;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC624 implements LeetCodeBase {


    public int maxDistance(List<List<Integer>> arrays)
    {
        int[] maxValue=new int[2];
        maxValue[0]=Integer.MIN_VALUE;
        maxValue[1]=0;
        int[] secondMaxValue=new int[2];
        secondMaxValue[0]=Integer.MIN_VALUE;
        secondMaxValue[1]=0;
        int[] minValue=new int[2];
        minValue[0]=Integer.MAX_VALUE;
        minValue[1]=0;
        int[] secondMinValue=new int[2];
        secondMinValue[0]=Integer.MAX_VALUE;
        secondMinValue[1]=-1;
        for (int i=0;i<arrays.size();i++)
        {
            List<Integer> cur=arrays.get(i);
            int min=cur.get(0);
            int max=cur.get(cur.size()-1);
            if(min<minValue[0])
            {
                secondMaxValue[0]=minValue[0];
                secondMaxValue[1]=minValue[1];
                minValue[0]=min;
                minValue[1]=i;
            }
            else if(min<secondMinValue[0]&&min>minValue[0]&&secondMinValue[0]==Integer.MAX_VALUE)
            {
                secondMinValue[0]=min;
                secondMinValue[1]=i;
            }
            if(max>maxValue[0])
            {
                secondMaxValue[0]=maxValue[0];
                secondMaxValue[1]=maxValue[1];
                maxValue[0]=max;
                maxValue[1]=i;
            }
            else if (max>secondMaxValue[0]&&max<maxValue[0])
            {
                secondMaxValue[0]=max;
                secondMaxValue[1]=i;
            }
        }
        if(maxValue[1]!=minValue[1])
        {
            return maxValue[0]-minValue[0];
        }
        else
        {
            if (secondMinValue[0]!=Integer.MAX_VALUE)
            {
                return Math.max(maxValue[0]-secondMinValue[0],secondMaxValue[0]-minValue[0]);
            }
            return Math.abs(arrays.get(0).get(0)-arrays.get(1).get(0));

        }
    }

    @Override
    public void test()
    {
        List<Integer> list1=new ArrayList<>(Arrays.asList(1,4));
        List<Integer> list2=new ArrayList<>(Arrays.asList(0,5));
        List<List<Integer>> list=new ArrayList<>(Arrays.asList(list1,list2));
        System.out.println(maxDistance(list));
    }
}
