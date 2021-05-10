package ru.list.surkovr.patterns.strategy;

public class StrategyTest {

    public static void main(String[] args) {

        // Collections.sort(); - Также стратегия. Разное поведение в зависимости от переданного компаратора

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Item("Торт медовик", 650), 1);
        cart.addItem(new Item("Молоко 3,5%", 56), 4);
        cart.addItem(new Item("Хлеб белый", 28), 1);

        // Pay by credit card
        cart.pay(new CreditCard("4263763372221218", "Dmitriy Petrov", "12.20"));

        // Paye by cash
        cart.pay(new Cash());

        //Pay by YandexMoney
        cart.pay(new YandexMoney("74879327478329844"));
    }
}
