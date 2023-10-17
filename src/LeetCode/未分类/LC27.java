package LeetCode.未分类;

public class LC27
{
    public int run(int[] nums, int val)
    {
        int a=0,b=0;
        if(nums.length == 0)
        {
            return 0;
        }
        while (b < nums.length)
        {
            if(nums[b]!=val)
            {
                nums[a]=nums[b];
                b++;
                a++;
            }
            else
            {
                b++;
            }
        }
        return a;
    }
}
