package ru.list.surkovr.patterns.decorator;

public class WashingMachine {

    public static void main(String[] args) {

        BasicWashingProgram program = new BasicWashingProgram();
        DoubleSpinningProgram spiningProgram = new DoubleSpinningProgram(program);
        BoilingWashingProgram  boilingProgram = new BoilingWashingProgram(spiningProgram);
        boilingProgram.executeProgram();
    }
}
