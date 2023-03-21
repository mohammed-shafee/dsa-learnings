package linkedList.practice;
public class Basics{
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(s==f && f!=null){
                return true;
            }
        }
        return false;  
    }

    public int cycleLength(ListNode head){
        ListNode f = head;
        ListNode s = head;
        int count =0;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(s==f && f!=null){
                do{
                    count++;
                    s = s.next;
                }while(s != f);
                break;
            }
        }
        return count;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        int count = 0;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(s==f && f!=null){
                do{
                    s= s.next;
                    count++;
                }while(s != f);
                f = head;
                s = head;
                //first traverse s by lenght of cycle
                while(count>0){
                    s = s.next;
                    count--;
                }
                //now move both pointer by 1 till they meet.
                while(s!=f){
                    s = s.next;
                    f = f.next;
                }     
                return s;           
            }
        }
    return null;
}

}