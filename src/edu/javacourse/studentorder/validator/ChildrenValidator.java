package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCheckChildren;
import edu.javacourse.studentorder.domain.StudentOrder;

public class ChildrenValidator {
    public AnswerCheckChildren checkChildren(StudentOrder studentOrder) {
        System.out.println("checkChildren is running");
        AnswerCheckChildren ans = new AnswerCheckChildren();
        return ans;
    }
}
