package com.models;

public enum ResponseMessages {
    VALID_ACCOUNT_CREATION(0, "User has been sucessfully created"),
    DUPLICATE_USERNAME(1, "This user already exists."),
    DUPLICATE_EMAIL(2, "This email is already in use"),
    DATABASE_ERROR(3, "A database error has occured.");

    private final int code;
    private final String description;

    ResponseMessages(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }

}
