package LeetCode.数据结构设计;

import LeetCode.Base.LeetCodeBase;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC146 implements LeetCodeBase
{
    class LRUCache
    {
        class DoublyListNode
        {
            int key;
            int val;
            DoublyListNode pre;
            DoublyListNode next;

            public DoublyListNode(int key,int val, DoublyListNode pre, DoublyListNode next) {
                this.key=key;
                this.val = val;
                this.pre = pre;
                this.next = next;
            }
        }
        HashMap<Integer, DoublyListNode> hashMap;
        DoublyListNode head;
        int length;
        int maxLength;
        public LRUCache(int capacity)
        {
            this.hashMap=new HashMap<>();
            maxLength=capacity;
            head=new DoublyListNode(-1,-1,null,null);

            length=0;
        }

        public int get(int key)
        {
            if(hashMap.containsKey(key))
            {
                DoublyListNode node=hashMap.get(key);
                if(node.next!=null&&node.pre!=null)
                {
                    node.next.pre= node.pre;
                    node.pre.next=node.next;
                    node.next=head.next;
                    head.next.pre=node;
                    head.next=node;
                    node.pre=head;

                    return node.val;
                }
                if(node.next==null&&node.pre!=null)
                {
                    if(node.pre==head)
                    {
                        return node.val;
                    }
                    node.pre.next=null;

                    node.next=head.next;
                    head.next.pre=node;
                    head.next=node;
                    node.pre=head;
                    return node.val;
                }
                if(node.pre==head)
                {
                    return node.val;
                }


            }
            return -1;
        }

        public void put(int key, int value)
        {
            if(hashMap.containsKey(key))
            {
                hashMap.get(key).val=value;
                DoublyListNode node=hashMap.get(key);
                if(node.next!=null&&node.pre!=null)
                {
                    node.next.pre= node.pre;
                    node.pre.next=node.next;
                    node.next=head.next;
                    head.next.pre=node;
                    head.next=node;
                    node.pre=head;
                }
                if(node.next==null&&node.pre!=null)
                {
                    if(node.pre!=head)
                    {
                        node.pre.next=null;

                        node.next=head.next;
                        head.next.pre=node;
                        head.next=node;
                        node.pre=head;
                    }
                }
            }
            else
            {
                DoublyListNode node=new DoublyListNode(key,value,null, null);
                if(length<maxLength)
                {
                    if(length==0)
                    {
                        head.next=node;
                        node.next=null;
                        node.pre=head;
                        length++;
                    }
                    else
                    {
                        node.next=head.next;
                        head.next.pre=node;
                        head.next=node;
                        node.pre=head;
                        length++;
                    }
                    hashMap.put(key, node);
                }
                else
                {
                    //移除最后一个节点
                    DoublyListNode p=head;
                    while (p.next.next!=null)
                    {
                        p=p.next;
                    }
                    hashMap.remove(p.next.key);
                    p.next=null;
                    if(head.next==null)
                    {
                        head.next=node;
                        node.pre=head;
                        hashMap.put(key, node);
                    }
                    else
                    {
                        node.next=head.next;
                        head.next.pre=node;
                        head.next=node;
                        node.pre=head;
                        hashMap.put(key, node);
                    }

                }
            }
        }
    }


    @Override
    public void test()
    {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));

        System.out.println(lRUCache.get(2));

    }



}


//LinkedHashMap实现
class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使⽤
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使⽤
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使⽤的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插⼊到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */