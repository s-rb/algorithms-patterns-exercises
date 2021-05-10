package ru.list.surkovr.patterns.abstractFactory;

import java.awt.*;
import java.util.List;

public class CarRoute extends Route {

    private double costPerKm;
    private double costPerMin;
    private double averageSpeed;

    public CarRoute(List<Point> points) {
        super(points);
    }

    public double calculateCost() {
        return costPerKm * calculateLength();
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Override
    public double calculateDuration() {
        return calculateLength() / averageSpeed;
    }

    @Override
    public double calculateLength() {
        double totalLength = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            totalLength += LengthCalculator.getLength(
                    points.get(i), points.get(i + 1));
        }
        return totalLength;
    }
}
