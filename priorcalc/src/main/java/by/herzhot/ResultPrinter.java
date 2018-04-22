package by.herzhot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public enum  ResultPrinter {

    INSTANCE;

    ResultPrinter() {
        initSystemOut();
    }

    public void print(List<PaymentEntry> entries) {

        System.out.printf("%s  %-6s  %-6s  %s%n", "month", "debt", "%", "sum");

        for (PaymentEntry entry : entries) {
            System.out.printf("%3d  %-6.2f  %-6.2f  %.2f%n", entry.getMonthIndex(), entry.getDebtPart(), entry.getPrecentPart(), entry.getPaymentPerMonth());
        }

        double sumD = entries.stream().mapToDouble(PaymentEntry::getDebtPart).sum();
        double sumP = entries.stream().mapToDouble(PaymentEntry::getPrecentPart).sum();
//        System.out.println("Sum of debts: " + entries.stream().mapToDouble(PaymentEntry::getDebtPart).sum());
        System.out.println("Amount of overpayments: " + entries.stream().mapToDouble(PaymentEntry::getPrecentPart).sum() + " ("+ (float)(sumP * 100 / sumD) +"%)");
//        System.out.println("Payment amount: " + entries.stream().mapToDouble(PaymentEntry::getPaymentPerMonth).sum());
    }

    public void print(double[] payments, double[] percents) {
        List<PaymentEntry>  entries = new ArrayList<>();
        for (int i = 0; i < payments.length; i++) {
            if (percents[i] > 0) {
                entries.add(new PaymentEntry(i + 1, payments[i], percents[i]));
            } else {
                break;
            }
        }
        print(entries);
    }

    private void initSystemOut() {
        File file = new File("payment.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
