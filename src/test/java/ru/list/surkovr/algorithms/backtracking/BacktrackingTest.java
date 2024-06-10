package ru.list.surkovr.algorithms.backtracking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingTest {

    @Test
    void readBinaryWatch() {
        Assertions.assertThat(Backtracking.readBinaryWatch(1))
                .isEqualTo(List.of("0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"));
    }
}