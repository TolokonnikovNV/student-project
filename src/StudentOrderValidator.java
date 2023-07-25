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


    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator cityRegisterValidator = new CityRegisterValidator();
        cityRegisterValidator.hostName = "hostName";
        cityRegisterValidator.login = "login";
        cityRegisterValidator.password = "password";
        return cityRegisterValidator.checkCityRegister(so);
    }

    static AnswerMarriage checkMarriage(StudentOrder so) {
        return MarriageValidator.checkMarriage(so);
    }

    static AnswerChildren checkChildren(StudentOrder so) {
        return ChildrenValidator.checkChildren(so);
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        return StudentValidator.checkStudent(so);
    }

    static StudentOrder readStudentOrder() {
        StudentOrder studentOrder = new StudentOrder();
        return studentOrder;
    }

    static void sendMail(StudentOrder so) {
        System.out.println("Sending mail");
    }
}
