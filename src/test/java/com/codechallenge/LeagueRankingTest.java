package com.codechallenge;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueRankingTest{

    @Test
    public void LeagueRankingTest(){

        //Input data
        String input = "Lions 3, Snakes 3"+ System.lineSeparator() +
                        "Tarantulas 1, FC Awesome 0"+ System.lineSeparator() +
                        "Lions 1, FC Awesome 1"+ System.lineSeparator() +
                        "Tarantulas 3, Snakes 1 "+ System.lineSeparator() +
                        "Lions 4, Grouches 0";

        //Output data
        String output = "1. Tarantulas, 6 pts" + System.lineSeparator() +
                        "2. Lions, 5 pts" + System.lineSeparator() +
                        "3. FC Awesome, 1 pt" + System.lineSeparator() +
                        "3. Snakes, 1 pt" + System.lineSeparator() +
                        "5. Grouches, 0 pts";

        //Test input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //Output capture
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //Execute main class
        try{
            LeagueRanking.main(new String[]{});
        } catch(Exception e){
            System.out.println(e);
        }

        //Comparator
        assertEquals(output, out.toString().trim());
    }
}
