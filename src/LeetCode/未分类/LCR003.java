package LeetCode.未分类;

public class LCR003
{
    public int[] countBits(int n)
    {
        int[] result=new int[n+1];
        for (int i=0;i<=n;i++)
        {
            String binaryString=Integer.toBinaryString(i);
            char[] chars=binaryString.toCharArray();
            int count=0;
            for (char c:chars)
            {
                if(c=='1')
                {
                    count++;
                }
            }
            result[i]=count;
        }
        return result;
    }
}
