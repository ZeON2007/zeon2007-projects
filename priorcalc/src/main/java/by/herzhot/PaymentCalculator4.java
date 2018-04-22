package by.herzhot;

import java.util.Arrays;
import java.util.stream.Stream;

public class PaymentCalculator4 {

    public static void main(String[] args) {

        final double contractAmount = 50000.0;
        final int contractDay = 15;
        final double refundingRate = 10.5;

        final double rateOffset = 2.5;
        final int daysInMonth = 30;
        final int daysInYear = 360;
        final int years = 20;
        final int mainDebtDelayMonths = 36;
        final double coef = 1 + refundingRate / 1200;
        final double reducedCoef = 1 + (refundingRate - rateOffset) / 1200;

        final int creditDuration = 12 * years;
        final int firstMonthDuration = 1;

        final int onlyPercentDuration = mainDebtDelayMonths - 2;
        final int debtDuration = creditDuration - onlyPercentDuration;

        final int reducedRefundingRateDuration = mainDebtDelayMonths;
        final int refundingRateDuration = creditDuration - reducedRefundingRateDuration;

        final double[] payments = new double[creditDuration];
        final double[] percents = new double[creditDuration];
        final double[] amounts = new double[creditDuration];

        final double[] additionalPayments = new double[creditDuration];
        for (int i = 0; i < additionalPayments.length; i++) {
            additionalPayments[i] = 1000;
        }

        double tempContractAmount = contractAmount;
        double payment = 0.0;
        int lastIndex = 0;

        for (int i = 0; i < firstMonthDuration; i++) {
            payments[i] = payment + additionalPayments[i];
            percents[i] = tempContractAmount * (reducedCoef - 1) * (daysInMonth - contractDay) / daysInMonth;
            amounts[i] = payments[i] + percents[i];

            tempContractAmount -= payments[i];

            if (tempContractAmount <= 0) {
                lastIndex = i;
                break;
            }
        }

        if (tempContractAmount > 0) {
            for (int i = firstMonthDuration; i < onlyPercentDuration; i++) {
                payments[i] = payment + additionalPayments[i];
                percents[i] = tempContractAmount * (reducedCoef - 1);
                amounts[i] = payments[i] + percents[i];

                tempContractAmount -= payments[i];

                if (tempContractAmount <= 0) {
                    lastIndex = i;
                    break;
                }
            }
        }

        if (tempContractAmount > 0) {
            double reducedRefundingRateCoefAmount = Stream.iterate(1.0, c -> c * reducedCoef).limit(debtDuration).reduce((x, y) -> x + y).orElse(0.0);
            payment = tempContractAmount / reducedRefundingRateCoefAmount;

            for (int i = onlyPercentDuration; i < reducedRefundingRateDuration; i++) {

                payments[i] = payment + additionalPayments[i];
                percents[i] = tempContractAmount * (reducedCoef - 1);
                amounts[i] = payments[i] + percents[i];

                tempContractAmount -= payments[i];

                if (tempContractAmount <= 0) {
                    lastIndex = i;
                    break;
                }

                payment *= reducedCoef;
            }
        }

        if (tempContractAmount > 0) {
            double refundingRateCoefAmount = Stream.iterate(1.0, c -> c * coef).limit(refundingRateDuration).reduce((x, y) -> x + y).orElse(0.0);
            payment = tempContractAmount / refundingRateCoefAmount;

            for (int i = reducedRefundingRateDuration; i < creditDuration; i++) {

                payments[i] = payment + additionalPayments[i];
                percents[i] = tempContractAmount * (coef - 1);
                amounts[i] = payments[i] + percents[i];

                tempContractAmount -= payments[i];

                if (tempContractAmount <= 0) {
                    lastIndex = i;
                    break;
                }

                payment *= coef;
            }
        }

        if (lastIndex != 0) {
            payments[lastIndex] = payments[lastIndex] + tempContractAmount;
            percents[lastIndex] = percents[lastIndex] + percents[lastIndex] * (lastIndex < reducedRefundingRateDuration ? reducedCoef - 1 : coef - 1);
            amounts[lastIndex] = payments[lastIndex] + percents[lastIndex];
        }

//        System.out.println(Arrays.toString(payments));
//        System.out.println(Arrays.toString(percents));
//        System.out.println(Arrays.toString(amounts));

        ResultPrinter.INSTANCE.print(payments, percents);


        double sumOfPayments = Arrays.stream(payments).sum();
        double sumOfPrecents = Arrays.stream(percents).sum();
        double sumOfAmounts = Arrays.stream(amounts).sum();

        System.out.println(sumOfPayments + " | " + sumOfPrecents + " | " + sumOfAmounts);



    }

}
