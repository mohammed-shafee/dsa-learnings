package linkedList.demo;
public class DLL{
    private class Node{
        private int value;
        private Node next;
        private Node prev;
        

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next,Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private int size;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayRev(){
        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        System.out.println(temp.value);
        System.out.print("END"+" <- ");
        while(temp != null){
            System.out.print(temp.value+" <- ");
            temp = temp.prev;
        }
        System.out.println("START");
        
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        Node last = get(size-1);
        node.prev = last;
        last.next = node;
        node.next = null;
        size++;
    }

    public void insert(int val, int index){
        if(index<0 || index>size){
            System.out.println("insertion not possible");
            return;
        }else if(index == 0){
            insertFirst(val);
        }else if(index == size){
            insertLast(val);
        }else{
            Node temp = head;
            for(int i =0;i<index-1;i++){
                temp = temp.next;
            }
            Node node = new Node(val,temp.next, temp);
            temp.next = node;
            node.next.prev = node;
            size++;
        }

    }

    public void insertAtNode(int pval, int ival){
        Node prev = find(pval);
        if(prev == null){
            System.out.println("insertion not possible");
        }
        else{
            if(prev.next == null){
                insertLast(ival);
            }else{
                Node node = new Node(ival,prev.next,prev);
                prev.next = node;
                node.next.prev = node;
                size++;
            }
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

    public Node get(int index){
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    public int getSize(){
        return this.size;
    }

}