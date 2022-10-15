package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {

        StudentOrder so;
        so = new StudentOrder();
        buildStudentOrder();
        long ans = saveStudentOrder(so);
        System.out.println(ans);


    }


    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder: ");
        return answer;
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult();
        husband.setGivenName("Andrey");
        husband.setSurName("Petrov");
        husband.setPassportNumber("123456");
        husband.setPassportSeries("0110");
        so.setHusband(husband);
        husband.getPersonString();
        System.out.println(husband.getPersonString());
        return so;
    }

}
