package com.adaptionsoft.games.uglytrivia;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @InjectMocks
    private Game game;
    @Mock
    private Console console;

    @Test
    public void add_shouldCallPrintAddingPlayerWithCorrectParameters() throws Exception {
        game.add("jos");
        verify(console).printAddingPlayer("jos",1);
        game.add("jo");
        verify(console).printAddingPlayer("jo",2);
    }
    @Test
    public void roll_shouldCallPrintPlayerAndRollWithCorrectParameters() throws Exception {
        game.add("jos");
        game.roll(1);
        verify(console).printPlayerAndRoll(1,"jos");
    }

    @Test
    public void roll_shouldCallPrintPlayersLocationAndCategoryWithCorrectParameters() throws Exception {
        game.add("jos");
        game.roll(1);
        verify(console).printPlayersLocationAndCategory("jos",1,"Science");
    }
    @Test
    public void wasCorrectlyAnswered_shouldCallPrintCorrectAnswerAndGoldCoinsWithCorrectParameters() throws Exception {
        game.add("jos");
        game.wasCorrectlyAnswered();
        verify(console).printCorrectAnswerAndGoldCoins("jos",1);
    }
    @Test
    public void wrongAnswer_shouldCallPrintWrongAnswerAndSentToPenaltyBoxWithCorrectParameters() throws Exception {
        game.add("jos");
        game.wrongAnswer();
        verify(console).printWrongAnswerAndSentToPenaltyBox("jos");
    }
    @Test
    public void roll_WhenPlayerGetsOutOfPenaltyBox_shouldCallPrintGetsOutOfPenaltyBoxWithCorrectParameters()  throws Exception {
        game.add("jos");
        game.wrongAnswer();
        game.roll(1);
        verify(console).printGetsOutOfPenaltyBox("jos");
    }
    @Test
    public void roll_WhenPlayerGetsOutOfPenaltyBox_shouldCallPlayersLocationAndCategoryWithCorrectParameters()  throws Exception {
        game.add("jos");
        game.wrongAnswer();
        game.roll(1);
        verify(console).printPlayersLocationAndCategory("jos",1,"Science");
    }
    @Test
    public void roll_WhenPlayerDoesNotGetOutOfPenaltyBox_shouldCallPrintStaysInPenaltyBoxWithCorrectParameters()  throws Exception {
        game.add("jos");
        game.wrongAnswer();
        game.roll(2);
        verify(console).printStaysInPenaltyBox("jos");
    }


    @Test
    public void addMethod_ShouldIncreasePlayersSize() throws Exception {
        Game test = new Game();
        test.add("wim");
        Assertions.assertThat(test.howManyPlayers()).isEqualTo(1);

        test.add("wilfried");
        Assertions.assertThat(test.howManyPlayers()).isEqualTo(2);
    }
}