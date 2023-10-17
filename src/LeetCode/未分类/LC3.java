package LeetCode.未分类;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;
import java.util.Hashtable;

public class LC3 implements LeetCodeBase
{
    public int run(String s)
    {
        if(s.length()==0)
        {
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int left = 0,right = 0;
        int res=Integer.MIN_VALUE;
        while (right <s.length())
        {
            char current=s.charAt(right);
            if(!map.containsKey(current))
            {
                map.put(current, 1);
            }
            else
            {
                map.replace(current, map.get(current)+1);
            }
            while (map.get(current)>1)
            {
                char currentLeft=s.charAt(left);
                map.replace(currentLeft, map.get(currentLeft)-1 );
                left++;
            }
            res=res<right-left+1?right-left+1:res;
            right++;
        }
        return res;
    }

    @Override
    public void test() {
        System.out.println(run("bbbb"));
    }
}
