package by.herzhot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<PaymentEntry> paymentEntries = new ArrayList<>();
        double amountBYN = 40000;
        int months = 180;
        double refundingRate = 11;

        for (int i = 0; i < 180; i++) {
            paymentEntries.addAll(new PaymentCalculator(months, i,
                    amountBYN - paymentEntries.stream().mapToDouble(PaymentEntry::getDebtPart).sum(), refundingRate).calculatePayments());
            if (paymentEntries.size() == months) {
                break;
            }
            if (i == 89) {
                i = 89;
            }
        }

        new ResultPrinter().print(paymentEntries);
    }
}
