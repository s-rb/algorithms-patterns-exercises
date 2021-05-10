package ru.list.surkovr.patterns.abstractFactory;

public class RouteFactory {

    public static Route getRoute(RouteAbstractFactory factory) {
        return factory.createRoute();
    }
}
