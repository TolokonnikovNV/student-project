package edu.javacourse.studentorder.domain;

public class CityRegisterCheckerResponse {
    private boolean existent;
    private Boolean temporal = null;

    public boolean isExistent() {
        return existent;
    }

    public void setExistent(boolean existent) {
        this.existent = existent;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }
}
