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
        }
        size++;
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