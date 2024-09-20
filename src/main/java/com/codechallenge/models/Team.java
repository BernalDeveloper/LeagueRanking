package com.codechallenge.models;

public class Team {

    //Attributes
    private String name;
    private int points;

    //Constructor
    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    //Function to add points
    public void addPoints(int points) {
        this.points += points;
    }
}