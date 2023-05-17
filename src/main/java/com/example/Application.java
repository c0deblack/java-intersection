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
 */
public class Application {
    private static class Node {
        private final int value;
        Node(int v) {
            this.value = v;
        }
        public int value(){
            return this.value;
        }
    }

    public static void main(String[] args){
        Node[] nodes = new Node[10];

        // generate nodes that will be stored in the linked list
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(i);
        }

        // create the first linked list
        LinkedList<Node> linkNodes1 = new LinkedList<>(){
            {
                this.add(nodes[0]);
                this.add(nodes[1]);
                this.add(nodes[2]);
                this.add(nodes[3]);
                this.add(nodes[4]);

                // nodes[5] and nodes[6] will also be in linkedList2
                this.add(nodes[5]);
                this.add(nodes[6]);

            }
        };

        LinkedList<Node> linkedList2 = new LinkedList<>(){
            {
                // nodes[5] and nodes[6] are shared with linkedList1
                this.add(nodes[5]);
                this.add(nodes[6]);

                // other nodes
                this.add(nodes[1]);
                this.add(nodes[3]);
                this.add(nodes[8]);
            }
        };

        System.out.println(getIntersectingNodes(linkNodes1, linkedList2));
    }

    private static final List<Node> getIntersectingNodes(LinkedList<Node> l1, LinkedList<Node> l2){
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
