package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC17 implements LeetCodeBase
{
    List<String> result=new ArrayList<>();
    HashMap<Character, String> map=new HashMap<>();
    public List<String> letterCombinations(String digits)
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put( '4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put( '9', "wxyz");
        backTrack(digits.toCharArray(),0, new StringBuilder());
        return result;
    }

    public void backTrack(char[] digits,int index,StringBuilder list)
    {
        if(list.length()==digits.length)
        {
            result.add(list.toString());
            return;
        }
        String letters=map.get(digits[index]);
        for (int i=0;i<letters.length();i++)
        {
            list.append(letters.charAt(i));
            backTrack(digits,index+1,list);
            list.deleteCharAt(list.length()-1);
        }
    }


    @Override
    public void test()
    {
        System.out.println(letterCombinations("2"));
    }
}
