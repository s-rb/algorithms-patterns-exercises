package ru.list.surkovr.data_structures.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void findTheWinner() {
        Assertions.assertThat(Queue.findTheWinner(5, 2)).isEqualTo(3);
    }
}