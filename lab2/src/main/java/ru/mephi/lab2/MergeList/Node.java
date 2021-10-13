package ru.mephi.lab2.MergeList;

public class Node {
    private long value;
    private Node previous;
    private Node next;
    
    public Node(long data) {
        value = data;
        previous = next = null;
    }
    
    public long getValue() {
        return value;
    }
    
    public Node getPrevious() {
        return previous;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setValue(long data) {
        value = data;
    }
    
    public void setPrevious(Node temp) {
        previous = temp;
    }
    
    public void setNext(Node temp) {
        next = temp;
    }
}