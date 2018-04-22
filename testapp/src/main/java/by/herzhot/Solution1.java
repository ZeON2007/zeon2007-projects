package by.herzhot;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1 {

    public static void main(String[] args) {

        Arrays.sort();

        String regex = "(\\b\\p{Alpha}+\\b)(?:\\s+\\1\\b)+";
        String regex1 = "((\\p{Space}*\\p{Alpha}+\\p{Space}*)\\2+)";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);


            String input = "Goodbye bye bye world world world";

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
//                System.out.println(m.group(2));
                input = input.replaceAll(m.group(0), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);



    }
}

