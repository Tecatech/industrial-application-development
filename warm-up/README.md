# ���������� ������� ����� � ���� � Java

## ��������

�������� ��������� ������ � Java ������������ ����������� ������� `JVM`. ��� ����� ������ �� �������� � ������ ��������� �������:

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/java_memory_area_parts.png)

## �������� ������ � Java

������������ ��� ���������� ������������� ������, ��� ������� ������ ���������� ��� ��������� ���������� � ���������� ���������� ���� ��������������� ��� ������ �� �������. �������� ������ �� �������, ���������� � ����. ����� ���������� ������ ������, ���������� ������ ���� ����������, ���������. ��������� � ������������ ���������� �������, ��� � ������ ����. ��� ����������, ��� ��� ������ � ������ ����� �������� ������ �������� ������. ���� ������ ����� ���������, �� `JVM` ���������� ���������� `StackOverflowException`.

�����������:

```java
import java.io.*;

class User {
    public static void main (String[] args) {
        int a[] = new int[5];
    }
}
```

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/diagrammic_explanation.png)

������:

+ `a` � ����������-������, ���������� � �����;
+ �������� ����� `new` ������������ ��� ��������� ������ � ����;
+ `5` � ������ �������.

## ������ �������� ������

������ ���, ����� �� �������� �����, ����� ������ ���������� �� �������� ������ �����. ���� ���� ������ �������� � �����, �� ���� ��� ������ �� ����� ��������. � ���� ������ ������� ���������� �������� � ���� ������� � ��������� ���������� `java.lang.StackOverflowError`. ��� �������������, ����� �� �������� �����, � ���� ��� ���� ��������. � ����������� ������� ������ ������� ����������, ����� ����� ���������� ���������� ��� ������-���� ����������� ������� ����������.

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/stack_overflow.png)

���������� ������ ���������� ���������� �����, ����� ����������������� �������������:

```java
import java.io.*;

public class User {
    public static int factorial(int n) {
        return n * factorial(n - 1);
    }
    
    public static void main (String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }
}
```

����� �������:

```bash
$ javac main.java
$ java User
Exception in thread "main" java.lang.StackOverflowError
        at User.factorial(main.java:5)
```

## ������ ������ � Java

������������ ��� ��������� ������ ��� ������� � ������ `JRE`. ������ ������ �������� � ����, � �� ����� ��� ������ �� ���� �������� � �����. ������ � ������ ���� ���������� ����� ��������, ��� � �������� ������ ����� �������������� �������� ������, ������������� ��������� �������������� ��������. ���� ������ ������ ���������, �� `JVM` ���������� ���������� `java.lang.OutOfMemoryError`.

�����������:

```java
import java.io.*;

public class User {
    public static class Student {
        int ID;
        String name;
        
        Student(int ID, String name) {
            this.ID = ID;
            this.name = name;
        }
    }
    
    public static void main (String[] args) {
        int ID = 1;
        String name = "Sanya";
        
        Student student = new Student(ID, name);
        System.out.println("Student ID: " + student.ID);
        System.out.println("Student name: " + student.name);
    }
}
```

����� �������:

```bash
$ javac main.java
$ java User
Student ID: 1
Student name: Sanya
```

## ������ ������ ������

������ ���, ����� �� ������� ����� ����� �������� � ������ ����, � ��� ����� ����������� �� �������� �����, `JVM` ����������� ���������� `java.lang.OutOfMemoryError`. ������� ������ ������� ������� ��� ������, �� �� ����� ������� �������, ������� ������. ����� ������� ����� �������� ����������� �������� ������ �� ������������� �������.

�����������:

```java
import java.io.*;

public class User {
    public static void main (String[] args) {
        Long a[] = new Long[100000 * 10000];
    }
}
```

����� �������:

```bash
$ javac main.java
$ java User
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at User.main(main.java:5)
```

���������: � ���������� ������� �������������� ������� ������������� ������� � ����� ������� ��������, � ���� ����������� ������������ ��� ��������� ������ ��� ���� ������.