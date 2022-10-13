package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCheckCityRegister;
import edu.javacourse.studentorder.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName;
    public String login;
    public String passWord;
    int port;


     public AnswerCheckCityRegister checkCityRegister(StudentOrder studentOrder) {
        System.out.println("checkCityRegister is running "
                + hostName + ", " + login + ", " + passWord);
        AnswerCheckCityRegister ans = new AnswerCheckCityRegister();
        ans.success = false;
        return ans;
    }

}
