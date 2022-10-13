package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCheckStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentValidator {
    public AnswerCheckStudent checkStudent(StudentOrder studentOrder) {
        System.out.println("checkStudent is running");
        AnswerCheckStudent ans = new AnswerCheckStudent();
        return ans;
    }
}
