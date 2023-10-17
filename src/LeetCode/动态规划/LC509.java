package LeetCode.动态规划;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;

public class LC509 implements LeetCodeBase
{
    HashMap<Integer,Integer> map=new HashMap<>();
    public int fib(int n)
    {
//        if(n==0||n==1)
//        {
//            return n;
//        }
//        if(map.containsKey(n))
//        {
//            return  map.get(n);
//        }
//        int result=fib(n-1)+fib(n-2);
//        map.put(n,result);
//        return  result;

        int result0=0;
        int result1=1;
        int result2=1;
        int i=3;
        while (i<=n)
        {
            result0=result1;
            result1=result2;
            result2=result0+result1;
            i++;
        }
        return result2;
    }

    @Override
    public void test()
    {
        System.out.println(fib(3));

    }
}
