package com.codechallenge.services;

import java.util.List;

import com.codechallenge.models.Team;

public class TeamService {

    //Function to validate String
    public boolean validateStrign(String game) {
        if (!game.contains(", ")) {
            return false;
        } else {
            String[] teams = game.split(", ");
            int temp = 0;
            for (String team : teams) {
                if (team.matches(".*\\d+.*")) {
                    temp++;
                }
            }
            if (temp == 2) {
                return true;
            }
        }
        return false;
    }

    //Funtion to define teams and scores
    public static void defineTeams(String game, List<Team> teams) {

        String[] teamDesc = game.split(", ");
        String[] teamOne = teamDesc[0].split(" ");
        String[] teamTwo = teamDesc[1].split(" ");

        String nameOne = processName(teamOne);
        String nameTwo = processName(teamTwo);

        int scoreOne = Integer.parseInt(teamOne[teamOne.length - 1]);
        int scoreTwo = Integer.parseInt(teamTwo[teamTwo.length - 1]);

        Team firstTeam = findTeam(teams, nameOne);
        Team secondTeam = findTeam(teams, nameTwo);

        if (scoreOne > scoreTwo) {
            firstTeam.addPoints(3);
        } else if (scoreTwo > scoreOne) {
            secondTeam.addPoints(3);
        } else {
            firstTeam.addPoints(1);
            secondTeam.addPoints(1);
        }

    }

    //Function to return complete name
    public static String processName(String[] team) {
        String name = "";
        for (int i = 0; i < team.length - 1; i++) {
            if (i == team.length - 2) {
                name = name + team[i];
            } else {
                name = name + team[i] + " ";
            }
        }
        return name;
    }

    //Function to create a new team Object/Model if it not exist
    public static Team findTeam(List<Team> teams, String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        Team team = new Team(name);
        teams.add(team);
        return team;
    }
}