package learn.algorithm.queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author suidonglei
 * @title: StackWithQueue
 * @projectName javaTest
 * @description: TODO
 * @date 2019/8/516:06
 */
public class StackWithQueue {
    Queue<Integer> firQueue = new LinkedBlockingQueue<>();
    Queue<Integer> secQueue = new LinkedBlockingQueue<>();
    /** Initialize your data structure here. */
    public StackWithQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!firQueue.isEmpty()) {
            firQueue.add(x);
        } else if(!secQueue.isEmpty()) {
            secQueue.add(x);
        } else {
            firQueue.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(firQueue.isEmpty()) {
            while(!secQueue.isEmpty()) {
                Integer intVal = secQueue.poll();
                if (secQueue.isEmpty()) {
                    return intVal;
                }
                firQueue.add(intVal);
            }
        }
        if(secQueue.isEmpty()) {
            while(!firQueue.isEmpty()) {
                Integer intVal = firQueue.poll();
                if (firQueue.isEmpty()) {
                    return intVal;
                }
                secQueue.add(intVal);
            }
        }
        return  secQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        Integer retVal = null;
        if(firQueue.isEmpty()) {
            while(!secQueue.isEmpty()) {
                Integer intVal = secQueue.poll();
                if (secQueue.isEmpty()) {
                    retVal = intVal;
                }
                firQueue.add(intVal);
            }
        }
        if(secQueue.isEmpty()) {
            while(!firQueue.isEmpty()) {
                Integer intVal = firQueue.poll();
                if (firQueue.isEmpty()) {
                    retVal = intVal;
                }
                secQueue.add(intVal);
            }
        }
        return  retVal;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return firQueue.isEmpty() && secQueue.isEmpty();
    }

    public static void main(String[] args) {
        StackWithQueue stackWithQueue = new StackWithQueue();
        stackWithQueue.push(1);
        stackWithQueue.push(2);
        stackWithQueue.push(3);
    }
}
