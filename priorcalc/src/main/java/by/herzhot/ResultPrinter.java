package by.herzhot;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class ResultPrinter {

    public void print(List<PaymentEntry> entries) {

        int count = 1;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        for (PaymentEntry entry : entries) {
            System.out.println(count + " | " + df.format(entry.getDebtPart()));
            count++;
        }

    }
}
