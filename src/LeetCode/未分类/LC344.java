package LeetCode.未分类;

public class LC344
{
    public void run(char[] s)
    {
        switch(s.length)
        {
            case 1:
            {
                return;
            }
        }
        int left = 0,right = s.length-1;
        while (left<right)
        {
            char  c=s[left];
            s[left]=s[right];
            s[right]=c;
            left++;
            right--;
        }
    }
}
