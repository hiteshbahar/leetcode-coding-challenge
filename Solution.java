import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // First find the meet point in the cycle.
        ListNode fast, slow, meet = null, headA, headB;
        fast = head;
        slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                meet = slow;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        // Seperate the list into two linkedLists
        // Then the problem turns into a intersection.
        
        // Set the beginning point of one linkedlist to headA.
        headA = meet.next;
        meet.next = null;
        // Set another beginning point to headB.
        headB = head;
        fast = headA;
        slow = headB;
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0, lenB = 0, diff;
        while (fast != null) {
            lenA++;
            fast = fast.next;
        }
        while (slow != null) {
            lenB++;
            slow = slow.next;
        }
        fast = headA;
        slow = headB;
        if (lenA > lenB) {
            diff = lenA - lenB;
            while (diff > 0) {
                fast = fast.next;
                diff--;
            }
        } else if (lenA < lenB) {
            diff = lenB - lenA;
            while(diff > 0) {
                slow = slow.next;
                diff--;
            }
        }
        while (fast != null && slow != null) {
            if (fast.val == slow.val) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        ListNode dummy = s.new ListNode(0);
        ListNode curr = s.new ListNode(0);
        ListNode head = s.new ListNode(1);
        head.next = s.new ListNode(2);
        head.next.next = s.new ListNode(3);
        head.next.next.next = s.new ListNode(4);
        head.next.next.next.next = s.new ListNode(5);
        head.next.next.next.next.next = s.new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        
        dummy.next = head;
        curr = dummy;
        //System.out.println(isPalindrome(head));
        //System.out.println(detectCycle(head).val);
        System.out.println(curr == dummy);

    }

}
