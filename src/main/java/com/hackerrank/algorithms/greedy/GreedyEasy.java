package com.hackerrank.algorithms.greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GreedyEasy {

    static int minimumAbsoluteDifference(int[] arr) {

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
        }

        return min;

    }

    static long marcsCakewalk(int[] calorie) {

        Arrays.sort(calorie);

        long result = 0;

        for (int i = 0; i < calorie.length; i++) {
            result += Math.pow(2.0, i) * calorie[calorie.length - 1 - i];
        }

        return result;

    }

    static String gridChallenge(String[] grid) {

        List<int[]> sortedStrings = Arrays.stream(grid).
                map(s -> s.chars().sorted().toArray()).
                collect(Collectors.toList());

        for (int i = 0; i < sortedStrings.get(0).length; i++) {
            for (int j = 0; j < sortedStrings.size() - 1; j++) {
                if (sortedStrings.get(j)[i] > sortedStrings.get(j + 1)[i]) {
                    return "NO";
                }
            }
        }

        return "YES";

    }

    static int luckBalance(int k, int[][] contests) {

        List<Integer> important = new ArrayList<>();
        int counter = 0;

        for(int[] contest : contests) {
            if(contest[1] == 1) {
                important.add(contest[0]);
            }
            counter += contest[0];
        }

        important.sort(null);

        for(int i = 0; i < important.size() - k; i++){
            counter -= 2*important.get(i);
        }

        return counter;

    }

}
