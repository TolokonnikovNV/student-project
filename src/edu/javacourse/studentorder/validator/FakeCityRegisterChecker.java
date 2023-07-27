package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.CityRegisterChekerResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exeption.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterChekerResponse checkPerson(Person person) throws CityRegisterException {
        return null;
    }

}
