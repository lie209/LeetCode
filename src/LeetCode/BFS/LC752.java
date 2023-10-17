package LeetCode.BFS;

import LeetCode.Base.LeetCodeBase;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC752 implements LeetCodeBase
{
    public int openLock(String[] deadends, String target)
    {

//        Queue<String> queue = new LinkedList<>();
//        Set<String> deadSet=new HashSet<>();
//        for (String s : deadends)
//            deadSet.add(s);
//        queue.offer("0000");
//        //剪枝，避免回头路
//        HashSet<String> visited=new HashSet<>();
//        visited.add("0000");
//        int depth=0;
//        while (!queue.isEmpty())
//        {
//            int size=queue.size();
//            for (int i = 0; i < size; i++)
//            {
//                String cur=queue.poll();
//                if(deadSet.contains(cur))
//                {
//                    continue;
//                }
//                if(cur.equals(target))
//                {
//                    return depth;
//                }
//                for (int j = 0; j < 4; j++)
//                {
//                    String plusOne=plusOne(cur,j);
//                    String minusOne=minusOne(cur,j);
//                    if(!visited.contains(plusOne))
//                    {
//                        visited.add(plusOne);
//                        queue.offer(plusOne);
//                    }
//                    if(!visited.contains(minusOne))
//                    {
//                        visited.add(minusOne);
//                        queue.offer(minusOne);
//                    }
//                }
//            }
//            depth++;
//        }
//        return -1;

        Queue<String> queue1=new LinkedList<>();
        Queue<String> queue2=new LinkedList<>();
        Set<String> visited1=new HashSet<>();
        Set<String> visited2=new HashSet<>();
        Set<String> deadSets=new HashSet<>();
        for (String i:deadends)
        {
            deadSets.add(i);
        }
        queue1.offer("0000");
        queue2.offer(target);
        visited1.add("0000");
        visited2.add(target);
        int depth1=0;
        int depth2=0;
        while (!queue1.isEmpty()&&!queue2.isEmpty()) {
            int size1 = queue1.size();
            int size2 = queue2.size();

            for (int i = 0; i < size1; i++) {
                String curr = queue1.poll();
                if (deadSets.contains(curr)) {
                    continue;
                }
                if (queue2.contains(curr)) {
                    return depth1 + depth2;
                }
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(curr, j);
                    if (!visited1.contains(plusOne)) {
                        queue1.offer(plusOne);
                        visited1.add(plusOne);
                    }
                    String minusOne = minusOne(curr, j);
                    if (!visited1.contains(minusOne)) {
                        queue1.offer(minusOne);
                        visited1.add(minusOne);
                    }
                }
            }
            depth1++;
            for(int i=0;i<size2;i++)
            {
                String curr=queue2.poll();
                if(deadSets.contains(curr))
                {
                    continue;
                }
                for (int j = 0; j < 4; j++)
                {
                    String plusOne = plusOne(curr, j);
                    if (!visited2.contains(plusOne)) {
                        queue2.offer(plusOne);
                        visited2.add(plusOne);
                    }
                    String minusOne = minusOne(curr, j);
                    if (!visited2.contains(minusOne)) {
                        queue2.offer(minusOne);
                        visited2.add(minusOne);
                    }
                }
            }
            depth2++;
        }

        return -1;
    }

    public String plusOne(String s,int i)
    {
        char[] sc=s.toCharArray();
        if(sc[i]=='9')
            sc[i]='0';
        else
            sc[i]=(char)(sc[i]+1);
        return new String(sc);
    }
    public String minusOne(String s,int i)
    {
        char[] sc=s.toCharArray();
        if(sc[i]=='0')
            sc[i]='9';
        else
            sc[i]=(char)(sc[i]-1);
        return new String(sc);
    }




    @Override
    public void test()
    {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }
}
