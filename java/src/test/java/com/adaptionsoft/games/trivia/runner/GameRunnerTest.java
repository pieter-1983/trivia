package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GameRunnerTest {


    @Test
    public void rollTwo_ShouldWriteExpectedOutputToConsole() throws Exception {
        //setup outcontent to capture console logs from game methods
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Game aGame = new Game();
        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");
        aGame.roll(2);

        String result = "Chet was added\r\n" +
                "They are player number 1\r\n" +
                "Pat was added\r\n" +
                "They are player number 2\r\n" +
                "Sue was added\r\n" +
                "They are player number 3\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 2\r\n" +
                "Chet's new location is 2\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 0\r\n";

        assertEquals(result, outContent.toString());
    }

    @Test
    public void wrongAnswerShouldAlwaysReturnTrue_CorrectAnswerShouldReturnFalseWhenPurseHitsSix() throws Exception {
        Game aGame = new Game();
        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");
        aGame.roll(4);
        Assert.assertEquals(true, aGame.wrongAnswer());
        aGame.roll(1);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(6);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(3);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(4);
        Assert.assertEquals(true, aGame.wrongAnswer());
        aGame.roll(1);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(6);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(3);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(4);
        Assert.assertEquals(true, aGame.wrongAnswer());
        aGame.roll(1);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(6);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(3);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(4);
        Assert.assertEquals(true, aGame.wrongAnswer());
        aGame.roll(1);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(6);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(3);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(4);
        Assert.assertEquals(true, aGame.wrongAnswer());
        aGame.roll(1);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(6);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(3);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(5);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(5);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(5);
        Assert.assertEquals(true, aGame.wasCorrectlyAnswered());
        aGame.roll(5);
        Assert.assertEquals(false, aGame.wasCorrectlyAnswered());
        aGame.roll(5);
        Assert.assertEquals(true, aGame.wrongAnswer());
        Assert.assertEquals(false, aGame.wasCorrectlyAnswered());
    }

    @Test
    public void completeGameUntilSomePurseHitsSix_WithNoRandomInput_ShouldReturnTheExpectedValues() throws Exception {
        //setup outcontent to capture console logs from game methods
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Game aGame = new Game();
        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");
        aGame.roll(4);
        aGame.wrongAnswer();
        aGame.roll(1);
        aGame.wasCorrectlyAnswered();
        aGame.roll(6);
        aGame.wasCorrectlyAnswered();
        aGame.roll(3);
        aGame.wasCorrectlyAnswered();
        aGame.roll(4);
        aGame.wrongAnswer();
        aGame.roll(1);
        aGame.wasCorrectlyAnswered();
        aGame.roll(6);
        aGame.wasCorrectlyAnswered();
        aGame.roll(3);
        aGame.wasCorrectlyAnswered();
        aGame.roll(4);
        aGame.wrongAnswer();
        aGame.roll(1);
        aGame.wasCorrectlyAnswered();
        aGame.roll(6);
        aGame.wasCorrectlyAnswered();
        aGame.roll(3);
        aGame.wasCorrectlyAnswered();
        aGame.roll(4);
        aGame.wrongAnswer();
        aGame.roll(1);
        aGame.wasCorrectlyAnswered();
        aGame.roll(6);
        aGame.wasCorrectlyAnswered();
        aGame.roll(3);
        aGame.wasCorrectlyAnswered();
        aGame.roll(4);
        aGame.wrongAnswer();
        aGame.roll(1);
        aGame.wasCorrectlyAnswered();
        aGame.roll(6);
        aGame.wasCorrectlyAnswered();
        aGame.roll(3);
        aGame.wasCorrectlyAnswered();
        aGame.roll(5);
        aGame.wasCorrectlyAnswered();
        aGame.roll(5);
        aGame.wasCorrectlyAnswered();
        aGame.roll(5);
        aGame.wasCorrectlyAnswered();
        aGame.roll(5);
        aGame.wasCorrectlyAnswered();


        String result = "Chet was added\r\n" +
                "They are player number 1\r\n" +
                "Pat was added\r\n" +
                "They are player number 2\r\n" +
                "Sue was added\r\n" +
                "They are player number 3\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 4\r\n" +
                "Chet's new location is 4\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 0\r\n" +
                "Question was incorrectly answered\r\n" +
                "Chet was sent to the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat's new location is 1\r\n" +
                "The category is Science\r\n" +
                "Science Question 0\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 1 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 6\r\n" +
                "Sue's new location is 6\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 0\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 1 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 3\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 7\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 0\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 1 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 4\r\n" +
                "Pat's new location is 5\r\n" +
                "The category is Science\r\n" +
                "Science Question 1\r\n" +
                "Question was incorrectly answered\r\n" +
                "Pat was sent to the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue's new location is 7\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 2 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 6\r\n" +
                "Chet is not getting out of the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 3\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 2 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 4\r\n" +
                "Sue's new location is 11\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 2\r\n" +
                "Question was incorrectly answered\r\n" +
                "Sue was sent to the penalty box\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 2 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 6\r\n" +
                "Pat is not getting out of the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 3\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 2\r\n" +
                "The category is Sports\r\n" +
                "Sports Question 1\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 3 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 4\r\n" +
                "Chet is not getting out of the penalty box\r\n" +
                "Question was incorrectly answered\r\n" +
                "Chet was sent to the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 9\r\n" +
                "The category is Science\r\n" +
                "Science Question 2\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 3 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 6\r\n" +
                "Sue is not getting out of the penalty box\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 3\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 11\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 3\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 3 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 4\r\n" +
                "Pat is not getting out of the penalty box\r\n" +
                "Question was incorrectly answered\r\n" +
                "Pat was sent to the penalty box\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 1\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 3\r\n" +
                "The category is Rock\r\n" +
                "Rock Question 4\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 4 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 6\r\n" +
                "Chet is not getting out of the penalty box\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 3\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 0\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 3\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 4 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 5\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 8\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 4\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 5 Gold Coins.\r\n" +
                "Chet is the current player\r\n" +
                "They have rolled a 5\r\n" +
                "Chet is getting out of the penalty box\r\n" +
                "Chet's new location is 4\r\n" +
                "The category is Pop\r\n" +
                "Pop Question 5\r\n" +
                "Answer was correct!!!!\r\n" +
                "Chet now has 4 Gold Coins.\r\n" +
                "Pat is the current player\r\n" +
                "They have rolled a 5\r\n" +
                "Pat is getting out of the penalty box\r\n" +
                "Pat's new location is 5\r\n" +
                "The category is Science\r\n" +
                "Science Question 3\r\n" +
                "Answer was correct!!!!\r\n" +
                "Pat now has 5 Gold Coins.\r\n" +
                "Sue is the current player\r\n" +
                "They have rolled a 5\r\n" +
                "Sue is getting out of the penalty box\r\n" +
                "Sue's new location is 1\r\n" +
                "The category is Science\r\n" +
                "Science Question 4\r\n" +
                "Answer was correct!!!!\r\n" +
                "Sue now has 6 Gold Coins.\r\n";

        assertEquals(result, outContent.toString());
    }

}