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

## Solving problems from the book Cracking the coding interview.
* [Does the string contain unique characters](src/main/java/ru/list/surkovr/exercises/arrays_and_strings/Task1stringUniqueChars.java)


```/*
Complexity of some queries:
- Search for the minimum value in an array of numbers of length n, which is sorted in ascending order.
  ==> O(1), because we know that the minimum value is at the beginning and we can access it by index

- Calculation of the average value in an array of numbers of length n.
  ==> O(n), since you need to access each number to add and then divide by the total in one step

- Getting the length of an array of size n.
  ==> O(1) arrays when created have a known size that does not change

- Given a list of n objects, each of which represents a bank account - ArrayList<Bill>.
  And there is a class and method with which you can get the total amount of transactions between the first and second account -
  TransactionsCalculator.calculateTotalSum(Bill sourceBill, Bill destinationBill).
  The algorithm should, using this method, calculate the total amount of transfers between all accounts from the list.
  ==> Add all the data between each pair of accounts in pairs - you will need (n-1)! operations. The complexity will be O(n)
  */