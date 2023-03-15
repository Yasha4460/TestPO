package com.example.testsw1;

public class LoginValidator {
    public boolean isLoginValid(String login) {
        // регулярное выражение. могут быть только цифры и латинские символы
        String regex = "^[a-zA-Z0-9]+$";
        // если не нул и если не пустой и если соответствует рег выражению то возвращает
        return login != null && !login.isEmpty() && login.matches(regex);
    }

    public boolean isPasswordValid(String password) {
        String regex = "^[a-zA-Z0-9]+$";
        return password != null && !password.isEmpty() && password.matches(regex);
    }
}
