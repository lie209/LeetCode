package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.Stack;

public class LC921 implements LeetCodeBase
{

    public int run(String s)
    {
        char[] c = s.toCharArray();
        Stack<Character> characterStack=new Stack<>();
        int count = 0;
        for (char ch:c)
        {
            switch (ch)
            {
                case '(':
                {
                    characterStack.push(ch);
                    break;
                }
                case ')':
                {
                    if(!characterStack.isEmpty()&&characterStack.peek() == '(')
                    {
                        characterStack.pop();
                        break;
                    }
                    else
                    {
                        count++;
                        break;
                    }
                }
            }
        }
        count=count+characterStack.size();
        return count;
    }

    @Override
    public void test()
    {
        System.out.println(run("())"));
    }
}
