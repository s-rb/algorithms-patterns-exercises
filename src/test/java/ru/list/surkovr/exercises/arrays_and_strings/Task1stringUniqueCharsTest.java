package ru.list.surkovr.exercises.arrays_and_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1stringUniqueCharsTest {

    @Test
    public void isContainsUniqueCharsUnique() {
        String src = "String";
        boolean actual = Task1stringUniqueChars.isContainsUniqueChars(src);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    public void isContainsUniqueCharsNotUnique() {
        String src = "Some source string. It contains NOT unique characters";
        boolean actual = Task1stringUniqueChars.isContainsUniqueChars(src);
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    public void isContainsUniqueCharsNoAddDataStruct_Unique() {
        String src = "String";
        boolean actual = Task1stringUniqueChars.isContainsUniqueCharsNoAddDataStruct(src);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    public void isContainsUniqueCharsNoAddDataStruct_NotUnique() {
        String src = "Some source string. It contains NOT unique characters";
        boolean actual = Task1stringUniqueChars.isContainsUniqueCharsNoAddDataStruct(src);
        Assertions.assertThat(actual).isFalse();
    }
}
