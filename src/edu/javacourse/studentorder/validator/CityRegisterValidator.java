package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exeption.CityRegisterException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

import java.util.Iterator;
import java.util.List;

public class CityRegisterValidator {

    public String hostName;
    public String login;
    public String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
            answerCityRegister.addItem(checkPerson(so.getHusband()));
            answerCityRegister.addItem(checkPerson(so.getWife()));

            List<Child> children = so.getChildren();
            for(Child child: so.getChildren()){
                answerCityRegister.addItem(checkPerson(child));
            }



        return answerCityRegister;
    }


    private AnswerCityRegisterItem checkPerson(Person person){
        try {
            CityRegisterResponse husbandAnswer = personChecker.checkPerson(person);
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
