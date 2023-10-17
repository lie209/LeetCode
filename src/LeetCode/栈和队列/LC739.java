package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.Stack;

public class LC739 implements LeetCodeBase
{
    public int[] run(int[] temperatures)
    {
        Stack<Integer> temStack=new Stack<>();
        temStack.push(0);
        int[] results=new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++)
        {
            if(temperatures[temStack.peek()]<temperatures[i])
            {
                while (!temStack.isEmpty()&&temperatures[temStack.peek()]<temperatures[i])
                {
                    results[temStack.peek()]=i-temStack.peek();
                    temStack.pop();

                }
                temStack.push(i);
            }
            else if(temperatures[temStack.peek()]>=temperatures[i])
            {
                temStack.push(i);
            }
        }
        return results;
    }
    @Override
    public void test()
    {
        for (int i:run(new int[]{30,40,50,60}))
        {
            System.out.println(i);
        }

    }
}
