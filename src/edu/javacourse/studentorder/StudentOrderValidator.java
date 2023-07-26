package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.MarriageValidator;
import edu.javacourse.studentorder.validator.StudentValidator;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterValidator;
    private MarriageValidator marriageValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public StudentOrderValidator(){
        cityRegisterValidator = new CityRegisterValidator();
        marriageValidator = new MarriageValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public void checkAll() {
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


    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        cityRegisterValidator.hostName = "hostName";
        cityRegisterValidator.login = "login";
        cityRegisterValidator.password = "password";
        return cityRegisterValidator.checkCityRegister(so);
    }

    public AnswerMarriage checkMarriage(StudentOrder so) {
        return marriageValidator.checkMarriage(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenValidator.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentValidator.checkStudent(so);
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
