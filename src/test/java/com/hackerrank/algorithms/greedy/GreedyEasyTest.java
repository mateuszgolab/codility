package com.hackerrank.algorithms.greedy;

import org.junit.Test;

import static com.hackerrank.algorithms.greedy.GreedyEasy.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreedyEasyTest {

    @Test
    public void testMinimumAbsoluteDifference() {

        assertThat(minimumAbsoluteDifference(new int[]{-1, 2, 4}), is(2));
        assertThat(minimumAbsoluteDifference(new int[]{3, -7, 0}), is(3));
        assertThat(minimumAbsoluteDifference(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}), is(1));
        assertThat(minimumAbsoluteDifference(new int[]{1, -3, 71, 68, 17}), is(3));

    }

    @Test
    public void testMarcsCakeWalk() {

        assertThat(marcsCakewalk(new int[]{5, 10, 7}), is(44L));
        assertThat(marcsCakewalk(new int[]{1, 3, 2}), is(11L));
        assertThat(marcsCakewalk(new int[]{7, 4, 9, 6}), is(79L));
        assertThat(marcsCakewalk(new int[]{1}), is(1L));
        assertThat(marcsCakewalk(new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
                        1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000}),
                is(68719476735000L));

    }

    @Test
    public void testGridChallenge() {

        assertThat(gridChallenge(new String[]{"abc", "ade", "efg"}), is("YES"));
        assertThat(gridChallenge(new String[]{"ebacd", "fghij", "olmkn", "trpqs", "xywuv"}), is("YES"));
        assertThat(gridChallenge(new String[]{"xyz", "ade", "efg"}), is("NO"));

    }

    @Test
    public void testLuckBalance() {

        assertThat(luckBalance(2, new int[][]{new int[]{5, 1}, new int[]{1, 1}, new int[]{4, 0}}), is(10));
        assertThat(luckBalance(1, new int[][]{new int[]{5, 1}, new int[]{1, 1}, new int[]{4, 0}}), is(8));
        assertThat(luckBalance(3, new int[][]{new int[]{5, 1}, new int[]{2, 1}, new int[]{1, 1}, new int[]{8, 1}, new int[]{10, 0}, new int[]{5, 0}}), is(29));

    }

}