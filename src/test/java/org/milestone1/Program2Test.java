package org.milestone1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * costs has n+1 entries: costs[0] = 0 is the start panel, costs[1..n] are
 * positive and non-increasing. Every case below has a unique optimal route.
 */
class Program2Test {
    private static void check(int n, int k, int[] costs, long expectedCost, List<Integer> expectedIndices) {
        Program2.Result result = Program2.program2(n, k, costs);
        assertEquals(expectedCost, result.minimumCost());
        assertEquals(expectedIndices, result.indices());
    }

    @Test
    void constantCostsWithJumpReachingEnd() {
        check(7, 7, new int[]{0, 1, 1, 1, 1, 1, 1, 1}, 1, List.of(7));
    }

    @Test
    void singlePanel() {
        check(1, 1, new int[]{0, 5}, 5, List.of(1));
    }

    @Test
    void kOneForcesEveryPanel() {
        check(6, 1, new int[]{0, 6, 5, 4, 3, 2, 1}, 21, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void kEqualsNJumpsDirectlyToEnd() {
        check(6, 6, new int[]{0, 5, 5, 4, 4, 2, 2}, 2, List.of(6));
    }

    @Test
    void strictlyDecreasingSmallK() {
        check(5, 2, new int[]{0, 9, 7, 5, 3, 1}, 11, List.of(2, 4, 5));
    }

    @Test
    void courseExample2() {
        check(8, 3, new int[]{0, 20, 18, 16, 14, 12, 10, 8, 6}, 32, List.of(3, 6, 8));
    }

    @Test
    void plateausWithMixedJumpLengths() {
        check(9, 4, new int[]{0, 10, 10, 8, 6, 6, 3, 3, 2, 1}, 9, List.of(4, 8, 9));
    }
}
