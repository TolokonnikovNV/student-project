package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.CityRegisterChekerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exeption.CityRegisterException;

public class CityRegisterValidator {

    public String hostName;
    public String login;
    public String password;

    private CityRegisterChecker checkPerson;

    public CityRegisterValidator() {
        checkPerson = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        try {
            CityRegisterChekerResponse husbandAnswer = checkPerson.checkPerson(so.getHusband());
            CityRegisterChekerResponse wifeAnswer = checkPerson.checkPerson(so.getWife());
            CityRegisterChekerResponse childAnswer = checkPerson.checkPerson(so.getChild());
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }


        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        return answerCityRegister;
    }
}
