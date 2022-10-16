package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCheckCityRegister;
import edu.javacourse.studentorder.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName;
    private String login;
    private String passWord;
    protected int port;
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCheckCityRegister checkCityRegister(StudentOrder studentOrder) {
        personChecker.checkPerson(studentOrder.getHusband());
        personChecker.checkPerson(studentOrder.getWife());
        personChecker.checkPerson(studentOrder.getChild());

        AnswerCheckCityRegister ans = new AnswerCheckCityRegister();
        return ans;
    }

}
