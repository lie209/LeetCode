package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

public class LC50 implements LeetCodeBase
{
    public double myPow(double x, int n)
    {
        //转换为long是因为测试用例有大于int范围的数
        long N=n;
        if(x==0||x==1)
        {
            return x;
        }
        if(N==0)
        {
            return 1;
        }
        N=N>0?N:-N;
        return n>0?getResult(x,N):1.0/getResult(x,N);
    }
    public double getResult(double x ,long N)
    {
        if(N==0)
        {
            return 1;
        }
        double temp=getResult(x,N/2);
        return N%2==0?temp*temp:temp*temp*x;
    }
    @Override
    public void test()
    {
        System.out.println(myPow(2.000, -2));

    }
}
