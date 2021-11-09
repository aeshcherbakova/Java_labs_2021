package ru.mephi.lab5;

public enum GENDER {
    MALE("male"),
    FEMALE("female");

    private final String gender;

    GENDER(String _gender) {
        gender = _gender;
    }

    public String getGender() {
        return gender;
    }
}
