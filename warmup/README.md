# ���������� ������� ����� � ���� � Java

## ��������

�������� ��������� ������ � Java ������������ ����������� ������� `JVM`. ��� ����� ������ �� �������� � ������ ��������� �������:

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warmup/assets/java_memory_area_parts.png)

## �������� ������ � Java

������������ ��� ���������� ������������� ������, ��� ������� ������ ���������� ��� ��������� ���������� � ���������� ���������� ���� ��������������� ��� ������ �� �������. �������� ������ �� �������, ���������� � ����. ����� ���������� ������ ������, ���������� ������ ���� ����������, ���������. ��������� � ������������ ���������� �������, ��� � ������ ����. ��� ����������, ��� ��� ������ � ������ ����� �������� ������ �������� ������. ���� ������ ����� ���������, �� `JVM` ���������� ���������� `StackOverflowException`.

�����������:

```java
import java.io.*;

public class StackUser {
    public static void main(String[] args) {
        int a[] = new int[5];
    }
}
```

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warmup/images/diagrammic_explanation.png)

������:

+ `a` � ����������-������, ���������� � �����;
+ �������� ����� `new` ������������ ��� ��������� ������ � ����;
+ `5` � ������ �������.

## ������ �������� ������

������ ���, ����� �� �������� �����, ����� ������ ���������� �� �������� ������ �����. ���� ���� ������ �������� � �����, �� ���� ��� ������ �� ����� ��������. � ���� ������ ������� ���������� �������� � ���� ������� � ��������� ���������� `java.lang.StackOverflowError`. ��� �������������, ����� �� �������� �����, � ���� ��� ���� ��������. � ����������� ������� ������ ������� ����������, ����� ����� ���������� ���������� ��� ������-���� ����������� ������� ����������.

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warmup/images/stack_overflow.png)

���������� ������ ���������� ���������� �����, ����� ����������������� �������������:

```java
import java.io.*;

public class StackUser {
    public static int factorial(int n) {
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }
}
```

����� �������:

```sh
$ javac StackUser.java
$ java StackUser
Exception in thread "main" java.lang.StackOverflowError
        at StackUser.factorial(StackUser.java:5)
```

## ������ ������ � Java

������������ ��� ��������� ������ ��� ������� � ������ `JRE`. ������ ������ �������� � ����, � �� ����� ��� ������ �� ���� �������� � �����. ������ � ������ ���� ���������� ����� ��������, ��� � �������� ������ ����� �������������� �������� ������, ������������� ��������� �������������� ��������. ���� ������ ������ ���������, �� `JVM` ���������� ���������� `java.lang.OutOfMemoryError`.

�����������:

```java
import java.io.*;

public class HeapUser {
    public static class Student {
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
```

����� �������:

```sh
$ javac HeapUser.java
$ java HeapUser
Student ID: 1
Student name: Sanya
```

## ������ ������ ������

������ ���, ����� �� ������� ����� ����� �������� � ������ ����, � ��� ����� ����������� �� �������� �����, `JVM` ����������� ���������� `java.lang.OutOfMemoryError`. ������� ������ ������� ������� ��� ������, �� �� ����� ������� �������, ������� ������. ����� ������� ����� �������� ����������� �������� ������ �� ������������� �������.

�����������:

```java
import java.io.*;

public class HeapUser {
    public static void main(String[] args) {
        Long a[] = new Long[100000 * 10000];
    }
}
```

����� �������:

```sh
$ javac HeapUser.java
$ java HeapUser
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at HeapUser.main(HeapUser.java:5)
```

���������: � ���������� ������� �������������� ������� ������������� ������� � ����� ������� ��������, � ���� ����������� ������������ ��� ��������� ������ ��� ���� ������.