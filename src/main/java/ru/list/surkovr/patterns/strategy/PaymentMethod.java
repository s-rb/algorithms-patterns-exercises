package ru.list.surkovr.patterns.strategy;

public interface PaymentMethod {

    boolean pay(int amount);
}
