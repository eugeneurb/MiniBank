package service.validation;

import java.util.regex.Pattern;

public class UserValidator {
    private static UserValidator instance;

    private UserValidator(){}

    public static UserValidator getInstance(){
        if (instance==null){
            instance = new UserValidator();
        }
        return instance;
    }


    public static UserValidationRequest validate(UserValidationRequest request) {
        Pattern userNamePattern = Pattern.compile("[a-zA-Z]{4,8}");
        String userNameInvalid = "Неподходящее имя пользователя (Латинские символы обеих регистров, от 4 до 8 символов)";
        Pattern passwordPattern = Pattern.compile("[0-9]{6,10}");
        String passwordInvalid = "Неподходящий пароль (Цифры, от 6 до 10 символов)";
        Pattern namePattern = Pattern.compile("[a-zA-z]{1,}");
        String nameInvalid = "Неподящее имя (больше 1 символа)";
        Pattern sexPattern = Pattern.compile("[a-zA-z]{1,}");
        String sexInvalid = "Какой пол то?";
        UserValidationResult result = new UserValidationResult();
        if (!userNamePattern.matcher(request.getUserName().matches())){
            result.addError(userNameInvalid);
        }
        if(!passwordPattern.matcher(request.getPassword().matches())){
            result.addError(passwordInvalid);
        }
        if(!namePattern.matcher(request.getFirstName().matches())){
            result.addError(nameInvalid);
        }
        if(!namePattern.matcher(request.getLastName().matches())){
            result.addError(nameInvalid);
        }
        return result;
    }
}
