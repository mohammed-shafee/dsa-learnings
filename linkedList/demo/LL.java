package linkedList.demo;
public class LL{
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
    
    public LL(){
        this.size = 0;
    }

    public Node get(int index){
        Node node = head;
        for(int i =0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        // System.out.println("head="+head);
        node.next = head;
        head = node;
        // System.out.println("current node's next="+node.next);

        if(tail == null){
            tail = head;
        }

        size += 1;
    }

    public void inserLast(int val){
        Node node = new Node(val);
        if(tail == null){
            insertFirst(val);
        }else{
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insert(int val, int index){
        if(index<0 || index>size){
            System.out.println("insertion not possible");
            return;
        }
        else if(index == 0){
            insertFirst(val);
        }else if(index == size){
            inserLast(val);
        }else{
            Node temp = head;
            // for(int i=0;i<index-1;i++)
            for(int i=1;i<index;i++){
                temp = temp.next;
            }
            Node node = new Node(val,temp.next);
            temp.next = node;
            size++;
        }
        
    }

    // remove and return the first element of the Linked list
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    // remove and return the last element of the linked list
    public int deleteLast(){
        if(size<=1){
           return deleteFirst();
        }
        Node secondLast = get(size-2);
        // int val = secondLast.next.value;
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if(index<0 || index>size){
            System.out.println("insertion not possible");
            return null;
        }
        if(index == 0){
            return deleteFirst();
        }else if(index == size-1){
            return deleteLast();
        }else{
            int val = get(index).value;
            Node prev = get(index-1);
            prev.next = get(index).next;
            size--;
            return val;
        }
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }

    public int getSize(){
        return this.size;
    }

}