package com.example.tennis;

import java.util.Map;

public class TennisGame {

    private int player1Score;
    private int player2Score;

    private final Map<Integer, String> pointsMap = Map.of(
            0, "love",
            1, "15",
            2, "30",
            3, "40"
    );

    public void player1Scores() {
        player1Score++;
    }

    public void player2Scores() {
        player2Score++;
    }

    public String score() {
        if (isGameFinished()) return winner();

        if (isDeuce()) return "deuce";

        if (isAdv()) return advantagePlayer();

        if (isTie()) return pointsMap.get(player1Score) + " all";

        else return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }


    private boolean isDeuce() {
        return player1Score > 2 && isTie();
    }

    private boolean isGameFinished() {
        return (player1Score > 3 || player2Score > 3) && Math.abs(player1Score - player2Score) > 1;
    }

    private String winner() {
        return "Game, " + leadingPlayer();
    }

    private String advantagePlayer() {
        return "Advantage, " + leadingPlayer();
    }

    private String leadingPlayer() {
        return player1Score > player2Score ? "Player1" : "Player2";
    }

    private boolean isAdv() {
        return player1Score > 2 && player2Score > 2 && player1Score != player2Score;
    }

    private boolean isTie() {
        return player1Score == player2Score;
    }
}
