package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;
import java.util.Stack;

public class LC316 implements LeetCodeBase
{
    public String run(String s)
    {
        int len=s.length();
        //记录该字母最后出现的位置
        HashMap<Character,Integer> hashMap=new HashMap<>();
        char[] chars=s.toCharArray();

        for (int i = 0; i < len; i++)
        {
            if(hashMap.containsKey(chars[i]))
            {
                hashMap.replace(chars[i],i);
            }
            else
            {
                hashMap.put(chars[i],i);
            }
        }
        Stack<Character> stack=new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < len; i++)
        {
            if(stack.contains(chars[i]))
            {
                continue;
            }
            while (!stack.isEmpty()&&chars[i]<stack.peek()&&hashMap.get(stack.peek())>i)
            {
                stack.pop();
            }
            stack.push(chars[i]);
        }
        char[] result=new char[stack.size()];
        int i=stack.size()-1;
        while (!stack.isEmpty())
        {
            result[i]=stack.pop();
            i--;
        }
        return String.valueOf(result);
    }
    @Override
    public void test() {
        System.out.println(run("abacb"));
    }
}
