package com.basicappstructure.utils;

import android.widget.EditText;

public class AppValidation {

    public static final String EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z]{2,3}" +
            ")+";

    public static boolean isValidEmail(String emailId) {
        // return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        return emailId.matches(EMAIL_PATTERN);
    }

    public static boolean isEmpty(EditText... view) {

        for (EditText v : view) {
            if (v.getText().toString().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isConfirmPassword(String text, String text1) {
        if (text.equals(text1)) {
            return true;
        }
        return false;
    }
}
