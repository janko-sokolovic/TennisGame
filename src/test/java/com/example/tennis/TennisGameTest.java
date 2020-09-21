package com.example.tennis;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    private TennisGame game;

    @Before
    public void setUp() {
        game = new TennisGame();
    }

    @Test
    public void newGameScore() {
        assertEquals("love all", game.score());
    }

    @Test
    public void player1ScoresOnce() {
        game.player1Scores();

        assertEquals("15 love", game.score());
    }

    @Test
    public void player1ScoresTwice() {
        player1ScoresTimes(2);

        assertEquals("30 love", game.score());
    }

    @Test
    public void player1ScoresThreeTimes() {
        player1ScoresTimes(3);

        assertEquals("40 love", game.score());
    }

    @Test
    public void player2ScoresOnce() {
        game.player2Scores();

        assertEquals("love 15", game.score());
    }

    @Test
    public void player2ScoresTwice() {
        player2ScoresTimes(2);

        assertEquals("love 30", game.score());
    }

    @Test
    public void player2ScoresThreeTimes() {
        player2ScoresTimes(3);

        assertEquals("love 40", game.score());
    }

    @Test
    public void player1ScoresThreeTimesAndPlayer2ScoresOnce() {
        player1ScoresTimes(3);
        player2ScoresTimes(1);

        assertEquals("40 15", game.score());
    }

    @Test
    public void deuce() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);

        assertEquals("deuce", game.score());
    }

    @Test
    public void deuceWithManyPoints() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);
        player1ScoresTimes(1);
        player2ScoresTimes(1);
        player2ScoresTimes(1);
        player1ScoresTimes(1);

        assertEquals("deuce", game.score());
    }

    @Test
    public void player1Advantage() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);
        player1ScoresTimes(1);
        player2ScoresTimes(1);
        player1ScoresTimes(1);

        assertEquals("Advantage, Player1", game.score());
    }

    @Test
    public void player1Won() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);
        player1ScoresTimes(1);
        player1ScoresTimes(1);

        assertEquals("Game, Player1", game.score());
    }

    @Test
    public void player2Won() {
        player2ScoresTimes(3);
        player2ScoresTimes(1);

        assertEquals("Game, Player2", game.score());
    }

    @Test
    public void player2Advantage() {
        player1ScoresTimes(3);
        player2ScoresTimes(3);
        player2ScoresTimes(1);

        assertEquals("Advantage, Player2", game.score());
    }



    private void player1ScoresTimes(int times) {
        for (int i = 0; i < times; i++) {
            game.player1Scores();
        }
    }
    private void player2ScoresTimes(int times) {
        for (int i = 0; i < times; i++) {
            game.player2Scores();
        }
    }

}
