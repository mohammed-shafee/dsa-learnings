package linkedList.demo;
class Main{
    public static void main(String[] args) {
        LL obj = new LL();
        obj.insertFirst(12);
        System.out.println("size= "+obj.getSize());
        System.out.println("head= "+obj.getHead());
        System.out.println("tail= "+obj.getTail());
    }
}