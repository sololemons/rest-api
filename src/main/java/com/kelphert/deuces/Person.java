package com.kelphert.deuces;

import jakarta.persistence.*;


@Entity
@Table(name="PERSON")
public class Person {


    @Column(name = "ID")
@Id

    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "AGE")
    private  int age;
    @Column(name = "STATE")
    private String state;

    public Person(int id, String first_name, String last_name, int age, String state) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.state = state;
    }

    public Person() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                '}';
    }
}
