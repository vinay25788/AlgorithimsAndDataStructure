package datastructure.queue;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class QueueUsingLinkedList {
    Node rear,front;
    public void enqueue(int data)
    {
        Node newNode = new Node(data);
        if(this.rear == null)
        {
         this.front=   this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public void dequeue()
    {
        if(this.front == null)
            return;
        Node temp = this.front;
        this.front = this.front.next;
        if(this.front == null)
            this.rear = null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front : " + q.front.data);
        System.out.println("Queue Rear : " + q.rear.data);
    }
}
