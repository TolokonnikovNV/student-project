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
            if (!answerCityRegister.success){
                continue;
            }
            AnswerMarriage answerMarriage = checkMarriage(so);
            AnswerChildren answerChildren = checkChildren(so);
            AnswerStudent answerStudent = checkStudent(so);

            sendMail(so);

            so = readStudentOrder();
        }
    }


    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("checkCityRegister");
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        answerCityRegister.success = false;
        return answerCityRegister;
    }

    static AnswerMarriage checkMarriage(StudentOrder so) {
        System.out.println("checkMarriage");
        AnswerMarriage answerMarriage = new AnswerMarriage();
        return answerMarriage;
    }

    static AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("checkChildren");
        AnswerChildren answerChildren = new AnswerChildren();
        return answerChildren;
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("checkStudent");
        AnswerStudent answerStudent = new AnswerStudent();
        return answerStudent;
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static void sendMail(StudentOrder so) {
        System.out.println("Sending mail");
    }
}
