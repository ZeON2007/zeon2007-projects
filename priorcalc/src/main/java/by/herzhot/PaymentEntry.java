package by.herzhot;

public class PaymentEntry {

    private final int monthIndex;
    private final double debtPart;
    private final double precentPart;
    private final double paymentPerMonth;

    public PaymentEntry(int monthIndex, double debtPart, double precentPart) {
        this.monthIndex = monthIndex;
        this.debtPart = debtPart;
        this.precentPart = precentPart;
        this.paymentPerMonth = debtPart + precentPart;
    }

    public int getMonthIndex() {
        return monthIndex;
    }

    public double getDebtPart() {
        return debtPart;
    }

    public double getPrecentPart() {
        return precentPart;
    }

    public double getPaymentPerMonth() {
        return paymentPerMonth;
    }

    @Override
    public String toString() {
        return "PaymentEntry{" +
                "monthIndex=" + monthIndex +
                ", debtPart=" + debtPart +
                ", precentPart=" + precentPart +
                ", paymentPerMonth=" + paymentPerMonth +
                '}';
    }
}
