package com.example.week1assignment.personal;

public class Person {
    private String name;
    private int age;
    private String job;

    public Person(){

    }
    public Person(String name, int age, String job){

    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
