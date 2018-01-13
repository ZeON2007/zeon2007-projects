package by.herzhot;

import java.util.List;

public class ResultPrinter {

    public void print(List<PaymentEntry> entries) {
        System.out.printf("%s  %-6s  %-6s  %s%n", "month", "debt", "%", "sum");
        for (PaymentEntry entry : entries) {
            System.out.printf("%3d  %-6.2f  %-6.2f  %.2f%n", entry.getMonthIndex(), entry.getDebtPart(), entry.getPrecentPart(), entry.getPaymentPerMonth());


        }
//        System.out.println("Sum of debts: " + entries.stream().mapToDouble(PaymentEntry::getDebtPart).sum());
        System.out.println("Amount of overpayments: " + entries.stream().mapToDouble(PaymentEntry::getPrecentPart).sum());
//        System.out.println("Payment amount: " + entries.stream().mapToDouble(PaymentEntry::getPaymentPerMonth).sum());
    }
}
