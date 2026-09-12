package org.example;


import java.util.Stack;
import java.util.TreeMap;

public class MaxStack {

      DoubleLinkedList doubleLinkedList;
      TreeMap<Integer, Stack<Node>> map;

      MaxStack()
      {
          doubleLinkedList = new DoubleLinkedList();
          map = new TreeMap<>();
      }

      public void push(int value)
      {
          Node node = new Node(value);

          doubleLinkedList.addNode(node);
          map.computeIfAbsent(value,k-> new Stack<>()).push(node);
      }

      public int pop()
      {
          Node node = doubleLinkedList.removeLast();
          if(node == null)
                return -1;
          Stack<Node> stack = map.get(node.value);

          stack.pop();
          if(stack.isEmpty())
               map.remove(node.value);
          return node.value;

      }

      public int popMax()
      {
          if(map.isEmpty())
               return -1;
          int lastKey = map.lastKey();
          Stack<Node> st = map.get(lastKey);
          Node node = st.pop();
          if(st.isEmpty())
               map.remove(node.value);
          doubleLinkedList.remove(node);

          return node.value;
      }
      public int peekMax()
      {
            if(map.isEmpty())
               return -1;

           return map.lastKey();



      }


    static class DoubleLinkedList
    {
        Node head, tail;

        DoubleLinkedList()
        {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }


        public void addNode(Node node)
        {
            Node tailPrev = tail.prev;
           tailPrev.next = node;
           node.prev = tailPrev;

           node.next = tail;
           tail.prev = node;
        }


        public Node removeLast()
        {
            Node lastPrev = tail.prev;
            if(lastPrev == head)
                 return null;
            return remove(lastPrev);
        }

        public Node remove(Node node)
        {
            Node next = node.next;
            Node prev = node.prev;

            next.prev = prev;
            prev.next = next;

            return node;
        }
    }

    static class Node
    {
        int value;
        Node next, prev;

        Node(int value)
        {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}


