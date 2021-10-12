package ru.mephi.lab1;

public class Map {
    private final List data;
    
    public Map() {
        data = new List();
    }
    
    public Map(Node... items) {
        data = new List((Object[]) items);
    }
    
    public void put(Object key, Object value) {
        Node temp = new Node(key, value);
        data.add(temp);
    }
    
    public Object get(Object key) {
        for (int i = 0; i < data.size(); i++) {
            Node temp = (Node) data.get(i);
            
            if (temp.getKey().equals(key)) {
                return temp.getValue();
            }
        }
        
        return null;
    }
    
    public Object get(Object key, Object bydefault) {
        Object temp = get(key);
        
        if (temp == null) {
            put(key, bydefault);
            return bydefault;
        }
        else {
            return temp;
        }
    }
    
    public Object remove(Object key) {
        for (int i = 0; i < data.size(); i++) {
            Node temp = (Node) data.get(i);
            
            if (temp.getKey().equals(key)) {
                data.remove(i);
                return temp.getValue();
            }
        }
        
        return null;
    }
    
    public boolean keyContains(Object key) {
        return get(key) != null;
    }
    
    public List getKeys() {
        List keys = new List();
        
        for (int i = 0; i < data.size(); i++) {
            Node temp = (Node) data.get(i);
            keys.add(temp.getKey());
        }
        
        return keys;
    }
    
    public List getValues() {
        List values = new List();
        
        for (int i = 0; i < data.size(); i++) {
            Node temp = (Node) data.get(i);
            values.add(temp.getValue());
        }
        
        return values;
    }
    
    public List getEntries() {
        return data;
    }
    
    public int size() {
        return data.size();
    }
    
    public boolean isEmpty() {
        return data.Empty();
    }
    
    public static void main(String[] args) {
        Node[] items = new Node[5];
        Object[] keys = new Object[] {6, 17.92, "Nick", 9, 'G'};
        Object[] values = new Object[] {'P', 5, 9.48, "Sanya", 7};
        
        for (int i = 0; i < 5; i++) {
            items[i] = new Node(keys[i], values[i]);
        }
        
        Map map = new Map(items);
        
        Object key0, value0, value1, value2, value3;
        int size;
        boolean includes1, includes2, includes3, empty;
        
        System.out.println("------------------------------------------");
        
        map.put(11.32, "Kolya");
        map.put("Vlad", 31.46);
        map.put('H', "Alex");
        value1 = map.get(11.32);
        value2 = map.get("Vlad");
        value3 = map.get('H');
        System.out.println("map.get(11.32) = " + value1);
        System.out.println("map.get(\"Vlad\") = " + value2);
        System.out.println("map.get('H') = " + value3);
        System.out.println("------------------------------------------");
        
        value1 = map.get(6, 'X');
        value2 = map.get("Nick", 20.54);
        value3 = map.get(10, "Max");
        System.out.println("map.get(6, 'X') = " + value1);
        System.out.println("map.get(\"Nick\", 20.54) = " + value2);
        System.out.println("map.get(10, \"Max\") = " + value3);
        System.out.println("------------------------------------------");
        
        value1 = map.remove(9);
        value2 = map.remove("Gosha");
        value3 = map.remove(17.92);
        System.out.println("map.remove(9) = " + value1);
        System.out.println("map.remove(\"Gosha\") = " + value2);
        System.out.println("map.remove(17.92) = " + value3);
        System.out.println("------------------------------------------");
        
        includes1 = map.keyContains(6);
        includes2 = map.keyContains('M');
        includes3 = map.keyContains(11.32);
        System.out.println("map.keyContains(6) = " + includes1);
        System.out.println("map.keyContains('M') = " + includes2);
        System.out.println("map.keyContains(11.32) = " + includes3);
        System.out.println("------------------------------------------");
        
        size = map.size();
        System.out.println("map.size() = " + size);
        System.out.println("------------------------------------------");
        
        empty = map.isEmpty();
        System.out.println("map.isEmpty() = " + empty);
        System.out.println("------------------------------------------");
        
        for (int i = 0; i < size; i++) {
            key0 = map.getKeys().get(i);
            value0 = map.getValues().get(i);
            System.out.println("map.getKeys().get(" + i + ") = " + key0);
            System.out.println("map.getValues().get(" + i + ") = " + value0);
        }
        System.out.println("------------------------------------------");
        
        for (int i = 0; i < size; i++) {
            key0 = ((Node) map.getEntries().get(i)).getKey();
            value0 = ((Node) map.getEntries().get(i)).getValue();
            System.out.println("map.getEntries().get(" + i + ").getKey() = " + key0);
            System.out.println("map.getEntries().get(" + i + ").getValue() = " + value0);
        }
        System.out.println("------------------------------------------");
    }
}