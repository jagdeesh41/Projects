package com.thinkify.tapido.Models;
public class Detail
{

    private String name;
    private char gender;
    private int age;
    private boolean status=false;

    public Detail(String detail)
    {
        String[] user_details=detail.split(", ");
        this.name = user_details[0];
        this.gender = user_details[1].charAt(0);
        this.age = Integer.valueOf(user_details[2]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
