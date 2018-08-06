package by.herzhot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main1 {

    public static void main(String[] args) {

        String s1 = "a";

        String s2 = "aa";

        String s3 = "aaa";

        String s4 = "aaaa";

        String s26 = "abcdefghijklmnopqrstuvwxyz";

        String s250 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjff";

        String s500 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfsl";

        String s1000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff";

        String s1500 = s1000 + s500;

        String s2000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd";

        String s3000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff";


        String s10000 = "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffffffffjjfjfjfjfjdfjhfhfhfhfhfhfhfhfhfhfdddddddddddddddfhdfjhffhfhfdfdfdfdfdfdfdfdfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflffffffhgghghghghgskjdhgjdhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjd"
                + "baaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjffffffffffffffffaaafhskfjhsgkghghhgghghghghdsdhjjjhhhdjhdjhdjhhhgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffffffffffffhgghghghghgskjdhhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjfffffffffffffffhgghghghghgskjdhgjdhggfslflskfjfjjjjjjffffffffff";


        String s = s3000;
        System.out.println((int)'a');
        System.out.println("Length is: " + s.length());
        int[][] queries = new int[][]{
                {0,s.length() - 1}
        };

        long t10 = System.currentTimeMillis();
        System.out.println(Arrays.toString(countSubstrings1(s, queries)) + " | " + (System.currentTimeMillis() - t10));
        t10 = System.currentTimeMillis();
        System.out.println(Arrays.toString(countSubstringsFastWithHashes(s, queries)) + " | " + (System.currentTimeMillis() - t10));
//        t10 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(countSubstringsAccurateAndSlow(s, queries)) + " | " + (System.currentTimeMillis() - t10));

    }

    private static int[] countSubstrings1(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++ ) {
            int offset = queries[i][0];
            int ssLength = queries[i][1] - offset + 1;
            if (ssLength == 1) {
                result[i] = 1;
            } else {
                int tailsCount = 0;
                int groupCount = 0;
                int[] chars = new int[ssLength];
                int[][] mapping = new int[227782][26];
                int[] posToGroup = new int[ssLength];
                int[] groupToAmount = new int[227782];
                int[] from = new int[ssLength];
                int[] to = new int[ssLength];

                for (int j = 0; j < ssLength; j++) {
                    chars[j] = s.charAt(offset + j) - 97;
                    if (mapping[0][chars[j]] != 0) {
                        posToGroup[j] = mapping[0][chars[j]];
                        groupToAmount[posToGroup[j]]++;
                        if (j != ssLength - 1) {
                            from[j + 1] = j;
                            to[j] = j + 1;
                        } else {
                            from[0] = j;
                            to[j] = 0;
                        }
                    } else {
                        mapping[0][chars[j]] = ++groupCount;
                        posToGroup[j] = groupCount;
                        groupToAmount[groupCount]++;
                        if (j != ssLength - 1) {
                            from[j + 1] = j;
                            to[j] = j + 1;
                        } else {
                            from[0] = j;
                            to[j] = 0;
                        }
                    }
                }

                int curLen = 1;
                boolean isEnd = false;
                for (int k = 0; ; k = to[k]) {
                    if (to[k] == k) {
                        isEnd = true;
                    }
                    if (groupToAmount[posToGroup[k]] == 1) {
                        tailsCount += ssLength - k - curLen;
                        to[from[k]] = to[k];
                        from[to[k]] = from[k];
                        if (k + curLen >= ssLength) {
                            curLen++;
                        }
                    } else {
                        if (k + curLen < ssLength) {
                            if (mapping[posToGroup[k]][chars[k + curLen]] != 0) {
                                posToGroup[k] = mapping[posToGroup[k]][chars[k + curLen]];
                                groupToAmount[posToGroup[k]]++;
                            } else {
                                mapping[posToGroup[k]][chars[k + curLen]] = ++groupCount;
                                posToGroup[k] = groupCount;
                                groupToAmount[groupCount]++;
                            }
                        } else {
                            curLen++;
                            to[from[k]] = to[k];
                            from[to[k]] = from[k];
                        }
                    }
                    if (isEnd) break;
                }
                System.out.println(groupCount);
                result[i] = groupCount + tailsCount;
            }
        }
        return result;
    }

    private static int[] countSubstrings(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++ ) {
            int offset = queries[i][0];
            int ssLength = queries[i][1] - offset + 1;
            if (ssLength == 1) {
                result[i] = 1;
            } else {
                int[][] mapPosToGroup = new int[2][ssLength]; // position has group
                boolean[] marker = new boolean[ssLength * 27]; // 26 - letters, 27 - isNotFirstEntry
                int[] amountPosInSameGroup = new int[ssLength]; // amount of positions in current group
                int groupCounter = 0;
                int ssCounter = 0;
                int[] charToGroup = new int[26];
                for (int j = 0; j < ssLength; j++) {
                    if (!marker[(s.charAt(offset + j) - 97)] && marker[ssLength * 26]) {
                        // create group
                        marker[(s.charAt(offset + j) - 97)] = true;
                        mapPosToGroup[0][j] = j;
                        mapPosToGroup[1][j] = ++groupCounter;
                        amountPosInSameGroup[groupCounter]++;
                        charToGroup[(s.charAt(offset + j) - 97)] = groupCounter;
                    } else if (!marker[(s.charAt(offset + j) - 97)] && !marker[ssLength * 26]) {
                        // first time,  don't create group
                        marker[(s.charAt(offset + j) - 97)] = true;
                        marker[ssLength * 26] = true;
                        mapPosToGroup[0][j] = j;
                        mapPosToGroup[1][j] = 0;
                        amountPosInSameGroup[0]++;
                    } else {
                        // don't create group
                        marker[(s.charAt(offset + j) - 97)] = true;
                        marker[ssLength * 26] = true;
                        mapPosToGroup[0][j] = j;
                        mapPosToGroup[1][j] = charToGroup[(s.charAt(offset + j) - 97)];
                        amountPosInSameGroup[mapPosToGroup[1][j]]++;
                    }
                }
                boolean isEnd = false;
                while (!isEnd) {
                    isEnd = true;
                    charToGroup = new int[26];
                    for (int pos = 0; pos < mapPosToGroup[0].length; pos++) {
                        if (mapPosToGroup[1][pos] != ssLength && amountPosInSameGroup[mapPosToGroup[1][pos]] == 1) {
                            ssCounter += ssLength - pos - 1;
                            mapPosToGroup[1][pos] = ssLength;
                        } else if (mapPosToGroup[1][pos] != ssLength) {
                            for (int k = 0; k < 26; k++) {
                                marker[mapPosToGroup[1][pos] * 26 + k] = false;
                            }
                            marker[ssLength * 26 + mapPosToGroup[1][pos]] = false;
                            int nextPos = 0;
                            if (mapPosToGroup[0][pos] + 1 == ssLength) {
                                continue;
                            } else {
                                nextPos = mapPosToGroup[0][pos] + 1;
                            }
                            if (!marker[mapPosToGroup[1][pos] * 26 + (s.charAt(offset + nextPos) - 97)]
                                    && marker[mapPosToGroup[1][pos] + ssLength * 26]) {
                                // create group
                                isEnd = false;
                                marker[mapPosToGroup[1][pos] * 26 + (s.charAt(offset + nextPos) - 97)] = true;
                                amountPosInSameGroup[mapPosToGroup[1][pos]]--;
                                mapPosToGroup[1][pos] = ++groupCounter;
                                mapPosToGroup[0][pos] = nextPos;
                                amountPosInSameGroup[groupCounter]++;
                                charToGroup[(s.charAt(offset + nextPos) - 97)] = groupCounter;
                            } else if (!marker[mapPosToGroup[1][pos] * 26 + (s.charAt(offset + nextPos) - 97)]
                                    && !marker[mapPosToGroup[1][pos] + ssLength * 26]) {
                                // first time,  don't create group
                                isEnd = false;
                                marker[mapPosToGroup[1][pos] * 26 + (s.charAt(offset + nextPos) - 97)] = true;
                                marker[mapPosToGroup[1][pos] + ssLength * 26] = true;
                                mapPosToGroup[0][pos] = nextPos;
                                ssCounter++;
                            } else {
                                // don't create group
                                mapPosToGroup[0][pos] = nextPos;
                                mapPosToGroup[1][pos] = charToGroup[(s.charAt(offset + nextPos) - 97)];
                            }
                        }
                    }
                }
                result[i] = ssCounter + groupCounter + 1;
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
//                int size = 4501500;
                int size = 114501500;
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
