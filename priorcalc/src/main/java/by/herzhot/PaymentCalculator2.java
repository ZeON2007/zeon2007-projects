package by.herzhot;

import java.util.Arrays;
import java.util.stream.Stream;

public class PaymentCalculator2 {

    private static final double contractAmount = 50000.0;
    private static final int contractDay = 15;
    private static final int paymentDay = 15;
    private static final double refundingRate = 10.5;

    private static final double rateOffset = 2.5;
    private static final int daysInMonth = 30;
    private static final int daysInYear = 360;
    private static final int years = 20;
    private static final int mainDebtDelayMonths = 36;
    private static final double coef = 1 + refundingRate / (1200 * daysInMonth);
    private static final double reducedCoef = 1 + (refundingRate - rateOffset) / (1200 * daysInMonth);

    private static final int creditDuration = daysInYear * years - contractDay - (daysInMonth - paymentDay);

    private static final int onlyPercentDuration = mainDebtDelayMonths * daysInMonth - daysInMonth * 2 - contractDay + 1;
    private static final int debtDuration = creditDuration - onlyPercentDuration;

    private static final int reducedRefundingRateDuration = mainDebtDelayMonths * daysInMonth + 1;
    private static final int refundingRateDuration = creditDuration - reducedRefundingRateDuration;

    private static final double[] payments = new double[creditDuration + 1];
    private static final double[] percents = new double[creditDuration + 1];
    private static final double[] amounts = new double[creditDuration + 1];

    public static void main(String[] args) {


        double tempContractAmount = contractAmount;

        for (int i = 0; i < onlyPercentDuration; i++) {
            payments[i] = 0;
            percents[i] = tempContractAmount * (reducedCoef - 1);
            amounts[i] = payments[i] + percents[i];

            tempContractAmount -= isPaymentDay(i) ? getLastAmountOfPayments(i) : 0.0;
        }

        double reducedRefundingRateCoefAmount = Stream.iterate(1.0, c -> c * reducedCoef).limit(debtDuration).reduce((x, y) -> x + y).orElse(0.0);
        double payment = tempContractAmount / reducedRefundingRateCoefAmount;

        for (int i = onlyPercentDuration; i < reducedRefundingRateDuration; i++) {

            payments[i] = payment;
            percents[i] = tempContractAmount * (reducedCoef - 1);
            amounts[i] = payments[i] + percents[i];

            if (isPaymentDay(i)) {
                tempContractAmount -= getLastAmountOfPayments(i);
                payment = tempContractAmount / Stream.iterate(1.0, c -> c * reducedCoef).limit(creditDuration - i + 1).reduce((x, y) -> x + y).orElse(0.0);
            }
        }

        double refundingRateCoefAmount = Stream.iterate(1.0, c -> c * coef).limit(refundingRateDuration).reduce((x, y) -> x + y).orElse(0.0);
        payment = tempContractAmount / refundingRateCoefAmount;

        for (int i = reducedRefundingRateDuration; i <= creditDuration; i++) {

            payments[i] = payment;
            percents[i] = tempContractAmount * (coef - 1);
            amounts[i] = payments[i] + percents[i];

            if (isPaymentDay(i)) {
                tempContractAmount -= getLastAmountOfPayments(i);
                payment = tempContractAmount / Stream.iterate(1.0, c -> c * coef).limit(creditDuration - i + 1).reduce((x, y) -> x + y).orElse(0.0);
            }
        }

        System.out.println(Arrays.toString(payments));
        System.out.println(Arrays.toString(percents));
        System.out.println(Arrays.toString(amounts));

        System.out.println(getLastAmountOfPayments(30 * 38));
        System.out.println(getLastAmountOfPrecents(30 * 38));

        double sumOfPayments = Arrays.stream(payments).sum();
        double sumOfPrecents = Arrays.stream(percents).sum();
        double sumOfAmounts = Arrays.stream(amounts).sum();

        System.out.println(sumOfPayments + " | " + sumOfPrecents + " | " + sumOfAmounts);


    }

    private static boolean isPaymentDay(int index) {
        return index >= daysInMonth - contractDay + paymentDay
                && ((index == daysInMonth - contractDay + paymentDay)
                || (index - (daysInMonth - contractDay) - paymentDay) % daysInMonth == 0);
    }

    private static double getLastAmountOfPayments(int index) {
        double sum = 0.0;
        if (index == daysInMonth - contractDay + paymentDay) {
            return sum;
        } else if (index != creditDuration) {
            for (int i = index - paymentDay - 1; i >= index - paymentDay - daysInMonth; i--) {
                sum += payments[i];
            }
        } else {
            for (int i = index - 1; i >= index - paymentDay - daysInMonth; i--) {
                sum += payments[i];
            }
        }
        return sum;
    }

    private static double getLastAmountOfPrecents(int index) {
        double sum = 0.0;
        if (index == daysInMonth - contractDay + paymentDay) {
            for (int i = index - paymentDay - 1; i >= index - paymentDay - daysInMonth + contractDay; i--) {
                sum += percents[i];
            }
        } else if (index != creditDuration) {
            for (int i = index - paymentDay - 1; i >= index - paymentDay - daysInMonth; i--) {
                sum += percents[i];
            }
        } else {
            for (int i = index - 1; i >= index - paymentDay - daysInMonth; i--) {
                sum += percents[i];
            }
        }
        return sum;
    }

}
