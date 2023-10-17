package LeetCode.数组;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 implements LeetCodeBase
{
    public int[][] merge(int[][] intervals)
    {
        if(intervals.length==1)
        {
            return intervals;
        }
        Arrays.sort(intervals,(int[] a,int[] b)->{return a[0]-b[0];});
        List<int[]> result=new ArrayList<>();
        int i=0,j=1;
        while (i<intervals.length)
        {
            j=i+1;
            int[] temp=intervals[i];
            while (j<intervals.length&&intervals[j][0]<=temp[1]&&intervals[j][0]>=temp[0])
            {
                temp=new int[]{temp[0],Math.max(temp[1],intervals[j][1])};
                j++;
            }
            i=j;
            result.add(temp);
        }
        int[][] res=new int[result.size()][2];
        for (int k=0;k<result.size();k++)
        {
            res[k]=result.get(k);
        }
        return res;
    }
    @Override
    public void test()
    {
        int[][] temp=merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
//        int[][] temp=merge(new int[][]{{1,4},{2,3}});
        for (int[] i:temp)
        {
            System.out.println(i[0]+" "+i[1]);
        }

    }
}
