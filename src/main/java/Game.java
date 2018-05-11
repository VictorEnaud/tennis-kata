import java.util.Map;

import static java.util.Map.entry;

public class Game {
    private int player1Score = 0;
    private int player2Score = 0;
    private Map<Integer, String> tennisScoreNames = Map.ofEntries(
            entry(0, "Love"),
            entry(1, "Fifteen"),
            entry(2, "Thirty"),
            entry(3, "Forty"));

    public String getScore() {
        String score;

        if (player1Score < 3 || player2Score < 3) {
            String player1TennisScore = tennisScoreNames.get(player1Score);
            String player2TennisScore = tennisScoreNames.get(player2Score);

            score = player1TennisScore + "-" + player2TennisScore;
        } else if (player1Score > player2Score) {
            score = "Advantage Player 1";
        } else if (player1Score < player2Score) {
            score = "Advantage Player 2";
        } else {
            score = "Deuce";
        }

        return score;
    }

    public void pointForPlayer(int playerNumber) {
        switch (playerNumber) {
            case 1:
                player1Score++;
                break;
            case 2:
                player2Score++;
                break;
        }
    }

    public Integer getWinner() {
        Integer winner;
        if (player1Score >= 4 && player1Score > player2Score + 1) {
            winner = 1;
        } else if (player2Score >= 4 && player1Score < player2Score) {
            winner = 2;
        } else {
            winner = null;
        }
        return winner;
    }
}
