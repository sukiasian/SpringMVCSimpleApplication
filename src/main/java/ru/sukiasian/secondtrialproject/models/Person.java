package ru.sukiasian.secondtrialproject.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "нильезя")
    @Size(min = 2, max = 30, message = "nilezya")
    private String name;

    @Min(value = 0, message = "")
    private int age;

    @NotEmpty(message = "")
    @Email(message = "")
    private String email;

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Person() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
}
