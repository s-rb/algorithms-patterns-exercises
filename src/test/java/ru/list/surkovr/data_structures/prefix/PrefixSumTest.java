package ru.list.surkovr.data_structures.prefix;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixSumTest {

    @Test
    void garbageCollection() {
        Assertions.assertThat(PrefixSum.garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2, 4, 3})).isEqualTo(21);
    }
    @Test
    void garbageCollection2() {
        Assertions.assertThat(PrefixSum.garbageCollection2(new String[]{"G","P","GP","GG"}, new int[]{2, 4, 3})).isEqualTo(21);
    }
}