package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.exeption.CityRegisterException;
import edu.javacourse.studentorder.exeption.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    private final String GOOD_1 = "1000";
    private final String GOOD_2 = "2000";
    private final String BAD_1 = "1001";
    private final String BAD_2 = "2001";
    private final String ERROR_1 = "1002";
    private final String ERROR_2 = "2002";
    private final String ERROR_T_1 = "1003";
    private final String ERROR_T_2 = "2003";

    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {

        CityRegisterResponse cityRegisterChekerResponse = new CityRegisterResponse();

        if (person instanceof Adult){
            Adult adult = (Adult) person;
            String passportSerial = adult.getPassportSerial();
            if (passportSerial.equals(GOOD_1) || passportSerial.equals(GOOD_2)){
                cityRegisterChekerResponse.setExisting(true);
                cityRegisterChekerResponse.setTemporal(false);
           }
            if (passportSerial.equals(BAD_1) || passportSerial.equals(BAD_2)){
                cityRegisterChekerResponse.setExisting(false);
            }
            if (passportSerial.equals(ERROR_1) || passportSerial.equals(ERROR_2)){
                CityRegisterException cityRegisterException = new CityRegisterException("1", "GRN ERROR " + passportSerial);
                throw  cityRegisterException;
            }
            if (passportSerial.equals(ERROR_T_1) || passportSerial.equals(ERROR_T_2)){
                TransportException transportException = new TransportException("Transport ERROR " + passportSerial);
                throw  transportException;
            }
        }
        if (person instanceof Child){
            cityRegisterChekerResponse.setExisting(true);
            cityRegisterChekerResponse.setTemporal(true);
        }

        System.out.println(cityRegisterChekerResponse);

        return cityRegisterChekerResponse;
    }

}
