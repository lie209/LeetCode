package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.Stack;

public class LC20 implements LeetCodeBase
{
    public boolean run(String s)
    {
        if((s.length()%2)!=0)
        {
            return false;
        }
        char[] c = s.toCharArray();
        Stack<Character> charStack=new Stack<>();
        for (char ch:c)
        {

            if(ch=='('||ch=='{'||ch=='[')
            {
                charStack.push(ch);
            }
            else
            {
                if(charStack.size() ==0 )
                {
                    return false;
                }
                switch (ch)
                {
                    case ')':
                    {
                        if(charStack.peek() == '(')
                        {
                            charStack.pop();
                        }
                        else
                        {
                            return false;
                        }
                        break;
                    }
                    case '}':
                    {
                        if(charStack.peek() == '{')
                        {
                            charStack.pop();
                        }
                        else
                        {
                            return false;
                        }
                        break;
                    }
                    case ']':
                    {
                        if(charStack.peek() == '[')
                        {
                            charStack.pop();
                        }
                        else
                        {
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        if(charStack.size() !=0 )
        {
            return false;
        }
        return true;
    }

    @Override
    public void test()
    {
        System.out.println(run("){"));
    }
}
