package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.domain.children.AnswerChildren;
import edu.javacourse.studentorder.domain.marriage.AnswerMarriage;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.student.AnswerStudent;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.MarriageValidator;
import edu.javacourse.studentorder.validator.StudentValidator;


import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterValidator;
    private MarriageValidator marriageValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        marriageValidator = new MarriageValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public void checkAll() {
        List<StudentOrder> studentOrders = readStudentOrders();

        for (StudentOrder studentOrder : studentOrders) {
            checkOneOrder(studentOrder);
        }
    }

    public void checkOneOrder(StudentOrder studentOrder) {
        AnswerCityRegister answerCityRegister = checkCityRegister(studentOrder);
//        AnswerMarriage answerMarriage = checkMarriage(studentOrder);
//        AnswerChildren answerChildren = checkChildren(studentOrder);
//        AnswerStudent answerStudent = checkStudent(studentOrder);

//        sendMail(studentOrder);
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

    static List<StudentOrder> readStudentOrders() {
        List<StudentOrder> studentOrdersList = new LinkedList<>();
        for (int i = 0; i < 5; i++){
            StudentOrder studentOrder = SaveStudentOrder.buildStudentOrder(i);
            studentOrdersList.add(studentOrder);
        }


        return studentOrdersList;
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
