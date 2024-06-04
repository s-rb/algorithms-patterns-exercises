package ru.list.surkovr.data_structures.hashTable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void groupThePeople() {
        List<List<Integer>> res = HashTable.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        Assertions.assertThat(res).isEqualTo(List.of(
                List.of(5), List.of(0, 1, 2), List.of(3, 4, 6)
        ));
    }
}