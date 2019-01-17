package com.bestteam;

public class Fruit {
    private String name;
    private String[] people;

    public Fruit(String name, String[] people) {
        this.name = name;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public String[] getPeople() {
        return people;
    }
}