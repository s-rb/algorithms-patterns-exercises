package ru.list.surkovr.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.list.surkovr.algorithms.rabin_karp.RabinKarpExtended;

import java.util.List;

public class RabinKarpTest {

    String text;
    String query;

    @BeforeEach
    public void init() {
        text = "CGTTACGTATGCGCTAGCTAGTCGATGATGACGACGACGACGTA";
        query = "GATG";
    }

    @Test
    public void searchEmptyQuery() {
        String emptyQuery = "";
        IllegalArgumentException expected = new IllegalArgumentException("Передан пустой поисковый запрос или null.");
        try {
            RabinKarpExtended rabinKarpExtended = new RabinKarpExtended(text);
            rabinKarpExtended.search(emptyQuery);
        } catch (Exception actual) {
            Assertions.assertThat(actual).isNotNull().isEqualToComparingFieldByField(expected);
        }
    }

    @Test
    public void search1() {
        RabinKarpExtended rabinKarpExtended = new RabinKarpExtended(text);
        List<Integer> expected = List.of(26, 27, 28, 29);
        List<Integer> search = rabinKarpExtended.search(query);
        Assertions.assertThat(search).isNotNull().hasSize(expected.size()).containsExactlyElementsOf(expected);
    }
}

