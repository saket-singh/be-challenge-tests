package com.freenow.helpers;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailIdValidator {
    /**
     * This method validates an email address
     *
     * @param email Email address in string format.
     */
    public static boolean validateEmailId(String email) {

        EmailValidator validator = EmailValidator.getInstance();

        // Validate specified String containing an email address
        if (validator.isValid(email)) {
            return true;
        }
        return false;
    }
}
