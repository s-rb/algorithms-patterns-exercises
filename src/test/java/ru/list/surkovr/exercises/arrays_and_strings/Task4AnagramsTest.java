package ru.list.surkovr.exercises.arrays_and_strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.list.surkovr.exercises.arrays_and_strings.Task4anagrams.isStringsAnagrams;

public class Task4AnagramsTest {

    @Test
    public void isStringsAnagramsTest() {
        String anagramString1 = "some anagram string";
        String anagramString2 = "emos granama gnistr";
        boolean actual = isStringsAnagrams(anagramString1, anagramString2);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    public void isStringsAnagramsTestNotAnagrams() {
        String anagramString1 = "some anagram string";
        String notAnagramString2 = "It's NOT anagram string";
        boolean actual = isStringsAnagrams(anagramString1, notAnagramString2);
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    public void isStringsAnagramsTestNull() {
        String anagramString1 = null;
        String anagramString2 = null;
        boolean actual = isStringsAnagrams(anagramString1, anagramString2);
        Assertions.assertThat(actual).isFalse();
    }

    @Test
    public void isStringsAnagramsTestEmpty() {
        String anagramString1 = null;
        String anagramString2 = "";
        boolean actual = isStringsAnagrams(anagramString1, anagramString2);
        Assertions.assertThat(actual).isFalse();
    }
}
