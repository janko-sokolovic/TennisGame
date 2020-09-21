package com.example.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameStepsTest {


    private TennisGameSteps game;

    @Test /* --- STEP 0 --- */
    public void newGameScore() { // return LOVE ALL
        game = new TennisGameSteps();
        assertEquals("love all", game.getScore_step11());
    }


    @Before /* --- STEP 1 --- */
    public void setUp() {
        game = new TennisGameSteps();
    }
    @Test
    public void player1ScoresOnce() { // return 15 ALL & Extract to BEFORE
        player1ScoresTimes(1);

        assertEquals("15 love", game.getScore_step11());
    }


     /* --- STEP 2 --- */
    @Test
    public void player1ScoresTwice() {
        player1ScoresTimes(2);

        assertEquals("30 love", game.getScore_step11());
    }

    /* --- STEP 3 --- */
    @Test
    public void player1ScoresThreeTimes() {
        player1ScoresTimes(3);

        assertEquals("40 love", game.getScore_step11());
    }

    private void player1ScoresTimes(int times) {
        for (int i = 0; i < times; i++){
            game.player1Scores();
        }
    }


    /* --- STEP 4 --- */
    @Test
    public void player2ScoresOnce() {
        player2ScoresTimes(1);

        assertEquals("love 15", game.getScore_step11());
    }

    private void player2ScoresTimes(int times) {
        for (int i = 0; i < times; i++) {
            game.player2Scores();
        }
    }


    /* --- STEP 5 --- */
    @Test
    public void player2ScoresTwice() {
        player2ScoresTimes(2);

        assertEquals("love 30", game.getScore_step11());
    }
    @Test
    public void player2ScoresThreeTimes() {
        player2ScoresTimes(3);

        assertEquals("love 40", game.getScore_step11());
    }


    /* --- STEP 6 --- */
    @Test
    public void player1ScoresThreeTimesAndPlayer2ScoresOnce() {
        player1ScoresTimes(3);
        player2ScoresTimes(1);

        assertEquals("40 15", game.getScore_step11());
    }

    /* --- STEP 7 --- */
    @Test
    public void bothPlayersScoredTwice() {
        player1ScoresTimes(2);
        player2ScoresTimes(2);

        assertEquals("30 all", game.getScore_step7());
    }


    /* --- STEP 8 --- */
    @Test
    public void deuce() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);

        assertEquals("deuce", game.getScore_step11());
    }


    /* --- STEP 9 --- */
    @Test
    public void deuceWithManyPoints() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);
        player1ScoresTimes(1);
        player2ScoresTimes(1);
        player2ScoresTimes(1);
        player1ScoresTimes(1);

        assertEquals("deuce", game.getScore_step11());
    }


    /* --- STEP 10 --- */
    @Test
    public void player1Advantage() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);
        player1ScoresTimes(1);
        player2ScoresTimes(1);
        player1ScoresTimes(1);

        assertEquals("Advantage, Player1", game.getScore_step11());
    }

    /* --- STEP 11 --- */
    @Test
    public void player1Won() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);
        player1ScoresTimes(1);
        player1ScoresTimes(1);

        assertEquals("Game, Player1", game.getScore_step11());
    }

}
