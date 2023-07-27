package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.domain.register.CityRegisterChekerResponse;
import edu.javacourse.studentorder.exeption.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    private final String GOOD_1 = "1000";
    private final String GOOD_2 = "2000";
    private final String BAD_1 = "1001";
    private final String BAD_2 = "2001";
    private final String ERROR_1 = "1002";
    private final String ERROR_2 = "2002";

    public CityRegisterChekerResponse checkPerson(Person person) throws CityRegisterException {

        CityRegisterChekerResponse cityRegisterChekerResponse = new CityRegisterChekerResponse();

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
                CityRegisterException cityRegisterException = new CityRegisterException("FAKE ERROR");
                throw  cityRegisterException;
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
