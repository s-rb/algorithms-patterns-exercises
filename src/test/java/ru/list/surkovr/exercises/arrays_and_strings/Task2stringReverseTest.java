package ru.list.surkovr.exercises.arrays_and_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.list.surkovr.exercises.arrays_and_strings.Task2stringReverse.reverseCstyleString;

public class Task2stringReverseTest {

    @Test
    public void reverse() {
        String s = "String to reverse";
        String res = reverseCstyleString(s);
        Assertions.assertThat(res).isNotNull().isEqualTo('\u0000' + "esrever ot gnirtS");
    }
}
