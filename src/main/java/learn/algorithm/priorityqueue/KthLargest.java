package learn.algorithm.priorityqueue;

import java.util.PriorityQueue;

/**
 * @author suidonglei
 * @title: KthLargest
 * @projectName algorithm-test
 * @description: 703
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * @date 2019/8/610:17
 */
public class KthLargest {
    private int k;
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((obj1, obj2) -> {
        if(obj1 > obj2) {
            return 1;
        } else if (obj1 < obj2){
            return -1;
        } else{
            return 0;
        }
    });;
    /**
     * accepts an integer k and an integer array nums
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            if(priorityQueue.size() < k){
                priorityQueue.add(num);
            } else {
                if(num > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }
        }
    }

    public int add(int val) {
        if(priorityQueue.size() < k) {
            priorityQueue.add(val);
            return val;
        }
        int top = priorityQueue.peek();
        if(val > top) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(5, new int[]{2,1,4,5,3,2,2,7,5});
        System.out.println(kthLargest.add(4));
    }
}
