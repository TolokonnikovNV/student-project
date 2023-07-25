package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.sethFirstName("Alex");
        so.sethLastName("Petrov");
        so.setwFirstName("Galina");
        so.setwFirstName("Petrova");

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder: " + studentOrder.gethFirstName() + " " + studentOrder.gethLastName()
                + " " +                           studentOrder.getwFirstName() + " " + studentOrder.getwLastName());
        return answer;
    }
}
