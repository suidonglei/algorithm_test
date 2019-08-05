package learn.algorithm.linklist;

/**
 * @author suidonglei
 * @title: SwapNodesPairs
 * @projectName javaTest
 * @description: 024
 * @date 2019/8/511:38
 */
public class SwapNodesPairs {

    public ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }
        ListNode first = head;
        ListNode second =  head.next;
        ListNode previous = null;
        head = second;
        while(null != first && null != second) {
            if(null != previous) {
                previous.next = second;
            }
            first.next = second.next;
            second.next = first;
            previous = first;
            first = first.next;
            if(null != first) {
                second = first.next;
            }
        }
        return head;
    }
}
