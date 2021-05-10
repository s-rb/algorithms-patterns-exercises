package ru.list.surkovr.patterns.iterator;

public class IteratorTest {

    public static void main(String[] args) {
        OrderCollectionImpl orders = new OrderCollectionImpl();
        generateOrders(orders);

        OrderIterator iterator = orders.iterator(DeliveryType.AIRPLANE);
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order);
        }
    }

    public static void generateOrders(OrderCollectionImpl orders) {
        for (int i = 0; i < 30; i++) {
            Order order = new Order((int) (Math.random() * Math.random() * 5000),
                    DeliveryType.values()[(int) (Math.random() * 7)]);
            orders.addOrder(order);
        }
    }
}
