package ru.list.surkovr.exercises.arrays_and_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.list.surkovr.exercises.arrays_and_strings.Task8substringRotation.isRotatedSubstring;
import static ru.list.surkovr.exercises.arrays_and_strings.Task8substringRotation.isRotatedSubstring_2impl;

public class Task8SubstringRotationTest {

    public static final String SRC_STR_1 = "waterbottle";
    public static final String SRC_STR_2 = "ewaterbottl";
    public static final String NOT_ROTATED_SUBSTRING = "not rotated substring";

    @Test
    public void isRotatedSubstringTest() {
        String s1 = SRC_STR_1;
        String s2 = SRC_STR_2;
        boolean actual = isRotatedSubstring(s1, s2);
        assertThat(actual).isTrue();
    }

    @Test
    public void isRotatedSubstringTestFalse() {
        String s1 = SRC_STR_1;
        String s2 = NOT_ROTATED_SUBSTRING;
        boolean actual = isRotatedSubstring(s1, s2);
        assertThat(actual).isFalse();
    }

    @Test
    public void isRotatedSubstring_2implTest() {
        String s1 = SRC_STR_1;
        String s2 = SRC_STR_2;
        boolean actual = isRotatedSubstring_2impl(s1, s2);
        assertThat(actual).isTrue();
    }

    @Test
    public void isRotatedSubstring_2implTestFalse() {
        String s1 = SRC_STR_1;
        String s2 = NOT_ROTATED_SUBSTRING;
        boolean actual = isRotatedSubstring_2impl(s1, s2);
        assertThat(actual).isFalse();
    }

    @Test
    public void isRotatedSubstringTestNull() {
        String s1 = null;
        String s2 = null;
        boolean actual = isRotatedSubstring(s1, s2);
        assertThat(actual).isFalse();
    }

    @Test
    public void isRotatedSubstringTestEmpty() {
        String s1 = "";
        String s2 = "";
        boolean actual = isRotatedSubstring(s1, s2);
        assertThat(actual).isFalse();
    }

    @Test
    public void isRotatedSubstring_2implTestNull() {
        String s1 = null;
        String s2 = null;
        boolean actual = isRotatedSubstring_2impl(s1, s2);
        assertThat(actual).isFalse();
    }

    @Test
    public void isRotatedSubstring_2implTestEmpty() {
        String s1 = "";
        String s2 = "";
        boolean actual = isRotatedSubstring_2impl(s1, s2);
        assertThat(actual).isFalse();
    }
}
