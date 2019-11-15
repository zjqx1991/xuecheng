package com.revanwang.xc.freemarker.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Student {
    private String name;
    private Integer age;
    private Date birthday;
    private double money;
    private List<Student> friends;
    private Student bestFriend;
}
