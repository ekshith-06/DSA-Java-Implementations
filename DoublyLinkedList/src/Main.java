class Node{
    int data;
    Node next,prev;
    Node(int val){
        data=val;
        next=null;
        prev=null;
    }
    Node(int val,Node next,Node prev){
        data=val;
        this.next=next;
        this.prev=prev;
    }
}


class Main{

    public static void convertArrToDll(Node head,int []a){
        for(int i=1;i<a.length;i++){
            Node temp=new Node(a[i]);
            head.next=temp;
            temp.prev=head;
            head=head.next;
        }
    }

    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");;
            head=head.next;
        }
        System.out.println("");
    }

    public static Node deleteBeg(Node head){
        if(head==null ) return null;
        head=head.next;
        head.prev=null;
        return head;
    }

    public static Node deleteEnd(Node head){

        if(head==null || head.next==null) return null;
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }

    public static Node insertBeg(Node head,int val){
        if(head==null) return new Node(val,head,null);
        Node temp=new Node(val);
        temp.next=head;
        head.prev=temp;
        head=temp;
        return head;
    }

    public static Node insertEnd(Node head,int val){
        if(head==null)return new Node(val);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node last=new Node(val);
        last.prev=temp;
        temp.next=last;
        return head;
    }



    public static void main(String[] args) {
        int []a={1,2,3,4,5,9};
        Node head=new Node(a[0]);
       convertArrToDll(head,a);
        print(head);
       head=deleteBeg(head);
        System.out.println("Delete Beg!");
        print(head);
        System.out.println("Delete End!!");
         head=deleteEnd(head);
        print(head);


    }
}
