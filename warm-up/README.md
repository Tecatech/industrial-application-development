# Управление памятью стека и кучи в Java

## Введение

Распределение памяти в Java управляется виртуальной машиной `JVM`. Она делит память на стековую и кучную следующим образом:

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/java_memory_area_parts.png)

## Стековая память в Java

Используется для временного выделения памяти, при котором память выделяется под локальные переменные и переменные ссылочного типа непосредственно при вызове их методов. Содержит ссылки на объекты, хранящиеся в куче. После выполнения метода память, содержащая такого рода переменные, очищается. Выделение и освобождение происходит быстрее, чем в памяти кучи. Это безопаснее, так как доступ к данным может получить только владелец потока. Если память стека заполнена, то `JVM` генерирует исключение `StackOverflowException`.

Иллюстрация:

```java
import java.io.*

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

Всякий раз, когда мы вызываем метод, после его выполнения он покидает память стека. Если ваши методы остаются в стеке, то рано или поздно стек будет заполнен. В этом случае попытка добавления элемента в стек приведёт к генерации исключения `java.lang.StackOverflowError`. Оно выбрасывается, когда мы вызываем метод, а стеке при этом заполнен. В большинстве случаев данное явление происходит, когда метод вызывается рекурсивно без какого-либо корректного условия завершения.

![alt text](https://github.com/tecatech/industrial-application-development/blob/main/warm-up/assets/stack_overflow.png)

Рассмотрим пример вычисления факториала числа, чтобы проиллюстрировать вышесказанное:

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

Вывод консоли:

```bash
at User.factorial(main.java:10)
```