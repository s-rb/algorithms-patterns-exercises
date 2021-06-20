package ru.list.surkovr.exercises.arrays_and_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.list.surkovr.exercises.arrays_and_strings.Task5replaceSpaces.replaceAllSpaces;

public class Task5ReplaceSpacesTest {

    @Test
    public void replaceAllSpacesTest() {
        String s = "String to replace all spaces !";
        String expected = "String%20to%20replace%20all%20spaces%20!";
        String actual = replaceAllSpaces(s);
        Assertions.assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    public void replaceAllSpacesTestNull() {
        String s = null;
        String actual = replaceAllSpaces(s);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void replaceAllSpacesTestEmpty() {
        String s = "";
        String actual = replaceAllSpaces(s);
        Assertions.assertThat(actual).isNull();
    }
}
