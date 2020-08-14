package com.mlondi;

public class Outcomes {
    private String playerName;
    private String bet;
    private String outcome;
    private double winnings;

    public Outcomes(String playerName, String bet, String outcome, double winnings) {
        this.playerName = playerName;
        this.bet = bet;
        this.outcome = outcome;
        this.winnings = winnings;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }
}
