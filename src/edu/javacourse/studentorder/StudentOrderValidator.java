package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.MarriageValidator;
import edu.javacourse.studentorder.validator.StudentValidator;

public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {
        while (true) {
            StudentOrder so = readStudentOrder();
            if (so == null) {
                break;
            }
            AnswerCityRegister answerCityRegister = checkCityRegister(so);
            if (!answerCityRegister.success) {
//                continue;
                break;
            }
            AnswerMarriage answerMarriage = checkMarriage(so);
            AnswerChildren answerChildren = checkChildren(so);
            AnswerStudent answerStudent = checkStudent(so);

            sendMail(so);

            so = readStudentOrder();
        }
    }


    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator cityRegisterValidator = new CityRegisterValidator();
        cityRegisterValidator.hostName = "hostName";
        cityRegisterValidator.login = "login";
        cityRegisterValidator.password = "password";
        return cityRegisterValidator.checkCityRegister(so);
    }

    static AnswerMarriage checkMarriage(StudentOrder so) {
        MarriageValidator marriageValidator = new MarriageValidator();
        return marriageValidator.checkMarriage(so);
    }

    static AnswerChildren checkChildren(StudentOrder so) {
        ChildrenValidator childrenValidator = new ChildrenValidator();
        return childrenValidator.checkChildren(so);
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        StudentValidator studentValidator = new StudentValidator();
        return studentValidator.checkStudent(so);
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static void sendMail(StudentOrder so) {
        MailSender mailSender = new MailSender();
        mailSender.sendMail(so);
    }
}
