package org.tecatech.heap;

class User {
    static class Student {
        int ID;
        String name;
        
        Student(int ID, String name) {
            this.ID = ID;
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        int ID = 1;
        String name = "Sanya";
        
        Student st = new Student(ID, name);
        System.out.println("Student ID: " + st.ID);
        System.out.println("Student name: " + st.name);
    }
}