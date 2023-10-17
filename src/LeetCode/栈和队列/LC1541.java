package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.Stack;

public class LC1541 implements LeetCodeBase
{
    //栈里面一个左括号遇到两个右括号才弹出
    public int run(String s)
    {
        if(s.length()==1)
        {
            return 2;
        }
        char[] c=s.toCharArray();
        Stack<Character> characterStack=new Stack<>();
        int count = 0;
        for (int i = 0;i<s.length();i++)
        {
            char ch=c[i];
            switch (ch)
            {
                case '(':
                {
                    characterStack.push(ch);
                    break;
                }
                case ')':
                {
                    if(characterStack.isEmpty())
                    {
                        count++;
                    }
                    else
                    {
                        characterStack.pop();
                    }
                    if(i+1<s.length())
                    {
                        switch (c[i+1])
                        {
                            case ')':
                            {
                                i=i+1;
                                break;
                            }
                            case '(':
                            {
                                count++;
                                break;
                            }
                        }
                    }
                    else
                    {
                        count++;
                    }

                }

            }
        }
        return count+characterStack.size()*2;
    }
    @Override
    public void test()
    {
        System.out.println(run("(()))"));

    }
}
