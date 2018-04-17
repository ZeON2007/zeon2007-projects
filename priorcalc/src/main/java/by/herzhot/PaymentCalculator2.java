package by.herzhot;

import java.util.Arrays;
import java.util.stream.Stream;

public class PaymentCalculator2 {

    public static void main(String[] args) {

        final double contractAmount = 50000.0;
        final int contractDay = 15;
        final double refundingRate = 10.5;

        final double rateOffset = 2.5;
        final int daysInMonth = 30;
        final int daysInYear = 360;
        final int years = 20;
        final int mainDebtDelayMonths = 36;
        final double coef = 1 + refundingRate / (1200 * daysInMonth);
        final double reducedCoef = 1 + (refundingRate - rateOffset) / (1200 * daysInMonth);

        final int creditDuration = daysInYear * years - daysInMonth;
        final int firstMonthDuration = 30;

        final int onlyPercentDuration = mainDebtDelayMonths * daysInMonth - daysInMonth * 2;
        final int debtDuration = creditDuration - onlyPercentDuration;

        final int reducedRefundingRateDuration = mainDebtDelayMonths * daysInMonth - (daysInMonth - contractDay);
        final int refundingRateDuration = creditDuration - reducedRefundingRateDuration;

        final double[] payments = new double[creditDuration];
        final double[] percents = new double[creditDuration];
        final double[] amounts = new double[creditDuration];


        for (int i = 0; i < firstMonthDuration; i++) {
            payments[i] = 0;
            percents[i] = ((contractAmount * (refundingRate - rateOffset) / 1200) * (daysInMonth - contractDay) / daysInMonth) / daysInMonth;
            amounts[i] = payments[i] + percents[i];
        }

        for (int i = firstMonthDuration; i < onlyPercentDuration; i++) {
            payments[i] = 0;
            percents[i] = (contractAmount * (refundingRate - rateOffset) / 1200) / daysInMonth;
            amounts[i] = payments[i] + percents[i];
        }

        double reducedRefundingRateCoefAmount = Stream.iterate(1.0, c -> c * reducedCoef).limit(debtDuration).reduce((x, y) -> x + y).orElse(0.0);
        double payment = contractAmount / reducedRefundingRateCoefAmount;
        double tempContractAmount = contractAmount;

        for (int i = onlyPercentDuration; i < reducedRefundingRateDuration; i++) {

            payments[i] = payment;
            percents[i] = tempContractAmount * (reducedCoef - 1);
            amounts[i] = payments[i] + percents[i];

            tempContractAmount -= payment;
            payment *= reducedCoef;
        }

        double refundingRateCoefAmount = Stream.iterate(1.0, c -> c * coef).limit(refundingRateDuration).reduce((x, y) -> x + y).orElse(0.0);
        payment = tempContractAmount / refundingRateCoefAmount;

        for (int i = reducedRefundingRateDuration; i < creditDuration; i++) {

            payments[i] = payment;
            percents[i] = tempContractAmount * (coef - 1);
            amounts[i] = payments[i] + percents[i];

            tempContractAmount -= payment;
            payment *= coef;
        }

        System.out.println(Arrays.toString(payments));
        System.out.println(Arrays.toString(percents));
        System.out.println(Arrays.toString(amounts));

        double sumOfPayments = Arrays.stream(payments).sum();
        double sumOfPrecents = Arrays.stream(percents).sum();
        double sumOfAmounts = Arrays.stream(amounts).sum();

        System.out.println(sumOfPayments + " | " + sumOfPrecents + " | " + sumOfAmounts);


    }
}
