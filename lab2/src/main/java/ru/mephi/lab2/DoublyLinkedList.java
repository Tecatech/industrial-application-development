package ru.mephi.lab2;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }
    
    public void add(long value) {
        addLast(value);
    }
    
    public void add(int index, long value) {
        checkIndex(index);
        
        if (index == 0) {
            addFirst(value);
        }
        else if (index == length) {
            addLast(value);
        }
        else {
            Node current = head;
            
            while (index > 0) {
                current = current.getNext();
                index--;
            }
            
            Node newNode = new Node(value);
            Node temp = current.getPrevious();
            temp.setNext(newNode);
            current.setPrevious(newNode);
            newNode.setPrevious(temp);
            newNode.setNext(current);
            length++;
        }
    }
    
    public void addFirst(long value) {
        Node newNode = new Node(value);
        
        if (head == null) {
            head = tail = newNode;
        }
        else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
            head.setPrevious(null);
        }
        
        length++;
    }
    
    public void addLast(long value) {
        Node newNode = new Node(value);
        
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
            tail.setNext(null);
        }
        
        length++;
    }
    
    public long get(int index) {
        checkIndex(index);
        
        if (index == 0) {
            return getFirst();
        }
        else if (index == length - 1) {
            return getLast();
        }
        
        Node current = head;
        
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        
        return current.getValue();
    }
    
    public long getFirst() {
        return (head != null) ? head.getValue() : null;
    }
    
    public long getLast() {
        return (tail != null) ? tail.getValue() : null;
    }
    
    public long remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        
        if (index == 0) {
            return removeFirst();
        }
        else if (index == length - 1) {
            return removeLast();
        }
        
        Node current = head;
        
        while (index > 0) {
            current = current.getNext();
            index--;
        }
        
        Node temp = current;
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        length--;
        return temp.getValue();
    }
    
    public boolean remove(long value) {
        Node current = head;
        
        while (current != null && current.getValue() != value) {
            current = current.getNext();
        }
        
        if (current == null) {
            return false;
        }
        
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        length--;
        return true;
    }
    
    public long removeFirst() {
        if (length == 0) {
            throw new IllegalStateException("Empty list");
        }
        
        Node temp = head;
        head = head.getNext();
        length--;
        return temp.getValue();
    }
    
    public long removeLast() {
        if (length == 0) {
            throw new IllegalStateException("Empty list");
        }
        
        Node temp = tail;
        tail = tail.getPrevious();
        length--;
        return temp.getValue();
    }
    
    public void set(int index, long value) {
        checkIndex(index);
        
        if (index == 0) {
            head.setValue(value);
        }
        else if (index == length - 1) {
            tail.setValue(value);
        }
        else {
            Node current = head;
            
            while (index > 0) {
               current = current.getNext();
               index--;
            }
            
            current.setValue(value);
        }
    }
    
    public int size() {
        return length;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        Node current = head;
        
        while (current != null) {
            if (current == tail) {
                output.append(tail.getValue()).append("]");
                current = null;
            }
            else {
                output.append(current.getValue()).append(", ");
                current = current.getNext();
            }
        }
        
        if (output.toString().equals("[")) {
            output.append("]");
        }
        
        return output.toString();
    }
    
    public Node getHead() {
        return (head != null) ? head : null;
    }
    
    public Node getTail() {
        return (tail != null) ? tail : null;
    }
    
    private void checkIndex(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }
    }
}