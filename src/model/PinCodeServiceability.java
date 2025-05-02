package model;

public class PinCodeServiceability {
    private String sourcePinCode;
    private String destinationPinCode;
    private PaymentType paymentType;

    public PinCodeServiceability(String sourcePinCode, String destinationPinCode, PaymentType paymentType) {
        this.sourcePinCode = sourcePinCode;
        this.destinationPinCode = destinationPinCode;
        this.paymentType = paymentType;
    }

    public String getSourcePinCode() {
        return sourcePinCode;
    }

    public void setSourcePin(String sourcePinCode) {
        this.sourcePinCode = sourcePinCode;
    }

    public String getDestinationPinCode() {
        return destinationPinCode;
    }

    public void setDestinationPinCode(String destinationPinCode) {
        this.destinationPinCode = destinationPinCode;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
