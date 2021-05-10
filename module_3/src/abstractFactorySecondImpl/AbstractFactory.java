package abstractFactorySecondImpl;

public abstract class AbstractFactory {
    public abstract Mage createMage();
    public abstract Archer createArcher();
    public abstract Warrior createWarrior();

interface Mage {
        public void cast();
}
interface Archer {
        public void shoot();
}
interface Warrior {
        public void attack();
}

class ElfSquadronFactory extends AbstractFactory {

    @Override
    public Mage createMage() {
        return new ElfMage();
    }

    @Override
    public Archer createArcher() {
        return new ElfArcher();
    }

    @Override
    public Warrior createWarrior() {
        return new ElfWarrior();
    }
}


    private class ElfMage implements Mage {
        @Override
        public void cast() {
        }
    }

    private class ElfArcher implements Archer {
        @Override
        public void shoot() {
        }
    }

    private class ElfWarrior implements Warrior {
        @Override
        public void attack() {

        }
    }
}
