package ru.mephi.lab1.Map;

public class Node {
    private Object key;
    private Object value;
    
    public Node() {
        key = null;
        value = null;
    }
    
    public Node(Object item, Object data) {
        key = item;
        value = data;
    }
    
    public Object getKey() {
        return key;
    }
    
    public Object getValue() {
        return value;
    }
    
    public Object setKey(Object item, Object data) {
        if (value.equals(data)) {
            Object temp = key;
            key = item;
            return temp;
        }
        
        return null;
    }
    
    public Object setValue(Object item, Object data) {
        if (key.equals(item)) {
            Object temp = value;
            value = data;
            return temp;
        }
        
        return null;
    }
}