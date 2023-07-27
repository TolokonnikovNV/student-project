package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.register.CityRegisterChekerResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exeption.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterChekerResponse checkPerson(Person person) throws CityRegisterException;
}
