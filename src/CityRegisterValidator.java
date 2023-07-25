public class CityRegisterValidator {

    String hostName;
    String login;
    String password;

    AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("checkCityRegister " + hostName + " " + login + " " + password);
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        answerCityRegister.success = false;
        return answerCityRegister;
    }
}
