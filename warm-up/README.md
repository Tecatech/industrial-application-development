# ���������� ������� ����� � ���� � Java

## ��������

������������� ������ � Java ����������� ����������� ������� `JVM`. ��� ����� ������ �� �������� � ������ ��������� �������:

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/java_memory_area_parts.png)

## �������� ������ � Java

������������ ��� ���������� ��������� ������, ��� ������� ������ ���������� ��� ��������� ���������� � ���������� ���������� ���� ��������������� ��� ������ �� �������. �������� ������ �� �������, ���������� � ����. ����� ���������� ������ ������, ���������� ������ ���� ����������, ���������. ��������� � ������������ ���������� �������, ��� � ������ ����. ��� ����������, ��� ��� ������ � ������ ����� �������� ������ �������� ������. ���� ������ ����� ���������, �� `JVM` ���������� ���������� `StackOverflowException`.

�����������:

```java
import java.io.*

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

������ ���, ����� �� �������� �����, ����� ��� ���������� �� �������� ������ �����. ���� ���� ������ �������� � �����, �� ���� ��� ������ ���� ����� ��������. � ���� ������ ������� ���������� �������� � ���� ������� � ��������� ���������� `java.lang.StackOverflowError`. ��� �������������, ����� �� �������� �����, � ����� ��� ���� ��������. � ����������� ������� ������ ������� ����������, ����� ����� ���������� ���������� ��� ������-���� ����������� ������� ����������.

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/stack_overflow.png)

���������� ������ ���������� ���������� �����, ����� ����������������� �������������:

```java
import java.io.*

class User {
    public static void main (String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }
    
    static int factorial(int n) {
        return n * factorial(n - 1);
    }
}
```

����� �������:

```bash
at User.factorial(main.java:10)
```