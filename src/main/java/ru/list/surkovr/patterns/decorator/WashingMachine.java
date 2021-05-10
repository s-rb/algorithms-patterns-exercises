package ru.list.surkovr.patterns.decorator;

public class WashingMachine {

    public static void main(String[] args) {

        /**
         * Добавление функциональности
         *
         * EXAMPLE
         *         FileInputStream fis = new FileInputStream("someFile.gz");
         *         BufferedInputStream bis = new BufferedInputStream(fis);
         *         GZIPInputStream gis= new GZIPInputStream(bis);
         *         ObjectInputStream ois = new ObjectInputStream(gis); // Если есть сериализованные Java объекты
         *         SomeObject someObject = (SomeObject) ois.readObject();
         *         // Закрывается у самого верхнего стрима
         *         ois.close();
         */

        BasicWashingProgram program = new BasicWashingProgram();
        DoubleSpinningProgram spiningProgram = new DoubleSpinningProgram(program);
        BoilingWashingProgram  boilingProgram = new BoilingWashingProgram(spiningProgram);
        boilingProgram.executeProgram();
    }
}
