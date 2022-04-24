public class Singlelinkedlist {
    private listNode head;
    private static class listNode{
        private int data;
        private listNode next;
       public listNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    // Display linkedlist
    public void display(){
        listNode current=head;
        while (current!=null){
            System.out.print(current.data+ "-->");
            current=current.next;
        }
      System.out.println("null");
   }
    //find length linkedlist
    public void length(){
        if (head==null){
            return ;
        }

        int count=0;
        listNode temp=head;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println("length of node-->"+count);
    }
    //insert node beginning
    public void insert(int value){
        listNode newNode=new listNode(value);
        newNode.next=head;
        head=newNode;
    }
    //insert node end
    public void endinsert(int value){
        listNode newNode=new listNode(value);
        if(head==null){
            head=newNode;
            return;
        }
        listNode current=head;
       while (null!=current.next){
           current=current.next;
       }
       current.next=newNode;
    }
    //insert node given position
    public void insertposition(int position, int value){
        listNode newNode=new listNode(value);
       if(position==1){
           newNode.next=head;
           head=newNode;
       }
       else {
           listNode previous=head;
           int cout=1;
           while (cout<position-1){
               previous=previous.next;
               cout++;
           }
           listNode current=previous.next;
           previous.next=newNode;
           newNode.next=current;
       }

    }
//Delete Node beginning
    public void deletebeginning(){
        if(head==null){
            return;
        }
        listNode temp=head;
        head=temp.next;

    }
    //Delete node end
    public void deleteend(){
        if(head==null || head.next!=null){
            return;
        }
        listNode current=head;
        listNode previous=null;
        while (current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;

    }
    //search node in linkedlist
    public void  search(int key){
        listNode current=head;
        while (current!=null){
            if(current.data==key){
                System.out.println("key is present--->>"+current.data);
            }
            current=current.next;
        }
        System.out.println("Not");

    }
// Reverse linkedlist
    public listNode reverse(listNode head){
        if(head==null){
            return head;
        }
        listNode current=head;
        listNode previous=null;
        listNode next=null;
        while (current!=null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
       return previous;
    }
//    find middle node
    public void middle(){
        if(head==null){
            return ;
        }
        listNode slowptr=head;
        listNode fastptr=head;
        while (fastptr!=null && fastptr.next!=null){
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        System.out.println("middle node is -->"+slowptr.data);
    }
    //find n th node
    public listNode nthnode(int position){
        if(head ==null){
            return null;
        }
        listNode mainptr=head;
        listNode refptr=head;
        int count=0;
        while (count<=position){
            refptr=refptr.next;
            count++;
        }

        while (refptr!=null){
            refptr=refptr.next;
            mainptr=mainptr.next;
        }
       return mainptr;
    }

    //remove duplicate node
    public void removeduplicate(){
        if(head==null){
            return;
        }
        listNode current=head;
        while (current!=null &&current.next!=null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            }
            else {
                current=current.next;
            }
        }
    }

    //insert Node in sorted linkedlist
    public listNode sortedinsert(int n){
        listNode newNode=new listNode(n);
        if(head==null){
            return newNode;
        }
        listNode current=head;
        listNode temp=null;
        while (current!=null && current.data<newNode.data){
        temp =current;
        current=current.next;
        }
        newNode.next=current;
        temp.next=newNode;
        return head;
    }
// delete given key node
    public void keydeletenode(int key){
        if(head==null) return;
        listNode current=head;
        listNode temp=null;
        while (current!=null && current.data!=key){
            temp=current;
            current=current.next;
        }
        if (current==null) return;
        temp.next=current.next;
    }
//detect loop in listnode
    public boolean detectloop(){
        listNode slowptr=head;
        listNode fastptr=head;
        while (fastptr!=null && fastptr.next!=null){
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
            if (slowptr==fastptr) return true;
        }
        return false;
    }
    //find loop node data
    public listNode startNode(){
        listNode slowptr=head;
        listNode fastptr=head;
        while (fastptr!=null && fastptr.next!=null){
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
            if(slowptr==fastptr){
                return getstartNode(slowptr);
            }
        }
        return null;
    }
    public listNode getstartNode(listNode slowptr) {
        listNode temp = head;
        while (temp != slowptr) {
            temp = temp.next;
            slowptr = slowptr.next;
        }
        return temp;
    }
//    remove loop in linkedlist
public void removeLoop(){
    listNode slowptr=head;
    listNode fastptr=head;
    while (fastptr!=null && fastptr.next!=null){
        fastptr=fastptr.next.next;
        slowptr=slowptr.next;
        if(slowptr==fastptr){
            removeLoop(slowptr);
            return;
        }
    }
}
    private void removeLoop(listNode slowptr){
        listNode temp=head;
        while (slowptr.next!=temp.next){
            temp=temp.next;
            slowptr=slowptr.next;
        }
        slowptr.next=null;

    }
    // merge two linkedlist
    public static listNode merge(listNode a,listNode b){
        listNode dummy=new listNode(0);
        listNode temp=dummy;
        while (a!=null && b!=null) {
            if (a.data <= b.data) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp=temp.next;
        }
            if(a==null){
                temp.next=b;
            }
            else {
                temp.next=a;
            }
            return dummy.next ;

    }

    public void createloop(){
        listNode first=new listNode(10);
        listNode second=new listNode(20);
        listNode third =new listNode(30);
        listNode four=new listNode(40);
        listNode five =new listNode(50);
        head=first;
        first.next=second;
        second.next=third;
        third.next=four;
        four.next=five;
        five.next=third;
    }
    public static void main(String[] args) {
        Singlelinkedlist sll1=new Singlelinkedlist();
//        sll.head=new listNode(10);
//        listNode second=new listNode(20);
//        listNode third=new listNode(55);
//        listNode fourth=new listNode(22);
//        listNode five=new listNode(11);
//        sll.head.next=second;
//        second.next=third;
//        third.next=fourth;
//        fourth.next=five;
        sll1.insert(5);
        sll1.insert(10);
        sll1.insert(30);
        sll1.insert(40);
        sll1.insert(50);
//        Singlelinkedlist sll2=new Singlelinkedlist();
//        sll2.insert(2);
//        sll2.insert(8);
//        sll2.insert(12);
//        sll2.insert(20);
//        sll2.insert(25);
//      sll.insert(60);
//        sll.insert(70);
        sll1.display();
//        sll.endinsert(30);
//        sll.endinsert(10);
//        sll.endinsert(5);
        sll1.insertposition(2,22);
        sll1.display();
//        sll.search(1);
       // sll.deletebeginning();
       // sll.deleteend();

//       listNode reverse= sll.reverse(sll.head);

////        sll.middle();
//        sll.display();
//        listNode nth=sll.nthnode(4);
//        System.out.println("nth node is-->"+nth.data);
//  sll.length();
//  sll.removeduplicate();
        //sll.sortedinsert(35);
//        sll.keydeletenode(40);
       // sll.createloop();
//        System.out.println(sll.detectloop());
//        System.out.println(sll.startNode().data);
//        sll.removeLoop();
        //sll1.display();
        //sll2.display();
        Singlelinkedlist result=new Singlelinkedlist();
      //  result.head=merge(sll1.head,sll2.head);
        //result.display();
    }
}
