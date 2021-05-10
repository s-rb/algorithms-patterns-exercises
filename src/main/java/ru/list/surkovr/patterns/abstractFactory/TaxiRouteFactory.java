package ru.list.surkovr.patterns.abstractFactory;

import java.awt.*;
import java.util.List;

public class TaxiRouteFactory implements RouteAbstractFactory {

    private List<Point> points;
    private double costPerKm;
    private double costPerMin;

    public TaxiRouteFactory(List<Point> points, double costPerKm, double costPerMin) {
        this.points = points;
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
    }

    @Override
    public Route createRoute() {
        TaxiRoute route = new TaxiRoute(points);
        route.setCostPerKm(costPerKm);
        route.setCostPerMin(costPerMin);
        route.setAverageSpeed(SpeedProvider.getSpeed(
                points.get(0), points.get(points.size() - 1)
        ));
        return route;
    }
}
