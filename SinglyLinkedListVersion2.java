import java.util.*;
class Node{
    String VALUE;
    Node Next;
    Node(String Data){
        this.VALUE=Data;
        this.Next=null;
    }
    Node(){this.Next=null;}
}
class SinglyLinkedListVersion2{
    public static void PrintLinkedList(Node Root){
        while(Root!=null){
            System.out.println(Root.VALUE);
            Root=Root.Next;
        }
    }
    public static Node AddNewNodeAtLast(String DATA,Node Root){
        if(Root==null){
            return new Node(DATA);
        }
        if(Root.Next==null){
            Root.Next=new Node(DATA);
            return Root;
        }
        AddNewNodeAtLast(DATA, Root.Next);
        return Root;
    }
    public static Node AddNewNodeAtFirst(String DATA,Node Root){
        Node newNode=new Node(DATA);
        newNode.Next=Root;
        return newNode;
    }
    public static Node AddNewNodeAtPosition(String DATA,Node Root,int Position){
        if(Root!=null){
            if(Position==1){
                return AddNewNodeAtFirst(DATA, Root);
            }
            else{
                Node head=Root;
                while(Position--!=0){
                    if(Position==1){
                        Node NewNode=new Node(DATA);
                        NewNode.Next=Root.Next; 
                        Root.Next=NewNode;
                        break;
                    }
                    Root=Root.Next;   
                }
                return head;
            }
        }
        else{
            Node NewNode=new Node(DATA);
            return NewNode;
        }
    }
    public static Node DeleteFromFront(Node Root){
        Root=Root.Next;
        return Root;
    }
    public static Node DeleteFromLast(Node Root){
        while(Root!=null){
            if((Root.Next!=null)&&(Root.Next.Next==null)){
                Root.Next=null;
            }
            Root=Root.Next;
        }
        return Root;
    }
    public static Node DeleteAtPosition(Node Root,int Position){
         Node NewNode=Root;
         int Check=Position-1;
         while(Position!=Check){
            Root=Root.Next;
            Position--;
         }
         Root.Next=(Root.Next).Next;
         return NewNode;
    }
    public static void main(String[] Args) {
        Node Root=new Node("SAI");
        Root=AddNewNodeAtFirst("CHARVISRI", Root);
        AddNewNodeAtLast("YASASWININ REDDY", Root);
        AddNewNodeAtLast("Vamsitha", Root);
        Root=AddNewNodeAtFirst("Pavitra", Root);
        PrintLinkedList(Root);
        System.out.println("-----------------------");
        Root=AddNewNodeAtPosition("YAMINI", Root, 3);
        PrintLinkedList(Root);
        Root=DeleteAtPosition(Root, 3);
        PrintLinkedList(Root);
    }
}

