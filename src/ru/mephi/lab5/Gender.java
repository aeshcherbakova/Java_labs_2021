package ru.mephi.lab5;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String gender;

    Gender(String _gender) {
        gender = _gender;
    }

    public String getGender() {
        return gender;
    }
}
