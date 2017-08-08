package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<String> players = new ArrayList<>();
    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];
    private LinkedList<String> popQuestions = new LinkedList<>();
    private LinkedList<String> scienceQuestions = new LinkedList<>();
    private LinkedList<String> sportsQuestions = new LinkedList<>();
    private LinkedList<String> rockQuestions = new LinkedList<>();
    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;
    private Console console;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(createPopQuestion(i));
            scienceQuestions.addLast(createScienceQuestion(i));
            sportsQuestions.addLast(createSportQuestion(i));
            rockQuestions.addLast(createRockQuestion(i));
        }
        console = new Console();
    }

    private String createPopQuestion(int index) {
        return "Pop Question " + index;
    }

    private String createScienceQuestion(int index) {
        return "Science Question " + index;
    }

    private String createSportQuestion(int index) {
        return "Sports Question " + index;
    }

    private String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;
        console.printAddingPlayer(playerName, players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        String currentPlayerName = players.get(currentPlayer);
        isGettingOutOfPenaltyBox = isRollUneven(roll);
        console.printPlayerAndRoll(roll, currentPlayerName);
        if (isPlayerInPenaltybox()) {
            if (isGettingOutOfPenaltyBox) {
                console.printGetsOutOfPenaltyBox(currentPlayerName);
                places[currentPlayer] = places[currentPlayer] + roll;
                if (places[currentPlayer] > 11) {
                    places[currentPlayer] = places[currentPlayer] - 12;
                }
                console.printPlayersLocationAndCategory(currentPlayerName, places[currentPlayer], currentCategory());
                askQuestion();
            } else {
                console.printStaysInPenaltyBox(currentPlayerName);
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            places[currentPlayer] = places[currentPlayer] + roll;
            if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
            console.printPlayersLocationAndCategory(currentPlayerName, places[currentPlayer], currentCategory());
            askQuestion();
        }
    }

    private boolean isRollUneven(int roll) {
        return roll % 2 != 0;
    }

    private boolean isPlayerInPenaltybox() {
        return inPenaltyBox[currentPlayer];
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }


    private String currentCategory() {
        if (places[currentPlayer] == 0 || places[currentPlayer] == 4 || places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1 || places[currentPlayer] == 5 || places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2 || places[currentPlayer] == 6 || places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (isPlayerInPenaltybox()) {
            if (isGettingOutOfPenaltyBox) {
                return answerCorrect();
            } else {
                incrementCurrentPlayer();
                return true;
            }
        } else {
            return answerCorrect();
        }
    }

    private boolean answerCorrect() {
        incrementGoldCoins();
        console.printCorrectAnswerAndGoldCoins(players.get(currentPlayer), purses[currentPlayer]);
        boolean winner = shouldGameContinue();
        incrementCurrentPlayer();
        return winner;
    }

    private void incrementGoldCoins() {
        purses[currentPlayer]++;
    }

    public boolean wrongAnswer() {
        console.printWrongAnswerAndSentToPenaltyBox(players.get(currentPlayer));
        inPenaltyBox[currentPlayer] = true;
        incrementCurrentPlayer();
        return true;
    }

    private void incrementCurrentPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

    }

    private boolean shouldGameContinue() {
        return (purses[currentPlayer] != 6);
    }

}
