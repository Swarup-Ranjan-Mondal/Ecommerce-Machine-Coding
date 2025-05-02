package model;

public class PinCodeServiceability {
    private String sourcePin;
    private String destPin;
    private PaymentType paymentType;

    public PinCodeServiceability(String sourcePin, String destPin, PaymentType paymentType) {
        this.sourcePin = sourcePin;
        this.destPin = destPin;
        this.paymentType = paymentType;
    }

    public String getSourcePin() {
        return sourcePin;
    }

    public void setSourcePin(String sourcePin) {
        this.sourcePin = sourcePin;
    }

    public String getDestPin() {
        return destPin;
    }

    public void setDestPin(String destPin) {
        this.destPin = destPin;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
