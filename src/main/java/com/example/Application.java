package com.example;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *  Intersection:
 *
 *  Given two (singly) linked lists, determine if the two lists intersect.
 *
 *  Return the intersecting node.
 *
 *  Note that the intersection is defined based on reference, not value.
 *
 *  That is, if the kth node of the first linked list is the exact same node (by reference)
 *  as the jth node of the second linked list, then they are intersecting.
 * </pre>
 *
 */
public class Application {
    /**
     * Basic Node implementation
     */
    private static class Node {
        private int value;

        private Node next = null;

        Node(){}

        Node(int v) {
            this.value = v;
        }
        public int value(){
            return this.value;
        }

        public void value(int i){
            this.value = i;
        }

        public Node next(){
            return this.next;
        }

        public void next(Node n){
            this.next = n;
        }

    }

    /**
     * Basic Singly Linked List implementation.
     */
    private static class SinglyLinkedList {
        private Node head = null;
        private Node tail = null;
        private long size = 0;

        public long size(){
            return this.size;
        }

        public long add(Node n){
            if (head == null) {
                this.head = n;
                this.tail = this.head;
            } else {
                tail.next(n);
                tail = tail.next;
            }
            return ++this.size;
        }

        public Node get(int i){
            if (i > size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            Node current = this.head;
            for(int n = 0; n < i; n++){
                if (current == null) break;
                current = current.next;
            }

            return current;
        }
    }

    public static void main(String[] args){
        Node[] nodes = new Node[10];

        // generate nodes that will be stored in the linked list
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(i);
            System.out.println("Node #" + i + " address = " + nodes[i]);
        }
        System.out.println();

        // create the first linked list
        SinglyLinkedList linkNodes1 = new SinglyLinkedList(){
            {
                this.add(nodes[0]);
                this.add(nodes[2]);
                this.add(nodes[4]);

                // shared nodes
                this.add(nodes[1]);
                this.add(nodes[3]);
                this.add(nodes[5]);
                this.add(nodes[6]);

            }
        };

        SinglyLinkedList linkedList2 = new SinglyLinkedList(){
            {
                // shared nodes
                this.add(nodes[1]);
                this.add(nodes[5]);
                this.add(nodes[6]);
                this.add(nodes[3]);

                // other nodes
                this.add(nodes[8]);
            }
        };

        System.out.println(getIntersectingNodes(linkNodes1, linkedList2));
    }

    private static final List<Node> getIntersectingNodes(SinglyLinkedList l1, SinglyLinkedList l2){
        LinkedList<Node> output = new LinkedList<>();

        System.out.println("INTERSECTIONS");
        System.out.println("The following nodes exist in both linked lists. The output represents the intersection of both lists.");
        System.out.println();

        for(int i = 0; i < l1.size(); i++){

            for(int y = 0; y < l2.size(); y++){
                if (l1.get(i) == l2.get(y)){
                    System.out.println("Node #" + i + " with value [" + l2.get(y).value() +"] and address {" + l2.get(y) + "}");
                    output.add(l2.get(y));
                }
            }
        }
        System.out.println();
        return output;
    }
}
