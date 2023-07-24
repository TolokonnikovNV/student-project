public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll(){
        StudentOrder so = readStudentOrder();

        AnswerCityRegister answerCityRegister = checkCityRegister(so);
        AnswerMarriage answerMarriage = checkMarriage(so);
        AnswerChildren answerChildren = checkChildren(so);
        AnswerStudent answerStudent = checkStudent(so);

        sendMail(so);
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so){
        System.out.println("checkCityRegister");
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        return answerCityRegister;
    }

    static AnswerMarriage checkMarriage(StudentOrder so){
        System.out.println("checkMarriage");
        AnswerMarriage answerMarriage = new AnswerMarriage();
        return answerMarriage;
    }

    static AnswerChildren checkChildren(StudentOrder so){
        System.out.println("checkChildren");
        AnswerChildren answerChildren = new AnswerChildren();
        return answerChildren;
    }

    static AnswerStudent checkStudent(StudentOrder so){
        System.out.println("checkStudent");
        AnswerStudent answerStudent = new AnswerStudent();
        return answerStudent;
    }

    static StudentOrder readStudentOrder(){
        return new StudentOrder();
    }

    static void sendMail(StudentOrder so){

    }
}
