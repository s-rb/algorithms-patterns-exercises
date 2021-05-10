package ru.list.surkovr.patterns.decorator;

public class DoubleSpinningProgram extends SpecialWashingProgram {

    public DoubleSpinningProgram(BasicWashingProgram washingProgram) {
        super(washingProgram);
    }

    @Override
    public void executeProgram() {
        BasicWashingProgram washingProgram = (BasicWashingProgram) this.washingProgram;
        washingProgram.executeProgram();
        for (int i = 0; i < 10; i++) {
            washingProgram.rotateDrum(-60);
            washingProgram.rotateDrum(60);
        }
        washingProgram.rotateDrum(1500);
        washingProgram.drainOff();
    }
}
