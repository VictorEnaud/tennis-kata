import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void getScore_shouldReturn_LoveLove_onInit() {
        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Love-Love");
    }

    @Test
    void getScore_shouldReturn_FifteenLove_whenPlayer1WinOnePoint() {
        // Given
        game.pointForPlayer(1);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Fifteen-Love");
    }

    @Test
    void getScore_shouldReturn_LoveFifteen_whenPlayer2WinOnePoint() {
        // Given
        game.pointForPlayer(2);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Love-Fifteen");
    }

    @Test
    void getScore_shouldReturn_FifteenFifteen_whenBothPlayersWinOnePoint() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(2);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Fifteen-Fifteen");
    }

    @Test
    void getScore_shouldReturn_ThirtyLove_whenPlayer1WinTwoPoint() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Thirty-Love");
    }

    @Test
    void getScore_shouldReturn_LoveForty_whenPlayer2WinThreePoint() {
        // Given
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Love-Forty");
    }

    @Test
    void getScore_shouldReturn_Deuce_whenPlayer1AndPlayer2WinThreePoint() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Deuce");
    }

    @Test
    void getScore_shouldReturn_AdvantagePlayer1_whenPlayer1WinFourPointsAndPlayer2WinThreePoints() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Advantage Player 1");
    }

    @Test
    void getScore_shouldReturn_AdvantagePlayer2_whenPlayer2WinFourPointsAndPlayer1WinThreePoints() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        String score = game.getScore();

        // Then
        assertThat(score).isEqualTo("Advantage Player 2");
    }

    @Test
    void getWinner_shouldReturn_null_whenBothPlayerWinLessThan4Points() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        Integer gameWinner = game.getWinner();

        // Then
        assertThat(gameWinner).isNull();
    }

    @Test
    void getWinner_shouldReturn_1_whenPlayer1Win4PointsAndPlayer2LessThan3() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        Integer gameWinner = game.getWinner();

        // Then
        assertThat(gameWinner).isEqualTo(1);
    }

    @Test
    void getWinner_shouldReturn_2_whenPlayer2Win4PointsAndPlayer1LessThan4() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        Integer gameWinner = game.getWinner();

        // Then
        assertThat(gameWinner).isEqualTo(2);
    }

    @Test
    void getWinner_shouldReturn_null_whenBothPlayersWinMoreThan3PointsAndPlayer1Has1PointMore() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        Integer gameWinner = game.getWinner();

        // Then
        assertThat(gameWinner).isNull();
    }

    @Test
    void getWinner_shouldReturn_1_whenBothPlayersWinMoreThan3PointsAndPlayer1Has2PointsMore() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        Integer gameWinner = game.getWinner();

        // Then
        assertThat(gameWinner).isEqualTo(1);
    }

    @Test
    void getWinner_shouldReturn_1_whenBothPlayersWinMoreThan3PointsAndPlayer2Has2PointsMore() {
        // Given
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(1);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);
        game.pointForPlayer(2);

        // When
        Integer gameWinner = game.getWinner();

        // Then
        assertThat(gameWinner).isEqualTo(2);
    }
}