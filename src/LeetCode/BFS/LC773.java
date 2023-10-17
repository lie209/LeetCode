package LeetCode.BFS;

import LeetCode.Base.LeetCodeBase;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC773 implements LeetCodeBase
{
    public int slidingPuzzle(int[][] board)
    {
        int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                s.append(board[i][j]);
            }
        }
        Queue<String> queue=new LinkedList<>();
        queue.add(s.toString());
        //使用visited剪枝
        HashSet<String> visited=new HashSet<>();
        String result="123450";
        visited.add(result);
        int step=0;
        while (!queue.isEmpty()) {
            //获得当前一层的在队列中的长度
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                String sq=queue.poll();
                if(sq.equals(result))
                {
                    return step;
                }
                if(visited.contains(sq))
                {
                    continue;
                }
                visited.add(sq);
                int index0=getIndex(sq);
                for (int j:dirs[index0])
                {
                    char[] sc=sq.toCharArray();
                    char temp=sc[j];
                    sc[j]=sc[index0];
                    sc[index0]=temp;
                    String st=new String(sc);
                    queue.add(st);
                }
            }
            step++;
        }
        return -1;
    }


    public int getIndex(String s)
    {
        char[] sc=s.toCharArray();
        for (int i = 0; i < sc.length; i++)
        {
            if(sc[i]=='0')
            {
                return i;
            }

        }
        return -1;
    }
    @Override
    public void test()
    {
        int[][]board =new int[][] {{1,2,3},{4,0,5}};
        System.out.println(slidingPuzzle(board));


    }
}
