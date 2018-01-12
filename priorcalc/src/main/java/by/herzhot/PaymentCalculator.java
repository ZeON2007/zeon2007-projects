package by.herzhot;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PaymentCalculator {

    private final int months;
    private final double amount;
    private final double[] percents;
    private final double[] debtParts;
    private final double[] additionalPayments;
    private final double accuracy = 0.1;
    private final double refundingRate;
    private double firstPredictedPayment;
    private double restAmount;
    private List<PaymentEntry> paymentEntries = new ArrayList<>();

    public PaymentCalculator(int months, double amount, double refundingRate) {
        this.refundingRate = refundingRate;
        this.months = months;
        this.amount = amount;
        this.percents = new double[months];
        this.debtParts = new double[months];
        this.additionalPayments = new double[months];
        this.firstPredictedPayment = amount / 200;
        this.restAmount = amount;
        initPercents();
        initAdditionalPayments();
    }

    private double getDeptPartSum(int index) {
        double sum = 0;
        for (int t = index; t >= 0; t--) {
            sum += debtParts[t];
        }
        return sum;
    }

    private void initPercents() {
        for (int i = 0; i < months; i++) {
            if (i < 12) {
                percents[i] = (refundingRate - 1) / ((double) 100 * (double) 12);
            } else {
                percents[i] = (refundingRate + 3) / ((double) 100 * (double) 12);
            }
        }
    }

    private void initAdditionalPayments() {
        for (int i = 0; i < 24; i++) {
            additionalPayments[i] = 600;
        }
    }

    public double[] calculatePayments(boolean needPrintResult) {

        recalculatePaymentsByFirstPayment(firstPredictedPayment, 0);

        if (needPrintResult) {
            int count = 1;
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            for (double num : debtParts) {
                System.out.println(count + " | " + df.format(num));
                count++;
            }
        }

        return debtParts;
    }

    private double recalculatePaymentsByFirstPayment(double predictedPayment, int startMonth) {
        debtParts[startMonth] = predictedPayment;
        for (int i = startMonth + 1; i < months; i++) {
            if (i == 1) {
                debtParts[i] = (1 + percents[i]) * debtParts[i - 1] + (percents[i - 1] - percents[i]) * amount;
            } else {
                debtParts[i] = (1 + percents[i])*debtParts[i - 1] +
                        (percents[i] - percents[i - 1]) * getDeptPartSum(i) + (percents[i - 1] - percents[i]) * amount;
            }
        }
        double sum = getDeptPartSum(months - 1);
        if (sum > amount - accuracy && sum < amount + accuracy) {
            return sum;
        } else {
            return recalculatePaymentsByFirstPayment(getNextPredictedPayment(sum), );
        }
    }

    private double getNextPredictedPayment(double actualAmount) {
        if (actualAmount < amount) {
            firstPredictedPayment = firstPredictedPayment + (firstPredictedPayment * (1 + (amount - actualAmount) / amount) - firstPredictedPayment) / 2;
            return firstPredictedPayment;
        } else if (actualAmount > amount) {
             firstPredictedPayment = firstPredictedPayment - (firstPredictedPayment - firstPredictedPayment / (1 + (actualAmount - amount) / actualAmount)) / 2;
             return firstPredictedPayment;
        } else {
            return firstPredictedPayment;
        }
    }

}
