package lab_1_Objects.enums;

public enum PaymentStates {
    PAYED,
    PARTIALLY_PAID,
    UNPAID;

    public static PaymentStates fromString(String value) {
        try {
            return PaymentStates.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("No constant with text " + value + " found in PaymentStates");
            return null;
        }
    }
}
