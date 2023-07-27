package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Address;
import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder: ");
        return answer;
    }

    public static StudentOrder buildStudentOrder(long id){
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderId(id);
        studentOrder.setMarriageCertificateId("" + (123456000 + id));
        studentOrder.setMarriageDate(LocalDate.of(2016, 7, 11));
        studentOrder.setMarriageOffice("ZAGS");

        Address address = new Address("195000", "Lenin street", "1", "", "1");

        Adult husband = new Adult("Vasiliev", "Ivan", "Petrovich",
                LocalDate.of(2000, 1, 1));
        husband.setPassportSerial((1000 + id) + "");
        husband.setPassportNumber((10000 + id) + "");
        husband.setIssueDate(LocalDate.of(2014, 1, 1));
        husband.setIssueDepartment("OUFMS");
        husband.setStudentId((10000 + id) + "");
        husband.setAddress(address);


        Adult wife = new Adult("Vasilieva", "Irina", "Vladimirovna",
                LocalDate.of(2002, 2, 2));
        wife.setPassportSerial((2000 + id) + "");
        wife.setPassportNumber((20000 + id) + "");
        wife.setIssueDate(LocalDate.of(2016, 2, 2));
        wife.setIssueDepartment("OUFMS");
        wife.setStudentId((20000 + id) + "");
        wife.setAddress(address);

        Child child = new Child("Vasiliev", "Vladimir", "Ivanovich",
                LocalDate.of(2023, 3, 3));
        child.setCertificateNumber((30000 + id) + "");
        child.setIssueDate(LocalDate.of(2023, 3, 3));
        child.setIssueDepartment("ZAGS");
        child.setAddress(address);

        studentOrder.setHusband(husband);
        studentOrder.setWife(wife);
        studentOrder.setChild(child);





        return studentOrder;
    }
}
