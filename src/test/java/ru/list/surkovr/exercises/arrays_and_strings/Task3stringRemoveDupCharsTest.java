package ru.list.surkovr.exercises.arrays_and_strings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static ru.list.surkovr.exercises.arrays_and_strings.Task3stringRemoveDupChars.removeDupChars;
import static ru.list.surkovr.exercises.arrays_and_strings.Task3stringRemoveDupChars.removeDupChars_CharArr;

public class Task3stringRemoveDupCharsTest {

    @Test
    public void removeDupCharsTest() {
        String sWithDups = "String to remove duplicate characters!";
        String expected = "String oemvduplcahs!";
        String actual = removeDupChars(sWithDups);
        Assertions.assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    public void removeDupCharsTestNull() {
        String sWithDups = null;
        String actual = removeDupChars(sWithDups);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void removeDupChars_CharArrTest() {
        String sWithDups = "String to remove duplicate characters!";
        String expected = "String oemvduplcahs!";
        String actual = removeDupChars_CharArr(sWithDups);
        Assertions.assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    public void removeDupChars_CharArrTestNoDups() {
        String sWithoutDups = "String wIThouDUps!";
        String actual = removeDupChars_CharArr(sWithoutDups);
        Assertions.assertThat(actual).isNotNull().isEqualTo(sWithoutDups);
    }

    @Test
    public void removeDupChars_CharArrTestAllDups() {
        String sAllDups = "ssss";
        String expected = "s";
        String actual = removeDupChars_CharArr(sAllDups);
        Assertions.assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    public void removeDupChars_CharArrTestNull() {
        String sAllDups = null;
        String actual = removeDupChars_CharArr(sAllDups);
        Assertions.assertThat(actual).isNull();
    }
}
