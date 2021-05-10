package surkovr.list.ru;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import leetcode.easy.NewPart1;

class NewPart1Test {

    private final NewPart1 newPart1 = new NewPart1();

    @Test
    void reverseInt() {
        final int actual = newPart1.reverseInt(-321);
        assertThat(actual).isEqualTo(-123);
    }

    @Test
    void plusOne() {
        int[] actual = newPart1.plusOne(new int[]{9});
        assertThat(actual).isEqualTo(new int[]{1, 0});
    }
}