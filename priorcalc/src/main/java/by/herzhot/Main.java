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

        File file = new File("payment.txt");
        FileOutputStream fos = new FileOutputStream(file);

        // Create new print stream for file.
        PrintStream ps = new PrintStream(fos);

        // Set file print stream.
        System.setOut(ps);

        Main main = new Main();
        main.execute();

    }

    private void execute() {

        List<PaymentEntry> paymentEntries = new ArrayList<>();
        double amountBYN = 40000;
        int months = 180;
        double refundingRate = 11; // 11

        for (int i = 0; i < 180; i++) {
            paymentEntries.addAll(new PaymentCalculator(months, i,
                    amountBYN - paymentEntries.stream().mapToDouble(PaymentEntry::getDebtPart).sum(), refundingRate, this).calculatePayments());
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
