package by.herzhot;

import java.util.ArrayList;
import java.util.List;

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
    private int startMonth;
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

    public void calculatePayments() {
        boolean needCalculate = true;
        while (needCalculate) {

            recalculatePaymentsByFirstPayment(firstPredictedPayment);

            for (int i = startMonth; i < months; i++) {
                paymentEntries.add(new PaymentEntry(i + 1, debtParts[i] + additionalPayments[i], calculateMontlyPrecent(i)));
                if (additionalPayments[i] > 0) {
                    restAmount -= additionalPayments[i];
                    startMonth = i + 1;
                    break;
                }
                if (i == months - 1) {
                    needCalculate = false;
                }
            }
        }
        new ResultPrinter().print(paymentEntries);
    }

    private double recalculatePaymentsByFirstPayment(double predictedPayment) {
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
        if (sum > restAmount - accuracy && sum < restAmount + accuracy) {
            return sum;
        } else {
            return recalculatePaymentsByFirstPayment(getNextPredictedPayment(sum));
        }
    }

    private double getNextPredictedPayment(double actualAmount) {
        if (actualAmount < restAmount) {
            firstPredictedPayment = firstPredictedPayment + (firstPredictedPayment * (1 + (restAmount - actualAmount) / restAmount) - firstPredictedPayment) / 2;
            return firstPredictedPayment;
        } else if (actualAmount > restAmount) {
             firstPredictedPayment = firstPredictedPayment - (firstPredictedPayment - firstPredictedPayment / (1 + (actualAmount - restAmount) / actualAmount)) / 2;
             return firstPredictedPayment;
        } else {
            return firstPredictedPayment;
        }
    }

    private double calculateMontlyPrecent(int index) {
         double rest = amount - paymentEntries.stream().mapToDouble(PaymentEntry::getDebtPart).sum();
         return rest * percents[index];
    }

}
