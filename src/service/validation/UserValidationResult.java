package service.validation;

public class UserValidationResult {
    private final StringBuilder validationMessage = new StringBuilder();
    private boolean isSeccess = true;

    public void addError(final String errorMessage) {
        validationMessage.append(errorMessage).append("\n");
        isSeccess = false;
    }
     public String getValidationMessage(){return  validationMessage.toString()}

    public boolean isSeccess() {
        return isSeccess;
    }

    public void setSeccess(boolean seccess) {
        isSeccess = seccess;
    }
}
