package com.algofun.different;

public class CycledLinkedList {

    public static void main(String[] args){
        CycledLinkedList noncycled = new CycledLinkedList();
        Node first = new Node();
        noncycled.first = first;

        Node current = first;
        for(int i = 0; i<10; i++){
            Node next = new Node();
            current.next = next;
            current = next;
        }

        CycledLinkedList cycled = new CycledLinkedList();
        first = new Node();
        cycled.first = first;

        current = first;
        for(int i = 0; i<10; i++){
            Node next = new Node();
            current.next = next;
            current = next;
        }
        current.next = first;

        System.out.println("Cycled 1 " + noncycled.isCycled());
        System.out.println("Cycled 2 " + cycled.isCycled());
    }


    Node first;
    public boolean isCycled(){
        Node slower = first;
        Node faster = first.next;

        while (faster != null && faster.next != null) {
            if (faster == slower || faster.next == slower)
                return true;

            slower = slower.next;
            faster = faster.next.next;
        }

        return false;
    }

    static class Node{
        public Node next;
    }
}
