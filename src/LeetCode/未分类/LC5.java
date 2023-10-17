package LeetCode.未分类;

public class LC5
{
    public String run(String s)
    {
        switch (s.length())
        {
            case 1:
            {
                return s;
            }
            case 2:
            {
                if(s.charAt(0)==s.charAt(1))
                {
                    return s;
                }
                else
                {
                    return String.valueOf(s.charAt(0));
                }
            }
        }
        int mid=1;
        int maxLen=0;
        int resultLeft = 0, resultRight = 0;
        while (mid<s.length())
        {
            int left=mid-1;
            int right = mid + 1;
            //奇数长度情况
            while (left>=0&&right<s.length())
            {
                if(s.charAt(left) == s.charAt(right))
                {
                    if(right-left+1>maxLen)
                    {
                        maxLen=right-left+1;
                        resultLeft=left;
                        resultRight = right;
                    }
                    left--;
                    right++;
                }
                else
                {
                    break;
                }
            }
            while (left>=0&&s.charAt(left)==s.charAt(mid))
            {
                if(mid-left+1>maxLen)
                {
                    maxLen = mid-left+1;
                    resultLeft=left;
                    resultRight = mid;
                }
                left--;
            }
            //连续字符串情况
            while (right<s.length()&&s.charAt(right) == s.charAt(mid))
            {
                if(right-mid+1>maxLen)
                {
                    maxLen=right-mid+1;
                    resultLeft=mid;
                    resultRight=right;
                }
                right++;
            }
            //偶数字符串情况
            int rightMid=mid+1;
            right=rightMid+1;
            if(right<s.length()&&s.charAt(rightMid) == s.charAt(mid))
            {
                while (left>=0&&right<s.length())
                {

                    if(s.charAt(left) == s.charAt(right))
                    {
                        if(right-left+1>maxLen)
                        {
                            maxLen=right-left+1;
                            resultLeft=left;
                            resultRight = right;
                        }
                        left--;
                        right++;
                    }
                    else
                    {
                        break;
                    }
                }
            }

            mid++;
        }
        return s.substring(resultLeft, resultRight+1);
    }
}
