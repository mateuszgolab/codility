package com.hackerrank.algorithms.implementation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Easy {


    static int countingValleys(int n, String s) {

        int seaLevel = 0;
        int valleyCount = 0;

        for (Character ch : s.toCharArray()) {

            if (ch == 'D') seaLevel--;
            else {
                seaLevel++;
                if (seaLevel == 0) valleyCount++;
            }
        }

        return valleyCount;

    }

    static String dayOfProgrammer(int year) {

        String leapYear = "12.09.";
        String nonLeapYear = "13.09.";

        if (year < 1918) {
            if (isJulianLeapYear(year)) return leapYear + String.valueOf(year);
            else return nonLeapYear + String.valueOf(year);
        } else if (year == 1918) {
            return "26.09.1918";
        } else {
            if (isGregorianLeapYear(year)) return leapYear + String.valueOf(year);
            else return nonLeapYear + String.valueOf(year);
        }
    }

    static int pageCount(int n, int p) {
        return Math.min(p / 2, (n - p + (n + 1) % 2) / 2);
    }

    static int sockMerchant(int n, int[] ar) {

        return Arrays.stream(ar).
                boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                values().stream().
                mapToInt(v -> (int) (v / 2)).
                sum();

    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int price = -1;

        for (int keyboard : keyboards) {
            if (keyboard < b) {
                for (int drive : drives) {
                    int tmp = keyboard + drive;
                    if (tmp <= b) {
                        if (tmp > price) {
                            price = tmp;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        return price;
    }

    static String catAndMouse(int x, int y, int z) {

        int catA = Math.abs(z - x);
        int catB = Math.abs(z - y);

        if (catA < catB) {
            return "Cat A";
        } else if (catB < catA) {
            return "Cat B";
        } else {
            return "Mouse C";
        }

    }

    static int pickingNumbers(List<Integer> a) {

        Collections.sort(a);
        int max = 0;

        for (int i = 0; i < a.size() - 1; i++) {
            int tmp = 1;
            for (int j = i + 1; j < a.size(); j++) {
                if (Math.abs(a.get(i) - a.get(j)) < 2) tmp++;
                else break;
            }

            if (tmp > max) max = tmp;

        }

        return max;


    }

    static int hurdleRace(int k, int[] height) {
        return Math.max(Arrays.stream(height).max().orElse(0) - k, 0);
    }

    static int designerPdfViewer(int[] h, String word) {

        int max = 0;
        for (Character ch : word.toCharArray()) {
            int index = ch - (int) 'a';
            max = Math.max(max, h[index]);
        }

        return word.length() * max;

    }

    static int utopianTree(int n) {

        int result = 1;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) result *= 2;
            else result++;
        }

        return result;

    }

    static String angryProfessor(int k, int[] a) {

        if (Arrays.stream(a).filter(v -> v <= 0).count() >= k) {
            return "NO";
        } else {
            return "YES";
        }

    }

    static int beautifulDays(int i, int j, int k) {

        int counter = 0;

        for (int l = i; l <= j; l++) {
            if (Math.abs(l - reverseInt(l)) % k == 0) counter++;
        }

        return counter;

    }

    static int viralAdvertising(int n) {

        int cummulative = 2;
        int lastLiked = 2;

        for (int i = 2; i <= n; i++) {
            lastLiked = lastLiked * 3 / 2;
            cummulative += lastLiked;
        }


        return cummulative;

    }

    static int saveThePrisoner(int n, int m, int s) {

        int result = ((m % n) + s - 1) % n;

        if (result == 0) return n;
        else return result;
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int startIndex = k % a.length;
        int result[] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] += a[(queries[i] - startIndex + a.length) % a.length];
        }

        return result;

    }

    static int[] permutationEquation(int[] p) {

        Map<Integer, Integer> map = new HashMap<>(p.length);
        int[] result = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            map.put(p[i], i + 1);
        }


        for (int i = 0; i < p.length; i++) {
            result[i] = map.get(map.get(i + 1));
        }

        return result;

    }

    static int jumpingOnClouds(int[] c, int k) {

        int position = 0;
        int result = 100;

        do {

            position = (position + k) % c.length;
            result -= (1 + c[position] * 2);

        } while (position != 0);

        return result;

    }

    static int findDigits(int n) {

        int counter = 0;
        int number = n;

        while (number > 0) {

            int v = number % 10;
            if (v != 0 && n % v == 0) counter++;
            number /= 10;
        }

        return counter;

    }

    static String appendAndDelete(String s, String t, int k) {

        int common = 0;
        int n = Math.min(s.length(), t.length());

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                common++;
            } else {
                break;
            }
        }

        int diff = s.length() + t.length() - 2 * common;

        if (diff > k) return "No";
        else if (diff == k) return "Yes";
        else if (s.length() + t.length() <= k) return "Yes";
        else if ((k - diff) % 2 == 0 || (k - diff - 2 * s.length() > 0)) return "Yes";
        else return "No";

    }

    static int squares(int a, int b) {

        int counter = 0;

        for (long i = Math.round(Math.sqrt(a)); i <= b; i++) {
            if (i * i <= b) {
                if (i * i >= a) counter++;
            } else break;
        }

        return counter;

    }

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        if (y1 - y2 > 0) return 10000;
        if (y1 == y2) {
            if (m1 == m2) {
                if (d1 >= d2) {
                    return (d1 - d2) * 15;
                }
            } else if (m1 > m2) {
                return (m1 - m2) * 500;
            }
        }

        return 0;
    }

    static int[] cutTheSticks(int[] arr) {

        List<Integer> result = new ArrayList<>();

        Arrays.sort(arr);

        while (arr.length > 0) {

            result.add(arr.length);

            int min = arr[0];

            arr = Arrays.stream(arr).
                    map(v -> v - min).
                    filter(v -> v > 0).
                    toArray();

        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    static long repeatedString(String s, long n) {

        if (!s.contains("a")) return 0;

        long counter = 0;
        long iterations = n / s.length();

        if (iterations > 0) {
            counter = iterations * s.chars().filter(v -> v == 'a').count();
        }

        long rest = n - (s.length() * iterations);

        counter += s.substring(0, (int) rest).chars().filter(v -> v == 'a').count();

        return counter;

    }

    static int jumpingOnClouds(int[] c) {

        int jumps = 0;
        int i = 0;

        while (i < c.length) {

            if ((i + 2) < c.length && c[i + 2] == 0) {
                i += 2;
                jumps++;
            } else if ((i + 1) < c.length && c[i + 1] == 0) {
                i++;
                jumps++;
            } else {
                break;
            }

        }

        return jumps;

    }

    static int equalizeArray(int[] arr) {

        Arrays.sort(arr);

        int max = 1;
        int previous = arr[0];
        int counter = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == previous) {
                counter++;
            } else {
                previous = arr[i];
                max = Math.max(max, counter);
                counter = 1;
            }
        }

        max = Math.max(max, counter);

        return arr.length - max;

    }

    static int[] acmTeam(String[] topic) {

        int max = 0;
        int counter = 0;

        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {

                int candidate = 0;

                for (int k = 0; k < topic[i].length(); k++) {
                    if (topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
                        candidate++;
                    }
                }
                if (candidate > max) {
                    max = candidate;
                    counter = 1;
                } else if (candidate == max) {
                    counter++;
                }
            }
        }

        return new int[]{max, counter};

    }

    static int taumBday(int b, int w, int bc, int wc, int z) {

        return Math.min(bc, (wc + z)) * b + Math.min(wc, (bc + z)) * w;

    }

    static List<Long> kaprekarNumbers(long p, long q) {

        List<Long> result = new ArrayList<>();

        for (long i = p; i <= q; i++) {

            long sq = i * i;
            String sqString = String.valueOf(sq);
            int d = (sqString.length() + 1) / 2;
            int r = sqString.length() - d;
            long left;
            long right = 0;

            if (r > 0) {
                left = Long.valueOf(sqString.substring(0, r));
                right = Long.valueOf(sqString.substring(r));
            } else {
                left = Long.valueOf(sqString);
            }

            if (left + right == i) {
                result.add(i);
            }

        }

        return result;

    }

    static int beautifulTriplets(int d, int[] arr) {

        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == d) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[k] - arr[j] == d) {
                            counter++;
                        }
                    }
                }
            }
        }

        return counter;

    }

    static int minimumDistances(int[] a) {

        if (a.length == 1) return -1;

        int min = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == a[i]) min = Math.min(min, j - i);
            }
            if (min == 1) return 1;
        }

        if (min == a.length) return -1;
        return min;

    }

    static int howManyGames(int p, int d, int m, int s) {

        int counter = 0;
        for (int i = p; i >= m && s >= 0; i -= d) {
            s -= i;
            counter++;
        }

        if (s >= 0) counter += (s / m);
        else counter--;

        return counter;

    }


    // additional methods
    private static boolean isGregorianLeapYear(int year) {
        return (year % 400) == 0 || ((year % 4 == 0) && (year % 100 != 0));
    }

    private static boolean isJulianLeapYear(int year) {
        return (year % 4) == 0;
    }

    static int reverseInt(int n) {

        String intReversed = new StringBuilder(String.valueOf(n)).
                reverse().
                toString();

        return Integer.parseInt(intReversed);
    }
}
