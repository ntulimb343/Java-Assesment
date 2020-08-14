package com.mlondi;

public class Bets {
    private String playerName;
    private String bet;
    private Double amount;

    public Bets(String playerName, String bet, Double amount) {
        this.playerName = playerName;
        this.bet = bet;
        this.amount = amount;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "" + playerName + " " + bet + " " + amount+"\n";
    }
}
