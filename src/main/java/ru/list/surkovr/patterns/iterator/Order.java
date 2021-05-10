package ru.list.surkovr.patterns.iterator;

public class Order {

    private DeliveryType deliveryType;
    private int price;

    public Order(int price, DeliveryType deliveryType) {
        this.price = price;
        this.deliveryType = deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public String toString() {
        return "Price: " + price + ", delivery by: " + deliveryType.toString();
    }
}
