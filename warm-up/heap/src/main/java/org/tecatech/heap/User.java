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
        
        Student student = new Student(ID, name);
        System.out.println("Student ID: " + student.ID);
        System.out.println("Student name: " + student.name);
    }
}