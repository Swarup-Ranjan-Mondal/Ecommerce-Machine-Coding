package service;

import model.PinCodeServiceability;
import model.PaymentType;
import java.util.*;

public class PincodeService {
    List<PinCodeServiceability> serviceabilityList = new ArrayList<>();

    public void addServiceability(String sourcePin, String destPin, PaymentType paymentType) {
        serviceabilityList.add(new PinCodeServiceability(sourcePin, destPin, paymentType));
    }

    public boolean isServiceable(String sourcePin, String destPin, PaymentType requested) {
        for (PinCodeServiceability serviceLocation : serviceabilityList) {
            if (serviceLocation.getSourcePin().equals(sourcePin) && serviceLocation.getDestPin().equals(destPin)) {
                return serviceLocation.getPaymentType() == requested || serviceLocation.getPaymentType() == PaymentType.BOTH;
            }
        }
        return false;
    }
}
