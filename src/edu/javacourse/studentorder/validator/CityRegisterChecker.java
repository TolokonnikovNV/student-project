package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.CityRegisterChekerResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exeption.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterChekerResponse checkPerson(Person person) throws CityRegisterException;
}
