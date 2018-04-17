package by.herzhot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    boolean needRefresh = true;

    public boolean isNeedRefresh() {
        return needRefresh;
    }

    public void setNeedRefresh(boolean needRefresh) {
        this.needRefresh = needRefresh;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long time = System.currentTimeMillis();

        new Main().execute();

        System.out.println("Time is " + (System.currentTimeMillis() - time));
    }

    private void execute() {

        List<PaymentEntry> paymentEntries = new ArrayList<>();
        double amountBYN = 10000;
        int months = 204;
        double refundingRate = 10.5; // 11

        for (int i = 0; i < months; i++) {
            paymentEntries.addAll(new PaymentCalculator(months, i,
                    amountBYN - paymentEntries.stream().mapToDouble(PaymentEntry::getDebtPart).sum(), refundingRate, this).calculatePayments());
            if (paymentEntries.size() == months) {
                break;
            }
            if (i == 89) {
                i = 89;
            }
        }

        ResultPrinter.INSTANCE.print(paymentEntries);
    }
}
