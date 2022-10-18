package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCheckCityRegister;
import edu.javacourse.studentorder.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class CityRegisterValidator {

    public String hostName;
    private String login;
    private String passWord;
    protected int port;
    private CityRegisterChecker personChecker; //интерфейс доступа к городской базе регистратора

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCheckCityRegister checkCityRegister(StudentOrder studentOrder) {
        //тут хранятся ответы от регистратора о регистрации:
        // зарегестрирован/нет, если да то временная или нет регистрация
        try {
            CityRegisterCheckerResponse husbandAns = personChecker.checkPerson(studentOrder.getHusband());
            CityRegisterCheckerResponse wifeAns = personChecker.checkPerson(studentOrder.getWife());
            CityRegisterCheckerResponse childAns = personChecker.checkPerson(studentOrder.getChild());
        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
        }


        AnswerCheckCityRegister ans = new AnswerCheckCityRegister();
        return ans;
    }

}
