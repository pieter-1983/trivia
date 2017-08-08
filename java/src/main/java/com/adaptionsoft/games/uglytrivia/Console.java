package com.adaptionsoft.games.uglytrivia;


class Console {

    void printAddingPlayer(String playerName, int playerOrder) {
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + playerOrder);
    }

    void printStaysInPenaltyBox(String playerName) {
        System.out.println(playerName + " is not getting out of the penalty box");
    }

    void printGetsOutOfPenaltyBox(String playerName) {
        System.out.println(playerName + " is getting out of the penalty box");
    }

    void printPlayerAndRoll(int roll, String playerName) {
        System.out.println(playerName + " is the current player");
        System.out.println("They have rolled a " + roll);
    }

    void printPlayersLocationAndCategory(String playerName, int place, String category) {
        System.out.println(playerName
                + "'s new location is "
                + place);
        System.out.println("The category is " + category);
    }

    void printCorrectAnswerAndGoldCoins(String currentPlayer, int purse) {
        System.out.println("Answer was correct!!!!");
        System.out.println(currentPlayer
                + " now has "
                + purse
                + " Gold Coins.");
    }

    void printWrongAnswerAndSentToPenaltyBox(String playerName) {
        System.out.println("Question was incorrectly answered");
        System.out.println(playerName + " was sent to the penalty box");
    }
}
