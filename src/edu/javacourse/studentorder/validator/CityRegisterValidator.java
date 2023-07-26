package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName;
    public String login;
    public String password;

    private CityRegisterChecker checkPerson;

    public CityRegisterValidator() {
        checkPerson = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        checkPerson.checkPerson(so.getHusband());
        checkPerson.checkPerson(so.getWife());
        checkPerson.checkPerson(so.getChild());

        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        return answerCityRegister;
    }
}
