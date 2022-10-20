package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCheckCityRegister;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            List<Child> children = studentOrder.getChildren();
            for (int i=0; i < studentOrder.getChildren().size(); i++){

            CityRegisterCheckerResponse childAns = personChecker.checkPerson(children.get(i));
            }
            for(Iterator<Child> it = children.iterator(); it.hasNext();){
                Child child = it.next();
                CityRegisterCheckerResponse childAns = personChecker.checkPerson(child);

            }

            for (Child child: studentOrder.getChildren()){
                CityRegisterCheckerResponse childAns = personChecker.checkPerson(child);
            }
        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
        }


        AnswerCheckCityRegister ans = new AnswerCheckCityRegister();
        return ans;
    }

}
