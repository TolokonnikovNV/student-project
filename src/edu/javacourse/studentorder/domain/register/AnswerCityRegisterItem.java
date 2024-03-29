package edu.javacourse.studentorder.domain.register;

import edu.javacourse.studentorder.domain.Person;

public class AnswerCityRegisterItem {

    public enum CityStatus{
        YES, NO, ERROR;
    }

    public static class CityError {
        private String code;
        private String text;

        public CityError(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }

    private Person person;
    private CityStatus cityStatus;
    private CityError cityError;

    public AnswerCityRegisterItem(Person person, CityStatus cityStatus, CityError cityError) {
        this.person = person;
        this.cityStatus = cityStatus;
        this.cityError = cityError;
    }

    public AnswerCityRegisterItem(Person person, CityStatus cityStatus) {
        this.person = person;
        this.cityStatus = cityStatus;
    }

    public Person getPerson() {
        return person;
    }

    public CityStatus getCityStatus() {
        return cityStatus;
    }

    public CityError getCityError() {
        return cityError;
    }
}
