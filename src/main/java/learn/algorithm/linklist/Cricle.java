package learn.algorithm.linklist;

import java.util.Objects;

class Node{
     int val;
     Node next;
 }
 public class Cricle {
     int getLoopSize(Node head) {
         int loopSize = 0;
         if(Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) return loopSize;
         Node matcheNode = getMatchNode(head);
         if(Objects.isNull(matcheNode)) return loopSize;
         loopSize = calLoopSize(head, matcheNode);
         return loopSize;
     }

     private int calLoopSize(Node head, Node matcheNode) {
         int size = 0;
         Node temp1 = head;
         Node temp2 = matcheNode;
         while(temp1 != temp2) {
             size ++;
             temp1 = temp1.next;
             temp2 = temp2.next;
         }
         while(temp1 != matcheNode) {
             size ++;
             temp1 = temp1.next;
         }
         return size;
     }

     private Node getMatchNode(Node head) {
         Node one = head;
         Node two = head;
         while(one.val != two.val && one.next != null && two.next != null && two.next.next!= null) {
             one = one.next;
             two = two.next.next;
         }
         if(one.val != two.val) {
             return null;
         }
         return one;
     }
 }