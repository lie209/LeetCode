package LeetCode;

import LeetCode.Common.ListNode;
import LeetCode.二分法.LC35;
import LeetCode.动态规划.LC139;
import LeetCode.动态规划.LC198;
import LeetCode.动态规划.LC279;
import LeetCode.动态规划.LC518;
import LeetCode.回溯法.LC131;
import LeetCode.回溯法.LC22;
import LeetCode.回溯法.LC79;
import LeetCode.复习.LC90;
import LeetCode.数组.LC624;
import LeetCode.未分类.JZO65;
import LeetCode.未分类.LC2645;
import LeetCode.未分类.LC720;
import LeetCode.未分类.YongYouS4_2;
import LeetCode.栈和队列.LC155;
import LeetCode.栈和队列.LC394;
import LeetCode.贪心法.LC55;
import LeetCode.链表.LC24;
import com.sun.jdi.event.StepEvent;
import com.sun.security.auth.NTNumericCredential;
import com.sun.source.tree.NewArrayTree;

import javax.crypto.Cipher;
import javax.swing.*;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.transform.dom.DOMResult;
import java.awt.*;
import java.awt.image.renderable.RenderableImage;
import java.lang.annotation.Retention;
import java.math.BigInteger;
import java.security.interfaces.RSAKey;
import java.util.*;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class MainTest {

    public static void main(String[] args)
    {
        System.out.println(Delete_character("aab"));

    }

    public static int countSeq (String mystr) {
        mystr=mystr.toLowerCase();
        HashMap<Character,Integer> map=new HashMap<>();
        for (char c:mystr.toCharArray())
        {
            int count=map.getOrDefault(c,0);
            count++;
            map.put(c,count);
        }
        int result=Integer.MAX_VALUE;
        int ok=0;
        for(char c:"cbft".toCharArray())
        {
            if(map.containsKey(c))
            {
                ok++;
                if(c=='c')
                {
                    result= Math.min(map.get(c) / 2, result);
                }
                else
                {
                    result=Math.min(result,map.get(c));
                }
            }

        }
        return result=ok==4?result:0;
    }
    public static int Delete_character (String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (char c:s.toCharArray())
        {
            map.put(c,(map.getOrDefault(c,0)+1));
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((Integer a,Integer b)->{return b-a;});
        for (char c:map.keySet())
        {
            queue.add(map.get(c));
        }
        int[] nums=new int[map.keySet().size()];
        for (int i=0;i<nums.length;i++)
        {
            nums[i]=queue.poll();
        }
        int result=0;
        int pre=nums[0];
        for (int i=1;i<nums.length;i++)
        {
            while (nums[i]>=pre&&nums[i]>0)
            {
                nums[i]--;
                result++;
            }
            pre=nums[i];
        }
        return result;

    }

}



