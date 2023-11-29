package com.example.tennis;

import java.util.Map;

public class TennisGameSteps {

    private int player1Score;
    private int player2Score;

    /* STEP 0 */
    public String getScore_step0() {
        return "love all";
    }


    /* STEP 1 */
    public String getScore_step1() {
        if (player1Score == 1) return "15 love";
        return "love all";
    }

    public void player1Scores() {
        player1Score++;
    }

    /* STEP 2*/
    public String getScore_step2() {
        if (player1Score == 1) return "15 love";
        if (player1Score == 2) return "30 love";

        return "love all";
    }


    /* STEP 3 */
    public String getScore_step3() {
        if (player1Score == 1) return "15 love";
        if (player1Score == 2) return "30 love";
        if (player1Score == 3) return "40 love";

        return "love all";
    }

    /* STEP 4 */
    public void player2Scores() {
        player2Score++;
    }

    private final Map<Integer, String> pointsMap = Map.of(
            0, "love",
            1, "15",
            2, "30",
            3, "40"
    );

    public String getScore_step4() {
        if (player1Score == 0 && player2Score == 0) return "love all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }


    /* STEP 5 - SAME AS STEP 4 */
    public String getScore_step5() {
        if (player1Score == 0 && player2Score == 0) return "love all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }

    /* STEP 6 - SAME AS STEP 4,5 */
    public String getScore_step6() {
        if (player1Score == 0 && player2Score == 0) return "love all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }


    /* STEP 7  */
    public String getScore_step7() {
        if (player1Score == player2Score && player1Score > 2) return "deuce";

        if (isTie()) return pointsMap.get(player1Score) + " all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }

    private boolean isTie() {
        return player1Score == player2Score;
    }

    /* STEP 8  */
    public String getScore_step8() {
        if (player1Score == player2Score && player1Score > 2) return "deuce";

        if (isTie()) return pointsMap.get(player1Score) + " all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }

    /* STEP 9 SAME  */
    public String getScore_step9() {
        if (player1Score == player2Score && player1Score > 2) return "deuce";

        if (isTie()) return pointsMap.get(player1Score) + " all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }

    /* STEP 10  */
    public String getScore_step10() {
        if (isDeuce()) return "deuce";

        if (isAdvantage()) return advantagePlayer();

        if (isTie()) return pointsMap.get(player1Score) + " all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }

    private boolean isDeuce() {
        return player1Score == player2Score && player1Score > 2;
    }

    private boolean isAdvantage() {
        return player1Score > 2 && player2Score > 2 && player1Score != player2Score;
    }

    private String advantagePlayer() {
        return "Advantage, " + leadingPlayer();
    }

    private String leadingPlayer() {
        return player1Score > player2Score ? "Player1" : "Player2";
    }


    /* STEP 11 */
    public String getScore_step11() {
        if (gameFinished()) return winner();

        if (isDeuce()) return "deuce";

        if (isAdvantage()) return advantagePlayer();

        if (isTie()) return pointsMap.get(player1Score) + " all";

        return pointsMap.get(player1Score) + " " + pointsMap.get(player2Score);
    }

    private boolean gameFinished() {
        return Math.abs(player1Score - player2Score) > 1 && (player1Score > 3 || player2Score > 3);
    }

    private String winner() {
        return "Game, " + leadingPlayer();
    }

}
