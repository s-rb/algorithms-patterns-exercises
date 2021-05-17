# Algorithms and Data structures
Simple implementations of some algorithms and data structures

## Algorithms:
* Binary search
* Bubble sort
* Merge sort
* Quick sort
* Rabin-Karp algorithm for searching substring
* Array Max Value (linear) - O(n)

## Data structures:
- Single linked list
- Double linked list
- Binary tree

# Design patters

Implementation of some popular design patterns:
* [Factory](src/main/java/ru/list/surkovr/patterns/factory)
* [AbstractFactory](src/main/java/ru/list/surkovr/patterns/abstractFactory)
* [Decorator](src/main/java/ru/list/surkovr/patterns/decorator)
* [Bridge](src/main/java/ru/list/surkovr/patterns/bridge)
* [Iterator](src/main/java/ru/list/surkovr/patterns/iterator)
* [Observer](src/main/java/ru/list/surkovr/patterns/observer)
* [Strategy](src/main/java/ru/list/surkovr/patterns/strategy)
* [Singleton](src/main/java/ru/list/surkovr/patterns/singleton)
* [Adapter](src/main/java/ru/list/surkovr/patterns/adapter)

## Решение задач из книги Cracking the coding interview.


```/*
Сложность некоторых запросов:
- Поиск минимального значения в массиве чисел длиной n, который отсортирован по возрастанию.
  ==>  O(1), т.к. известно что мин.значение в начале и обратиться можем по индексу

- Расчёт среднего значения в массиве чисел длиной n.
  ==> O(n), так как нужно обратиться к каждому числу, чтобы сложить и затем в одно действие разделить на общее количество

- Получение длины массива размером n.
  ==> O(1) массивы при создании имеют известный размер, который не меняется

- Задан список из n объектов, каждый из которых представляет собой банковский счёт - ArrayList<Bill>.
  И есть класс и метод, с помощью которых можно получить общую сумму транзакций между первым и вторым счётом -
  TransactionsCalculator.calculateTotalSum(Bill sourceBill, Bill destinationBill).
  Алгоритм должен, используя этот метод, посчитать общую сумму переводов между всеми счетами из списка.
  ==> Попарно сложить все данные между каждой парой счетов - потребуется (n-1)! операций. Сложность составит O(n)
  */