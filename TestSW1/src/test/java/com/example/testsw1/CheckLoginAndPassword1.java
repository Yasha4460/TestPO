package com.example.testsw1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckLoginAndPassword1 {
    @Test
    public void testValidLogin() {
        LoginValidator validator = new LoginValidator();
        boolean result = validator.isLoginValid("myusername");
        assertTrue(result);
    }

    @Test
    public void testInvalidLogin() {
        LoginValidator validator = new LoginValidator();
        boolean result = validator.isLoginValid("rwer#132");
        assertFalse(result);
    }

    @Test
    public void testValidPassword() {
        LoginValidator validator = new LoginValidator();
        boolean result = validator.isPasswordValid("mypassword123");
        assertTrue(result);
    }

    @Test
    public void testInvalidPassword() {
        LoginValidator validator = new LoginValidator();
        boolean result = validator.isPasswordValid("rwer#132");
        assertFalse(result);
    }

}
