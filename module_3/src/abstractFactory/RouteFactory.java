package abstractFactory;

public class RouteFactory {

    public static Route getRoute(RouteAbstractFactory factory) {
        return factory.createRoute();
    }
}
