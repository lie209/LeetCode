package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

public class JZO65 implements LeetCodeBase
{
    public int add(int a, int b)
    {
        //j将加法拆分成两个部分：无进位和与进位值之间的加法
        if(b==0)
        {
            return a;
        }
        return add(a^b,(a&b)<<1);
    }
    @Override
    public void test()
    {
        System.out.println(add(12,200));

    }
}
