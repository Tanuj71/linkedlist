public class doublelinkedlist {
    private listNode head;
    private listNode tail;
    private int length;
    private static class  listNode {
        private int data;
        private listNode next;
        private listNode previous;

        public listNode(int data) {
            this.data=data;
            this.next=null;
            this.previous=null;
        }
    }
    public doublelinkedlist(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
   public boolean isEmpty(){
        return true;
   }
   public int length(){
        return length;
   }
   //Display in forward way
   public void forwarddisplay(){
        if(head==null){
            return;
        }
        listNode temp=head;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
       System.out.print("null");
   }
   //Display in backward way
    public void backwarddisplay(){
        if (tail==null) {
            return;
        }
        listNode temp=tail;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.previous;
        }
        System.out.print("null");
    }
    //insert beggining
    public void insertbeggining(int value){
        listNode newNode=new listNode(value);
        if(isEmpty()) {
            tail = newNode;
        }
        else {
            head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;

    }
    //insert end Node
    public void insertEnd(int valaue){
        listNode newNode=new listNode(valaue);
        if (isEmpty()){
            head=newNode;
        }
        else {
            tail.next=newNode;
            newNode.previous=tail;
        }
        tail=newNode;
        length++;
    }
    public static void main(String[] args) {
doublelinkedlist dll=new doublelinkedlist();
//dll.insertbeggining(5);
//dll.insertbeggining(10);
//dll.insertbeggining(15);
//dll.insertbeggining(20);
dll.insertEnd(5);
dll.insertEnd(10);
dll.insertEnd(15);
dll.insertEnd(20);

//dll.forwarddisplay();
        dll.backwarddisplay();
    }
}
