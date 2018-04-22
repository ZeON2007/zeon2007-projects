package by.herzhot;

import static by.herzhot.Constants.COUNTRIES;
import static by.herzhot.Constants.HOR_DATA;

public class Main {

    public static void main(String[] args) {

        int counter = 0;

        String [] verData = new String[HOR_DATA[0].length()];
        StringBuilder sb;
        for (int i = HOR_DATA[0].length() - 1; i >= 0; i--) {
            sb = new StringBuilder("");
            for (int j = 0; j < HOR_DATA.length; j++) {
                sb.append(HOR_DATA[j].charAt(i));
            }
            verData[i] = sb.toString();
        }

        for (String country : COUNTRIES) {
            for (int i = 0; i < HOR_DATA.length; i++) {
                String horRow = HOR_DATA[i];
                if (horRow.contains(country.toUpperCase())) {
                    System.out.println(country + "| hor, coordinates = " + (horRow.indexOf(country.toUpperCase()) + 1) + ", " + (i + 1));
                    counter++;
                }
            }
            for (int i = 0; i < verData.length; i++) {
                String verRow = verData[i];
                if (verRow.contains(country.toUpperCase())) {
                    System.out.println(country + "| ver, coordinates = " + (i + 1) + ", " + (verRow.indexOf(country.toUpperCase()) + 1));
                    counter++;
                }
            }
        }
        System.out.println("Number is " + counter);


    }
}
