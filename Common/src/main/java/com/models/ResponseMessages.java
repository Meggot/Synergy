package com.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum ResponseMessages {
    VALID_ACCOUNT_CREATION(0, "User has been sucessfully created"),
    DUPLICATE_USERNAME(1, "This user already exists."),
    DUPLICATE_EMAIL(2, "This email is already in use"),
    DATABASE_ERROR(3, "A database error has occured."),
    VALID_ACCOUNT_UPDATE(4, "User has been successfully updated"),
    USER_ID_INVALID(5, "A user by that ID doesn't exist"),
    INVALID_DATE_OF_BIRTH(6, "That D.O.B date is invalid, format is: DD/MM/YYYY"),
    INVALID_ACCOUNT_UPDATE(7, "No fields were changed, updates must have changed values in request"),
    VALID_PROJECT_CREATION(8, "Project successfully created"),
    ACCOUNT_DOESNT_EXIST(9, "Specified userid doesn't exist" ),
    VALID_PROJECT_SEARCH(10, "Valid project search"),
    PROJECT_DOESNT_EXIST(11, "That projectID doesn't exist" ),
    VALID_PROJECT_SETTING(12, "Valid project setting request" ),
    PROJECT_SETTING_ADDED(13, "Project setting added successfully"),
    VALID_PROJECT_PART_SEARCH(14, "Project part search valid");
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
