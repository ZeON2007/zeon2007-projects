package by.herzhot;

public class Main {

    public static void main(String[] args) {

        double amountBYN = 40000;
        int years = 15;
        double refundingRate = 11;

        new PaymentCalculator(years * 12, amountBYN, refundingRate).calculatePayments();
    }
}
