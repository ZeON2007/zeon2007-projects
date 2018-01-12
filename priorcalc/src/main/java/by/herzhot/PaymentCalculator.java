package by.herzhot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaymentCalculator {

    private final int months;
    private final double amount;
    private final double[] percents;
    private final double[] debtParts;
    private final double[] additionalPayments;
    private final double accuracy = 1;
    private final double refundingRate;
    private double predictedPayment;
    private double leftPredictedPayment;
    private double rightPredictedPayment;
    private int startMonth;
    private List<PaymentEntry> paymentEntries = new ArrayList<>();

    public PaymentCalculator(int months , int offset, double amount, double refundingRate) {
        this.refundingRate = refundingRate;
        this.months = months;
        this.amount = amount;
        this.percents = new double[months];
        this.debtParts = new double[months];
        this.additionalPayments = new double[months];
        this.predictedPayment = amount / 100;
        this.rightPredictedPayment = amount;
        this.startMonth = offset;
        initPercents();
        initAdditionalPayments();
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
        for (int i = 0; i < 50; i++) {
            additionalPayments[i] = 600;
        }
    }

    public List<PaymentEntry> calculatePayments() {

            recalculatePaymentsByFirstPayment(predictedPayment);

            paymentEntries.add(new PaymentEntry(startMonth, debtParts[startMonth] + additionalPayments[startMonth], calculateMontlyPrecent(startMonth)));

        return paymentEntries;

    }

    private double recalculatePaymentsByFirstPayment(double predictedPayment) {
        debtParts[startMonth] = predictedPayment;
        for (int i = startMonth + 1; i < months; i++) {
            if (i == 1) {
                debtParts[i] = (1 + percents[i]) * debtParts[i - 1] + (percents[i - 1] - percents[i]) * amount;
            } else {
                debtParts[i] = (1 + percents[i]) * debtParts[i - 1] +
                        (percents[i] - percents[i - 1]) * getDeptPartSum(i) + (percents[i - 1] - percents[i]) * amount;
            }
        }
        double sum = getDeptPartSum(months - 1);
        if (sum > amount - accuracy && sum < amount + accuracy) {
            return sum;
        } else {
            return recalculatePaymentsByFirstPayment(getNextPredictedPayment(sum));
        }
    }

    private double getNextPredictedPayment(double actualAmount) {
        if (actualAmount < amount) {
            leftPredictedPayment = predictedPayment;
            predictedPayment = (leftPredictedPayment + rightPredictedPayment) / 2;
            return predictedPayment;
        } else if (actualAmount > amount) {
            rightPredictedPayment = predictedPayment;
            predictedPayment = (leftPredictedPayment + rightPredictedPayment) / 2;
             return predictedPayment;
        } else {
            return predictedPayment;
        }
    }

    private double calculateMontlyPrecent(int index) {
         double rest = amount - paymentEntries.stream().mapToDouble(PaymentEntry::getDebtPart).sum();
         return rest * percents[index];
    }

    private double getDeptPartSum(int index) {
        double sum = 0;
        for (int t = index; t >= 0; t--) {
            sum += debtParts[t];
        }
        return sum;
    }

}
