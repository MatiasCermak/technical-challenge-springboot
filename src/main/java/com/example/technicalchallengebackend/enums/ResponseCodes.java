package com.example.technicalchallengebackend.enums;

import lombok.Getter;

@Getter
public enum ResponseCodes {
    OK ("I1", "Operation Successful"),
    AGE_DATE_MISMATCH ("E1", "Age and Date do not match"),
    NOT_FOUND ("E2", "Request endpoint not found");

    private final String code;
    private final String message;

    ResponseCodes(String code, String message){
        this.code = code;
        this.message = message;
    }
}
