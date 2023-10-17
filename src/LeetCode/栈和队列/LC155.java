package LeetCode.栈和队列;

import LeetCode.Base.LeetCodeBase;

import java.util.PriorityQueue;
import java.util.Stack;

public class LC155 implements LeetCodeBase
{
    class MinStack {

        Stack<Integer> stack=new Stack<>();
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        public MinStack()
        {
        }

        public void push(int val)
        {
            stack.push(val);
            queue.add(val);
        }

        public void pop()
        {
            if(!stack.isEmpty())
            {
                queue.remove(stack.pop());
            }
        }

        public int top()
        {
            return stack.peek();
        }

        public int getMin()
        {
            return queue.peek();
        }
    }

    @Override
    public void test()
    {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();

    }
}
