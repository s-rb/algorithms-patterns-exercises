package iteratorSecondImpl;

import java.util.Iterator;
import java.util.NoSuchElementException;

class IteratorSecondImpl {
    public static void main(String[] args) {
        // Создаем монстра
        Monster monster = new Monster();
        // отрубим голову
        monster.setHead(null);
        // создаем итератор
        Iterator iterator = new MonsterIterator(monster);
        // Есть ли еще части?
        System.out.println(iterator.hasNext()); // true
        // Какая следующая часть
        System.out.println(iterator.next()); // Hand
        // а еще есть?
        System.out.println(iterator.hasNext()); // true
        // Какая следующая часть
        System.out.println(iterator.next()); // Leg
        // а если отрубить
        iterator.remove();
        // а еще есть?
        System.out.println(iterator.hasNext()); // false
        // что с ногой?
        System.out.println(monster.getTheOnlyLeg()); // null
    }
}

    // условно - голова - индекс 0, рука - 1, нога - индекс - 2
    class MonsterIterator implements Iterator<Monster.Part> {
        private int index = -1;
        private Monster m;
        public MonsterIterator(Monster m) { this.m = m;
        }
        @Override
        public boolean hasNext() {
            if (index == -1) return m.hasHead() || m.hasHand() || m.hasLeg();
            if (index == 0) return m.hasHand() || m.hasLeg();
            if (index == 1) return m.hasLeg();
            return false;
        }

        @Override
        public Monster.Part next() {
            if (index == -1) {
                if (m.hasHead()) { index = 0; return m.getHead(); }
                if (m.hasHand()) { index = 1; return m.getTheOnlyHand(); }
                if (m.hasLeg()) { index = 2; return m.getTheOnlyLeg();                }
            }
            if (index == 0) {
                if (m.hasHand()) { index = 1; return m.getTheOnlyHand(); }
                if (m.hasLeg()) { index = 2; return m.getTheOnlyLeg();                }
            }
            if (index == 1) {
                if (m.hasLeg()) { index = 2; return m.getTheOnlyLeg();                }
            }
            throw new NoSuchElementException();
        }
        @Override
        public void remove() {
            if (index == -1) throw new IllegalStateException();
            if (index == 0) {
                if (m.hasHead()) m.setHead(null);
                else throw new IllegalStateException();
            }
            if (index == 1) {
                if (m.hasHand()) m.setTheOnlyHand(null);
                else throw new IllegalStateException();
            }
            if (index == 2) {
                if (m.hasLeg()) m.setTheOnlyLeg(null);
                else throw new IllegalStateException();
            }
        }
    }


    class Monster {
        private Head head = new Head();
        private Hand theOnlyHand = new Hand();
        private Leg theOnlyLeg = new Leg();

        public Head getHead() {
            return head;
        }

        public void setHead(Head o) {
            this.head = o;
        }

        public boolean hasHead() {
            return head != null;
        }

        public Hand getTheOnlyHand() {
            return theOnlyHand;
        }

        public void setTheOnlyHand(Hand hand) {
            this.theOnlyHand = hand;
        }

        public boolean hasHand() {
            return theOnlyHand != null;
        }

        public Leg getTheOnlyLeg() {
            return theOnlyLeg;
        }

        public void setTheOnlyLeg(Leg leg) {
            this.theOnlyLeg = leg;
        }

        public boolean hasLeg() {
            return theOnlyLeg != null;
        }

        public interface Part { // Маркерный
        }

        class Head implements Part {
        }

        class Hand implements Part {
        }

        class Leg implements Part {
        }
    }