package org.milestone1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Program2Test {

    private static void check(
            int n,
            int k,
            int[] costs,
            long expectedCost,
            List<Integer> expectedIndices
    ) {
        Program2.Result result = Program2.program2(n, k, costs);

        assertEquals(expectedIndices, result.indices());
        assertEquals(expectedCost, result.minimumCost());
    }

    @Test
    void courseExample3() {
        check(
                10,
                4,
                new int[]{0, 1, 2, 4, 9, 12, 10, 6, 4, 3, 1},
                11,
                List.of(3, 7, 10)
        );
    }

    @Test
    void kOneForcesEveryPanel() {
        check(
                6,
                1,
                new int[]{0, 1, 4, 9, 5, 2, 1},
                22,
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void kEqualsNJumpsDirectlyToEnd() {
        check(
                6,
                6,
                new int[]{0, 1, 4, 9, 7, 3, 2},
                2,
                List.of(6)
        );
    }

    @Test
    void kGreaterThanNJumpsDirectlyToEnd() {
        check(
                6,
                10,
                new int[]{0, 1, 4, 9, 7, 3, 2},
                2,
                List.of(6)
        );
    }

    @Test
    void smallestValidProblemS2Instance() {
        // Peak is p = 2.
        // Optimal route avoids the expensive peak.
        check(
                3,
                2,
                new int[]{0, 1, 9, 1},
                2,
                List.of(1, 3)
        );
    }

    @Test
    void optimalRouteLandsOnPeak() {
        // Peak is p = 2.
        // Despite being the most expensive panel, landing on p
        // allows the route to use fewer total landings.
        check(
                4,
                2,
                new int[]{0, 16, 25, 12, 6},
                31,
                List.of(2, 4)
        );
    }

    @Test
    void optimalRouteSkipsPeak() {
        // Peak is p = 3.
        // The optimal crossing jumps from the left side
        // directly to the right side.
        check(
                6,
                3,
                new int[]{0, 2, 4, 20, 8, 4, 1},
                9,
                List.of(2, 5, 6)
        );
    }

    @Test
    void peakCloseToBeginning() {
        // Peak is p = 2.
        check(
                7,
                3,
                new int[]{0, 2, 9, 8, 5, 4, 3, 1},
                8,
                List.of(1, 4, 7)
        );
    }

    @Test
    void peakCloseToEnd() {
        // Peak is p = 6.
        check(
                7,
                3,
                new int[]{0, 1, 2, 3, 4, 5, 10, 1},
                6,
                List.of(1, 4, 7)
        );
    }

    @Test
    void nonStrictMonotonicSidesWithUniquePeak() {
        // ProblemS2 allows equal costs on either side of p,
        // provided p itself is the unique maximum.
        //
        // 2 <= 2 <= 5 <= 10 >= 7 >= 7 >= 3 >= 1
        check(
                8,
                3,
                new int[]{0, 2, 2, 5, 10, 7, 7, 3, 1},
                10,
                List.of(2, 5, 8)
        );
    }
}