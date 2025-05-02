package service;

import java.util.HashMap;

import model.PaymentType;
import model.PinCodeServiceability;
import repository.PinCodeServiceabilityRepository;

public class PinCodeService {
    PinCodeServiceabilityRepository pinCodeServiceabilityRepository;

    public PinCodeService(PinCodeServiceabilityRepository pinCodeServiceabilityRepository) {
        this.pinCodeServiceabilityRepository = pinCodeServiceabilityRepository;
    }

    public void addPinCodeServiceability(String sourcePin, String destPin, PaymentType paymentType) {
        PinCodeServiceability pinCodeServiceability = new PinCodeServiceability(sourcePin, destPin, paymentType);
        pinCodeServiceabilityRepository.save(pinCodeServiceability);
    }

    public boolean isServiceable(String sourcePinCode, String destinationPinCode, PaymentType paymentType) {
        HashMap<String, PaymentType> allDestinationPincodes = pinCodeServiceabilityRepository
                .getAllDestinationPincodes(sourcePinCode);
        return allDestinationPincodes.containsKey(destinationPinCode)
                && paymentType.equals(allDestinationPincodes.get(destinationPinCode));
    }
}
