package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterValidator;
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public static void main(String[] args) {

        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public void checkAll() {
        StudentOrder[] soArray = readStudentOrders();
        for (StudentOrder so : soArray) {
            checkOneOrder(so);
        }
    }


    public void checkOneOrder(StudentOrder so) {
        AnswerCheckCityRegister cityAnswer = checkCityRegister(so);
//        AnswerCheckWedding weddingAnswer = checkWedding(so);
//        AnswerCheckChildren childrenAnswer = checkChildren(so);
//        AnswerCheckStudent studentAnswer = checkStudent(so);
//        sendMail(so);
    }

    public void sendMail(StudentOrder studentOrder) {
        mailSender.sendMail(studentOrder);
    }

    public StudentOrder[] readStudentOrders() {
        StudentOrder[] soArray = new StudentOrder[3];

        for (int i = 0; i < soArray.length; i++) {
            soArray[i] = SaveStudentOrder.buildStudentOrder(i);
        }
        return soArray;

    }

    public AnswerCheckCityRegister checkCityRegister(StudentOrder studentOrder) {
        return cityRegisterValidator.checkCityRegister(studentOrder);
    }

    public AnswerCheckWedding checkWedding(StudentOrder studentOrder) {

        return weddingValidator.checkWedding(studentOrder);
    }

    public AnswerCheckChildren checkChildren(StudentOrder studentOrder) {
        return childrenValidator.checkChildren(studentOrder);
    }

    public AnswerCheckStudent checkStudent(StudentOrder studentOrder) {
        return studentValidator.checkStudent(studentOrder);

    }
}
