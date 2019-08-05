package learn.algorithm.stack;

import java.util.Stack;

/**
 * @author suidonglei
 * @title: QueueWithStack
 * @projectName javaTest
 * @description: 232
 * @date 2019/8/515:46
 */
public class QueueWithStack {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();
    /** Initialize your data structure here. */
    public QueueWithStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStack.empty()) {
            while(!inStack.empty()){
                Integer intVal = inStack.pop();
                outStack.push(intVal);
            }
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outStack.empty()) {
            while(!inStack.empty()){
                Integer intVal = inStack.pop();
                outStack.push(intVal);
            }
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}
