package UI;


import exception.ExitAppException;
import logger.Logger;
import logger.LoggerFactory;
import model.Sex;
import model.User;
import service.UserService;
import service.validation.UserValidationRequest;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleInterface {
    private final Scanner scanner;
    private final Session session = Session.getInstance();
    private final UserService userService = UserService.getInstance();
    private final Logger log = LoggerFactory.getInstance(ConsoleInterface.class);

    public ConsoleInterface(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void loginLoop() {
        while (true) {
            System.out.println("Добро пожаловать в систему");
            System.out.println("1 Войти");
            System.out.println("2 Регистрация");
            System.out.println("0 Выход из системы");

            int loginChoose = scanner.nextInt();
            switch (loginChoose) {
                case 1: {
                    System.out.println("Введите логин:");
                    String userNameInput = scanner.next();
                    System.out.println("Введите пароль:");
                    String passwordInput = scanner.next();
                    User loginResult = userService.checkLogin(userNameInput, passwordInput);
                    if (loginResult != null) {
                        System.out.printf("Добро пожаловать в систему, %s%n", loginResult.getFirstName());
                        session.createSession(loginResult);
                        log.info("Успешный вход для %s" + String.format(loginResult.getUserName()));
                        return;
                    } else {
                        System.out.println("Введены неверные данные. Повторите попытку.");
                        break;
                    }
                }
                case 2: {
                    System.out.println("Введите логин");
                    String userName = scanner.next();
                    System.out.println("Введите пароль");
                    String password = scanner.next();
                    System.out.println("Введите Имя");
                    String firstName = scanner.next();
                    System.out.println("Введите Фамилию");
                    String lastName = scanner.next();
                    System.out.println("Введите дату рождения в формате гггг-мм-дд");
                    String birthDay = scanner.next();
                    System.out.println("Введите пол M/F");
                    String sex = scanner.next();
                    System.out.println("Введите почту");
                    String email = scanner.next();

                    UserValidationRequest request = new UserValidationRequest(userName, password, firstName, lastName,
                            birthDay,sex,email);
                    UserValidationRequest result = userService.validate(request);

                    if (result.isSucces()){
                        User user = userService.create(request);
                        Session.createSession(user);
                        System.out.println("Добро пожаловать в систему, %s \n",+ user.getFirstName());
                        return;
                    }else{
                        System.out.println("Ошибка при создании пользователя. \n"+ result.getValidationMessage());
                        continue;
                    }
                }
                case 0: {
                    throw new ExitAppException();

                }
                default: {
                    break;
                }
            }
        }

    }

    public void mainLoop() {
        while (true) {
            System.out.println("1 Операции со счетом");
            System.out.println("2 Работа с историей оперций");
            System.out.println("0 Завершить работу");

            int mainChoose = scanner.nextInt();
            switch (mainChoose) {
                case 0: {
                    throw new ExitAppException();
                }
                default: {
                    System.out.println("Система остановлена");
                    return;
                }
            }
        }

    }
}
