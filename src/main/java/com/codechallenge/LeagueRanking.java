package com.codechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codechallenge.models.Team;
import com.codechallenge.services.TeamService;

public class LeagueRanking {
    public static void main(String[] args) throws Exception {

        //Variables and object declaration
        Scanner scan = new Scanner(System.in);
        TeamService teamService = new TeamService();
        List<Team> teams = new ArrayList<>();

        //Save and validate games
        while (scan.hasNextLine()) {
            String game = scan.nextLine();
            if (teamService.validateStrign(game)) {
                teamService.defineTeams(game, teams);
            } else {
                System.out.println("Input a correct value please.");
            }
        }

        //Order teams by points and names
        teams.sort((teamOne, teamTwo) -> {
            if (teamOne.getPoints() != teamTwo.getPoints()) {
                return teamTwo.getPoints() - teamOne.getPoints();//Order by points
            }
            return teamOne.getName().compareTo(teamTwo.getName());//Alphabetical order
        });

        //Show final list
        int position = 1;
        for (int i = 1; i <= teams.size(); i++) {
            System.out.println(position + ". " + teams.get(i - 1).getName() + ", " + teams.get(i - 1).getPoints()
                    + (teams.get(i - 1).getPoints() == 1 ? " pt" : " pts"));
            if (i <= teams.size() - 1 && teams.get(i - 1).getPoints() != teams.get(i).getPoints()) {
                position = i + 1;
            }
        }
    }
}