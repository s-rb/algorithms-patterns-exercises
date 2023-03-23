package ru.list.surkovr.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.list.surkovr.leetcode.medium.Part1.*;


public class Part1Test {

    @Test
    void testIterator() {
        CombinationIterator itr = new CombinationIterator("abc", 2);
        Assertions.assertThat(itr.next()).isEqualTo("ab");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("ac");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("bc");    
        Assertions.assertThat(itr.hasNext()).isFalse(); 
    }
    @Test
    void testIterator2() {
        CombinationIterator itr = new CombinationIterator("abcd", 3);
        Assertions.assertThat(itr.next()).isEqualTo("abc");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("abd");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("acd");    
    }

    @Test
    void testIterator3() {
        CombinationIterator2 itr = new CombinationIterator2("abc", 2);
        Assertions.assertThat(itr.next()).isEqualTo("ab");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("ac");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("bc");    
        Assertions.assertThat(itr.hasNext()).isFalse(); 
    }

    @Test
    void testIterator4() {
        CombinationIterator2 itr = new CombinationIterator2("bvwz", 2);
        Assertions.assertThat(itr.next()).isEqualTo("bv");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("bw");    
        Assertions.assertThat(itr.hasNext()).isTrue(); 
        Assertions.assertThat(itr.next()).isEqualTo("bz");
    }

    @Test
    void numTilePossibilities() {
        final int res = Part1.numTilePossibilities("AAB");
        Assertions.assertThat(res).isEqualTo(8);
    }

    @Test
    void numTilePossibilities2() {
        final int res = Part1.numTilePossibilities("AAABBC");
        Assertions.assertThat(res).isEqualTo(188);
    }

    @Test
    void numTilePossibilities2test() {
        final int res = Part1.numTilePossibilities2("AAABBC");
        Assertions.assertThat(res).isEqualTo(188);
    }
}
