package factorySecondImpl;


public class Factory {


    public AbstractWriter getWriter(AbstractWriter writer) {
        AbstractWriter abstractWriter = null;
        if (writer instanceof ConcreteWriter) {
            abstractWriter = new ConcreteWriter();
        } else if (writer instanceof XMLWriter) {
            abstractWriter = new XMLWriter();
        }
        return abstractWriter;
    }


    abstract class AbstractWriter {
        public abstract void write();
    }

    class ConcreteWriter extends AbstractWriter {
        @Override
        public void write() {
            // write somethinge to file
        }
    }

    class XMLWriter extends AbstractWriter {
        @Override
        public void write() {
            // write to XML файл
        }
    }
}
