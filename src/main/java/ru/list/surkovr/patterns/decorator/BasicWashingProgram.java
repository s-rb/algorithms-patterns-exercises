package ru.list.surkovr.patterns.decorator;

public class BasicWashingProgram implements WashingProgram {

    public void fillByWater() {
        System.out.println("Filling by new water");
    }

    public void takePowder() {
        System.out.println("Taking powder");
    }

    public void rotateDrum(int speed) {
        System.out.println("Rotating drum with speed " + speed + " rpm");
    }

    public void drainOff() {
        System.out.println("Draining off the water");
    }

    @Override
    public void executeProgram() {
        fillByWater();
        takePowder();
        for (int i = 0; i < 20; i++) {
            rotateDrum(60);
            rotateDrum(-60);
        }
        drainOff();
        rotateDrum(1500);
        drainOff();
        rotateDrum(1500);
    }
}
