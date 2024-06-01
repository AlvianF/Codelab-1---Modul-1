package com.main.codelab6;

public class User {

    private String name, nim, gender;

    public User (String name, String nim, String gender) {
        this.name = name;
        this.nim = nim;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getGender() {
        return gender;
    }
}
