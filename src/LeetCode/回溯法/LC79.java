package LeetCode.回溯法;

import LeetCode.Base.LeetCodeBase;

import java.util.Arrays;

public class LC79 implements LeetCodeBase
{
    int[][] visited;
    boolean result=false;
    public boolean exist(char[][] board, String word)
    {
        visited=new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                if(result)
                {
                    return result;
                }
                visited=new int[board.length][board[0].length];
                backTrack2(board,"",word,i,j);

            }
        }
        return result;

    }

//    public void backTrack1(char[][] board,String cur,String target,int indexI,int indexJ)
//    {
//        if(result)
//        {
//            return;
//        }
//        if(cur.equals(target))
//        {
//            result=true;
//            return;
//        }
//        if(indexI-1>=0&&visited[indexI-1][indexJ]==0&&board[indexI-1][indexJ]==target.charAt(cur.length()))
//        {
//            visited[indexI-1][indexJ]=1;
//            backTrack(board,cur+board[indexI-1][indexJ],target,indexI-1,indexJ);
//            visited[indexI-1][indexJ]=0;
//        }
//        if(indexJ-1>=0&&visited[indexI][indexJ-1]==0&&board[indexI][indexJ-1]==target.charAt(cur.length()))
//        {
//            visited[indexI][indexJ-1]=1;
//            backTrack(board,cur+board[indexI][indexJ-1],target,indexI,indexJ-1);
//            visited[indexI][indexJ-1]=0;
//        }
//        if(indexI+1<board.length&&visited[indexI+1][indexJ]==0&&board[indexI+1][indexJ]==target.charAt(cur.length()))
//        {
//            visited[indexI+1][indexJ]=1;
//            backTrack(board,cur+board[indexI+1][indexJ],target,indexI+1,indexJ);
//            visited[indexI+1][indexJ]=0;
//        }
//        if(indexJ+1<board[0].length&&visited[indexI][indexJ+1]==0&&board[indexI][indexJ+1]==target.charAt(cur.length()))
//        {
//            visited[indexI][indexJ+1]=1;
//            backTrack(board,cur+board[indexI][indexJ+1],target,indexI,indexJ+1);
//            visited[indexI][indexJ+1]=0;
//        }
//    }

    public void backTrack2(char[][] board,String cur,String target,int i,int j)
    {
        if(result)
        {
            return;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=target.charAt(cur.length())||visited[i][j]==1)
        {
            return;
        }
        if((cur+board[i][j]).equals(target))
        {
            result=true;
            return;
        }
        visited[i][j]=1;
        backTrack2(board,cur+board[i][j],target,i-1,j);
        backTrack2(board,cur+board[i][j],target,i,j-1);
        backTrack2(board,cur+board[i][j],target,i+1,j);
        backTrack2(board,cur+board[i][j],target,i,j+1);
        visited[i][j]=0;
    }

    @Override
    public void test()
    {
//        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        System.out.println(exist(new char[][]{{'a','b'}},"ba"));
//        System.out.println(exist(new char[][]{{'a','a'}},"aaa"));
    }
}
