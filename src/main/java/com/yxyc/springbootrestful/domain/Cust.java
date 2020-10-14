package com.yxyc.springbootrestful.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Cust {

    String id;
    String gender;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    Date birthday;
    int age;


    @Override
    public String toString() {
        return "Cust{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", age='" + age + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getId() {

        return id;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
