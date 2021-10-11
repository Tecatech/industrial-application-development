package ru.mephi.lab2;

import org.junit.Assert;
import org.junit.Test;

public class MergeListTest {
    @Test
    public void mergeTest() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        
        list1.add(12);
        list1.add(39);
        list1.add(44);
        list1.add(63);
        list1.add(95);
        
        list2.add(26);
        list2.add(51);
        list2.add(77);
        list2.add(80);
        list2.add(108);
        
        String expected = "[12, 26, 39, 44, 51, 63, 77, 80, 95, 108]";
        
        MergeList list = new MergeList();
        Node current = list.merge(list1.getHead(), list2.getHead());
        
        StringBuilder actual = new StringBuilder("[");
        
        while (current != null) {
            if (current.getNext() == null) {
                actual.append(current.getValue()).append("]");
                current = null;
            }
            else {
                actual.append(current.getValue()).append(", ");
                current = current.getNext();
            }
        }
        
        Assert.assertEquals(expected, actual.toString());
    }
}