package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import javax.sound.midi.Soundbank;
import java.util.Stack;

public class LC394 implements LeetCodeBase
{
    public String decodeString(String s)
    {
        Stack<Character> stack=new Stack<>();
        char[] chars=s.toCharArray();
        int index=0;
        for (int i=0;i<s.length();i++)
        {
            if(chars[i]!=']')
            {
                stack.push(chars[i]);
            }
            else
            {
                //遇到右括号，则将前面的左括号之前的内容弹出，乘以倍数后弹回去
                String temp="";
                while (!stack.isEmpty()&&stack.peek()!='[')
                {
                    temp=stack.pop()+temp;
                }
                stack.pop();
                String num="";
                while (!stack.isEmpty()&&Character.isDigit(stack.peek()))
                {
                    num=stack.pop()+num;
                }
                int count=Integer.valueOf(num);
                String temp1="";
                for (int k=0;k<count;k++)
                {
                    temp1=temp1+temp;
                }
                for (char c:temp1.toCharArray())
                {
                    stack.push(c);
                }
            }
        }
        String result="";
        while (!stack.isEmpty())
        {
            result=stack.pop()+result;
        }
        return result;
    }
    @Override
    public void test()
    {
//        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));

    }
}
