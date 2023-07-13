package ss8_clean_code;

public class TennisGame {
    private static final int NO_SCORE = 0;
    private static final int SCORE_FIRST = 1;
    private static final int SCORE_SECOND = 2;
    private static final int SCORE_THIRD = 3;

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (scorePlayer1 == scorePlayer2) {
            switch (scorePlayer1) {
                case NO_SCORE:
                    score = new StringBuilder("Love-All");
                    break;
                case SCORE_FIRST:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case SCORE_SECOND:
                    score = new StringBuilder("Thirty-All");
                    break;
                case SCORE_THIRD:
                    score = new StringBuilder("Forty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;

            }
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            score = new StringBuilder(getAdvantage(player1Name, player2Name, scorePlayer1, scorePlayer2));
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scorePlayer1;
                else {
                    score.append("-");
                    tempScore = scorePlayer2;
                }
                switch (tempScore) {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                }
            }
        }
        return score.toString();
    }

    private static String getAdvantage(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) score = "Advantage " + player1Name;
        else if (minusResult == -1) score = "Advantage " + player2Name;
        else if (minusResult >= 2) score = "Win for " + player1Name;
        else score = "Win for " + player2Name;
        return score;
    }
}
