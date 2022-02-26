package io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileHandlerTest {

    @Test
    void test_sum() {
        assertEquals(6, new FileHandler().sumIgnoreComments("src/test/resources/io/numbers.txt"));
    }

    @Test
    void test_sum_with_comments() {
        assertEquals(853, new FileHandler().sumIgnoreComments("src/test/resources/io/numbers_with_comments.txt"));
    }
}