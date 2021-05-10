package recursion;

import org.junit.Assert;
import org.junit.Test;
import ru.list.surkovr.algorithms.iteration_vs_recursion.Power;

public class PowerTest {

    @Test
    public void getPowered() {
        int src = 2;
        int pow = 8;
        int actual = Power.getPowered(src, pow);
        Assert.assertEquals(256, actual);
    }

    @Test
    public void getPowered2() {
        int src = 3;
        int pow = 18;
        int actual = Power.getPowered(src, pow);
        Assert.assertEquals(387420489, actual);
    }
}
