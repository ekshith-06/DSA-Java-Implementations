class Node{
    int data;
    Node next;

    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }

    Node(int data){
        this.data=data;
        next=null;
    }
}

class Lists{

    public static void insertAtEnd(Node head,int val){
        if(head == null) return; // edge case

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(val);
    }

    public static void insert(Node head,int idx,int val){
        if(head == null || idx < 0) return; // edge case

        if(idx == 0){
            // cannot change head (void), so skip or handle outside
            return;
        }

        for(int i=0;i<idx-1 && head.next!=null;i++) head=head.next;

        Node temp=new Node(val);
        temp.next=head.next;
        head.next=temp;
    }

    public  static Node convertArrayToLL(int[] a){
        if(a == null || a.length == 0) return null; // edge case

        Node Head=new Node(a[0]);
        Node temp=Head;
        for(int i=1;i<a.length;i++){
            temp.next=new Node(a[i]);
            temp=temp.next;
        }
        return Head;
    }

    public static void displayList(Node Head){
        if(Head == null){
            System.out.println("Empty");
            return;
        }

        Node temp=Head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("");
    }

    public static Node insertAtBegin(Node head,int val){
        Node temp=new Node(val);
        temp.next=head;
        return temp; // simplified
    }

    public static Node deleteFromBeg(Node head){
        if(head == null) return null; // edge case
        return head.next;
    }

    public static void deleteFromEnd(Node head){
        if(head == null || head.next == null) return; // edge case

        while(head.next.next!=null) head=head.next;
        head.next=null;
    }

    public static void delete(Node head,int idx){
        if(head == null || idx < 0) return; // edge case

        if(idx == 0){
            // cannot change head (void), so skip
            return;
        }

        Node temp=head.next;
        for(int i=0;i<idx-1 && temp!=null;i++){
            head=head.next;
            temp=temp.next;
        }

        if(temp == null) return; // index out of bounds

        head.next=temp.next;
        temp.next=null;
    }

    public static void main(String []ar){
        int []arr=new int[]{1,2,3,4,5,6,7,8,98,100};

        Node temp= convertArrayToLL(arr);

        temp=insertAtBegin(temp,1000);
        displayList(temp);

        insertAtEnd(temp,20000);
        displayList(temp);

        insertAtEnd(temp,20000);
        displayList(temp);

        insert(temp,2,1000);
        displayList(temp);

        temp= deleteFromBeg(temp);
        displayList(temp);

        deleteFromEnd(temp);
        displayList(temp);

        deleteFromEnd(temp);
        displayList(temp);

        delete(temp,1);
        displayList(temp);
    }
}