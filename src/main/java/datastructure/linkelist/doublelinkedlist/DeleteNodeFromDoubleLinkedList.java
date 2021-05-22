package datastructure.linkelist.doublelinkedlist;

class Node
{
    int data;
    Node prev,next;
    Node(int data)
    {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}
public class DeleteNodeFromDoubleLinkedList {

    Node head;

    public void add(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    public void delete(Node del)
    {

        if(head != null && head.data == del.data)
        {
            head = null;
            return;
        }
        if(head.next != null && head.next.data == del.data)
        {
            head.next = null;
        }

        del.prev.next = del.next;
        del.next.prev = del.prev;
        return;


    }


    public void print()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {

        DeleteNodeFromDoubleLinkedList obj = new DeleteNodeFromDoubleLinkedList();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);
        obj.print();
        obj.delete(obj.head.next.next.next);
        System.out.println();
        obj.print();


    }
}
