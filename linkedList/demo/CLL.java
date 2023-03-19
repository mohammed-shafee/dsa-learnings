package linkedList.demo;
public class CLL{
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

    }

    private Node head;
    private Node tail;
    private int size;
    public CLL(){
        size = 0;
        head = null;
        tail = null;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            head.next = tail;
            tail.next = head;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void display(){
        Node temp = head;
        if(head != null){
            do{
                System.out.print(temp.value+" -> ");
                temp = temp.next;
            }
            while(temp != head);
            System.out.println("HEAD");
        }
        
    }

    public void delete(int val){
        if(head == null){
            System.out.println("deletion not possible");
            return;
        }
        //find the prev node to the given val
        Node temp = head;
        do{
            if(temp.next.value == val){
                if(temp == head && head == tail){
                    head = null;
                    tail = null;
                    size--;
                    return;
                }
                if(temp.next == head){
                    head = temp.next.next;   
                }else if(temp.next == tail){
                    tail = temp;
                }
                temp.next = temp.next.next;
                size--;
                
            }
            temp = temp.next;
        }while(temp!=head);
        System.out.println("head value:"+ head.value);
        System.out.println("tail value:"+tail.value+"; tail's next value (head)"+tail.next.value);
    }

    public Node find(int val){
        Node temp = head;
        if(head != null){
            do{
                if(temp.value == val){
                    return temp;
                }
                temp = temp.next;
            }while(temp != head);
        }
        return null;
    }

}