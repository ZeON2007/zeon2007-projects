package by.herzhot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        String s4 = "abaa";

        String s1000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff";


        String s2000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd";

        String s3000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff";


        String s10000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff";


        String s = s1000;
        System.out.println("Length is: " + s.length());
        int[][] queries = new int[][]{
                {0,s.length() - 1}
        };

        long t10 = System.currentTimeMillis();
        System.out.println(Arrays.toString(countSubstrings(s, queries)) + " | " + (System.currentTimeMillis() - t10));
        t10 = System.currentTimeMillis();
        System.out.println(Arrays.toString(countSubstringsFastWithHashes(s, queries)) + " | " + (System.currentTimeMillis() - t10));
        t10 = System.currentTimeMillis();
        System.out.println(Arrays.toString(countSubstringsAccurateAndSlow(s, queries)) + " | " + (System.currentTimeMillis() - t10));

    }

    private static int[] countSubstrings(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++ ) {
            int offset = queries[i][0];
            int ssLength = queries[i][1] - queries[i][0] + 1;
            if (ssLength == 1) {
                result[i] = 1;
            } else {
                int[] mapPosToGroup = new int[ssLength]; // position has group
                int[] nextPos = new int[ssLength]; // jump to position mapping
                boolean[] marker = new boolean[ssLength * 27]; // 26 - letters, 27 - isFirstEntry
                int[] amountPosInSameGroup = new int[ssLength]; // amount of positions in current group
                int groupCounter = 0;
                int first = 0;
                int last = 0;
                for (int j = 0; j < ssLength; j++) {

                }
            }
        }
        return result;
    }

    private static int[] countSubstringsFastWithHashes(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++ ) {
            if (queries[i][1] - queries[i][0] == 0) {
                result[i] = 1;
            } else {
                int counter = 0;
                int counterHashes = 0;
                int size = 4501500;
                int[] hashes = new int[size];
                byte[] subStr = new byte[queries[i][1] - queries[i][0] + 1];
                s.getBytes(queries[i][0],queries[i][1] + 1, subStr, 0);
                for (int m = 0; m < subStr.length; m++) {
                    int hash = 17;
                    for (int k = m; k < subStr.length; k++) {
                        hash = 37 * hash + subStr[k];
                        hashes[counterHashes] = hash;
                        counterHashes++;
                    }
                }
                int[] trimmedHashes = Arrays.copyOf(hashes, counterHashes);
                Arrays.sort(trimmedHashes);
                int tempHash = trimmedHashes[0];
                counter++;
                for (int h = 0; h < trimmedHashes.length; h++) {
                    if (trimmedHashes[h] != tempHash) {
                        tempHash = trimmedHashes[h];
                        counter++;
                    }
                }
                result[i] = counter;
            }
        }
        return result;
    }

    private static int[] countSubstringsAccurateAndSlow(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++ ) {
            int substrLength = queries[i][1] - queries[i][0];
            Set<String> stringSet = new HashSet<>();
            if (substrLength == 0) {
                result[i] = 1;
            } else {
                String substr = s.substring(queries[i][0], queries[i][1] + 1);
                for (int templateSize = 1; templateSize <= substr.length(); templateSize++) {
                    for (int pos = 0; pos <= substr.length() - templateSize; pos++) {
                        stringSet.add(substr.substring(pos, pos + templateSize));
                    }
                }
                result[i] = stringSet.size();
            }
        }
        return result;
    }

}
