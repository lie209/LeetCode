package LeetCode.未分类;

public class LC167
{
    public int[] run(int[] numbers, int target)
    {

        int left=0,right=numbers.length-1;

        while (left<=right)
        {
            int min = (left+right)/2;
            int sum=numbers[left]+numbers[right];
            if(sum==target)
            {
                return new int[] {left+1,right+1};
            }
            //左边的太小了
            else if(sum<target)
            {
                left++;
            }
            //右边的太大了
            else if (sum>target)
            {
                right--;
            }
        }
        return null;
    }
}
