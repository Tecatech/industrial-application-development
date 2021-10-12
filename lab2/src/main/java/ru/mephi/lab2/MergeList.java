package ru.mephi.lab2;

public class MergeList {
   /**
     * This method merges two sorted doubly linked lists.
     * 
     * @param head1
     *            : the head of the first doubly linked list.
     * @param head2
     *            : the head of the second doubly linked list.
     * @return the head of the merged doubly linked list.
     */
    public Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        
        if (head2 == null) {
            return head1;
        }
        
        if (head1.getValue() < head2.getValue()) {
            head1.setNext(merge(head1.getNext(), head2));
            head1.getNext().setPrevious(head1);
            head1.setPrevious(null);
            return head1;
        }
        else {
            head2.setNext(merge(head2.getNext(), head1));
            head2.getNext().setPrevious(head1);
            head2.setPrevious(null);
            return head2;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Try out our new feature...");
    }
}