# Управление памятью стека и кучи в Java

## Введение

Механизм выделения памяти в Java регулируется виртуальной машиной `JVM`. Она делит память на стековую и кучную следующим образом:

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/java_memory_area_parts.png)

## Стековая память в Java

Используется для временного распределения памяти, при котором память выделяется под локальные переменные и переменные ссылочного типа непосредственно при вызове их методов. Содержит ссылки на объекты, хранящиеся в куче. После выполнения метода память, содержащая такого рода переменные, очищается. Выделение и освобождение происходит быстрее, чем в памяти кучи. Это безопаснее, так как доступ к данным может получить только владелец потока. Если память стека заполнена, то `JVM` генерирует исключение `StackOverflowException`.

Иллюстрация:

```java
import java.io.*;

class User {
    public static void main (String[] args) {
        int a[] = new int[5];
    }
}
```

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/diagrammic_explanation.png)

Выводы:

+ `a` – переменная-массив, хранящаяся в стеке;
+ ключевое слово `new` используется для выделения памяти в куче;
+ `5` – размер массива.

## Ошибка стековой памяти

Всякий раз, когда мы вызываем метод, после своего выполнения он покидает память стека. Если наши методы остаются в стеке, то рано или поздно он будет заполнен. В этом случае попытка добавления элемента в стек приведёт к генерации исключения `java.lang.StackOverflowError`. Оно выбрасывается, когда мы вызываем метод, а стек при этом заполнен. В большинстве случаев данное явление происходит, когда метод вызывается рекурсивно без какого-либо корректного условия завершения.

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/stack_overflow.png)

Рассмотрим пример вычисления факториала числа, чтобы проиллюстрировать вышесказанное:

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

Вывод консоли:

```bash
$ javac main.java
$ java User
Exception in thread "main" java.lang.StackOverflowError
        at User.factorial(main.java:5)
```

## Кучная память в Java

Используется для выделения памяти под объекты и классы `JRE`. Объект всегда создаётся в куче, в то время как ссылка на него хранится в стеке. Доступ к памяти кучи происходит более медленно, чем к стековой памяти ввиду задействования сборщика мусора, занимающегося удалением неиспользуемых объектов. Если кучная память заполнена, то `JVM` генерирует исключение `java.lang.OutOfMemoryError`.

Иллюстрация:

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

Вывод консоли:

```bash
$ javac main.java
$ java User
Student ID: 1
Student name: Sanya
```

## Ошибка кучной памяти

Всякий раз, когда мы создаем много новых объектов в памяти кучи, а для новых экземпляров не остается места, `JVM` выбрасывает исключение `java.lang.OutOfMemoryError`. Сборщик мусора удаляет объекты без ссылок, но не может стереть объекты, имеющие ссылки. Этого явления можно избежать посредством удаления ссылок на нежелательные объекты.

Иллюстрация:

```java
import java.io.*;

public class User {
    public static void main (String[] args) {
        Long a[] = new Long[100000 * 10000];
    }
}
```

Вывод консоли:

```bash
$ javac main.java
$ java User
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at User.main(main.java:5)
```

Пояснение: в приведённом примере осуществляется попытка инициализации массива с очень большим размером, и кучи оказывается недостаточно для выделения памяти под этот массив.