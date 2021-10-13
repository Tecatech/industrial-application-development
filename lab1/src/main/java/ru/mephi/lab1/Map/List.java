package ru.mephi.lab1.Map;

public class List {
    private int length;
    private int capacity;
    private Object[] data;
    
    public List() {
        length = 0;
        capacity = 10;
        data = new Object[capacity];
    }
    
    public List(Object... values) {
        length = values.length;
        capacity = 2 * length;
        data = new Object[capacity];
        
        System.arraycopy(values, 0, data, 0, length);
    }
    
    public void add(Object value) {
        if (length == capacity) {
            resize();
        }
        
        data[length] = value;
        length++;
    }
    
    public Object remove(int index) {
        if (index >= 0 && index < length) {
            Object temp = data[index];
            
            System.arraycopy(data, index + 1, data, index, length - 1 - index);
            
            length--;
            return temp;
        }
        
        return null;
    }
    
    public void add(Object value, int index) {
        if (index >= 0 && index < length) {
            System.arraycopy(data, index, data, index + 1, length - index);
            
            data[index] = value;
            length++;
        }
        else if (index == length) {
            add(value);
        }
    }
    
    public Object get(int index) {
        if (index >= 0 && index < length) {
            return data[index];
        }
        
        return null;
    }
    
    public int indexOf(Object value) {
        for (int i = 0; i < length; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }
    
    public Object set(Object value, int index) {
        Object temp = get(index);
        
        if (temp != null) {
            data[index] = value;
        }
        
        return temp;
    }
    
    public int size() {
        return length;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public Object last() {
        return data[size() - 1];
    }
    
    private void resize() {
        Object[] temp = new Object[2 * capacity];
        
        System.arraycopy(data, 0, temp, 0, capacity);
        
        capacity *= 2;
        data = temp;
    }
    
    public static void main(String[] args) {
        List list = new List('P', 5, 9.48, "Sanya", 7);
        
        Object value0, value1, value2, value3;
        int index1, index2, index3, size;
        boolean includes1, includes2, includes3, empty;
        
        System.out.println("---------------------------");
        
        list.add("Kolya");
        value0 = list.last();
        System.out.println("list.last() = " + value0);
        System.out.println("---------------------------");
        
        value1 = list.remove(4);
        value2 = list.remove(-7);
        value3 = list.remove(9);
        System.out.println("list.remove(4) = " + value1);
        System.out.println("list.remove(-7) = " + value2);
        System.out.println("list.remove(9) = " + value3);
        System.out.println("---------------------------");
        
        list.add(14.57, 1);
        list.add('X', -8);
        list.add(8, 7);
        value1 = list.get(1);
        value2 = list.get(-8);
        value3 = list.get(6);
        System.out.println("list.get(1) = " + value1);
        System.out.println("list.get(-8) = " + value2);
        System.out.println("list.get(6) = " + value3);
        System.out.println("---------------------------");
        
        index1 = list.indexOf("Sanya");
        index2 = list.indexOf(-2);
        index3 = list.indexOf(14.57);
        System.out.println("list.indexOf(\"Sanya\") = " + index1);
        System.out.println("list.indexOf(-2) = " + index2);
        System.out.println("list.indexOf(14.57) = " + index3);
        System.out.println("---------------------------");
        
        includes1 = list.contains(5);
        includes2 = list.contains('M');
        includes3 = list.contains(9.48);
        System.out.println("list.contains(5) = " + includes1);
        System.out.println("list.contains('M') = " + includes2);
        System.out.println("list.contains(9.48) = " + includes3);
        System.out.println("---------------------------");
        
        value1 = list.set(13.26, 3);
        value2 = list.set(9, -4);
        value3 = list.set("Gosha", 8);
        System.out.println("list.set(13.26, 3) = " + value1);
        System.out.println("list.set(9, -4) = " + value2);
        System.out.println("list.set(\"Gosha\", 8) = " + value3);
        System.out.println("---------------------------");
        
        size = list.size();
        System.out.println("list.size() = " + size);
        System.out.println("---------------------------");
        
        empty = list.isEmpty();
        System.out.println("list.isEmpty() = " + empty);
        System.out.println("---------------------------");
        
        for (int i = 0; i < size; i++) {
            value0 = list.get(i);
            System.out.println("list.get(" + i + ") = " + value0);
        }
        
        System.out.println("---------------------------");
    }
}