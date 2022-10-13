package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

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

            AnswerCheckCityRegister cityAnswer = checkCityRegister(so);
            if (!cityAnswer.success) {
                break; //temp
                //continue;
            }

            AnswerCheckWeddind weddingAnswer = checkWedding(so);
            AnswerCheckChildren childrenAnswer = checkChildren(so);
            AnswerCheckStudent studentAnswer = checkStudent(so);

            sendMail(so);
        }
    }

    static void sendMail(StudentOrder studentOrder) {
        MailSender ms = new MailSender();
        ms.sendMail(studentOrder);
    }

    static StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder();
        return so;
    }

    static AnswerCheckCityRegister checkCityRegister(StudentOrder studentOrder) {
        CityRegisterValidator crv = new CityRegisterValidator();
        crv.hostName = "host1";
        crv.login = "login1";
        crv.passWord = "passWord1";
        AnswerCheckCityRegister ans = crv.checkCityRegister(studentOrder);
        return ans;
    }

    static AnswerCheckWeddind checkWedding(StudentOrder studentOrder) {
        WeddingValidator wv = new WeddingValidator();
        AnswerCheckWeddind ans = wv.checkWedding(studentOrder);
        return ans;
    }

    static AnswerCheckChildren checkChildren(StudentOrder studentOrder) {
        ChildrenValidator cv = new ChildrenValidator();
        AnswerCheckChildren ans = cv.checkChildren(studentOrder);
        return ans;
    }

    static AnswerCheckStudent checkStudent(StudentOrder studentOrder) {
        StudentValidator sv = new StudentValidator();
        AnswerCheckStudent ans = sv.checkStudent(studentOrder);
        return ans;

    }
}
