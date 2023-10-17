package LeetCode.图;

import LeetCode.Base.LeetCodeBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC208 implements LeetCodeBase
{
    class Trie {

        HashSet<String> sets=new HashSet<>();
        HashSet<String> words=new HashSet<>();
        public Trie()
        {

        }

        public void insert(String word)
        {
            if(sets.contains(word))
            {
                return;
            }
            for (int i=1;i<=word.length();i++)
            {
                if(words.contains(word.substring(0,i)))
                {
                    continue;
                }
                words.add(word.substring(0,i));
            }
            sets.add(word);

        }

        public boolean search(String word)
        {
            return sets.contains(word);
        }

        public boolean startsWith(String prefix)
        {
            return words.contains(prefix);
        }


    }
    @Override
    public void test() {

    }
}
