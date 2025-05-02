package repository;

import java.util.*;

import model.*;

public class PinCodeServiceabilityRepository {
    // Source  -> ( dest, paymentMode)
    HashMap<String, HashMap<String, PaymentType>> pinCodes;

    public PinCodeServiceabilityRepository() {
        this.pinCodes = new HashMap<>();
    }

    public void save(PinCodeServiceability serviceability) {
        String sourcePinCode = serviceability.getSourcePinCode();
        if (pinCodes.get(sourcePinCode) == null) {
            HashMap<String, PaymentType> destinationCode = new HashMap<>();
            destinationCode.put(serviceability.getDestinationPinCode(), serviceability.getPaymentType());
            pinCodes.put(sourcePinCode, destinationCode);
        }
        pinCodes.get(sourcePinCode).put(serviceability.getDestinationPinCode(), serviceability.getPaymentType());
    }

    public HashMap<String, PaymentType> getAllDestinationPincodes(String sourcePinCode) {
        return pinCodes.get(sourcePinCode);
    }
}
