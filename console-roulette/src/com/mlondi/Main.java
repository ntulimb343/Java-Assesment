package com.mlondi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private List<String> players = new ArrayList<>();
    private List<Bets> bets = new ArrayList<>();
    List<Outcomes> outcomes = new ArrayList<>();
    private boolean multiple_bets;
    private int winningNumber = 0;

    public void readFile(){
        try {
            File myObj = new File("src/com/mlondi/players.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("--------------PLAYERS--------------");
            while (myReader.hasNextLine()) {
                String player = myReader.nextLine();
                players.add(player);
                System.out.println(player);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void placeBets(List<String> players){
        Scanner scanner = new Scanner(System.in);
        String bet = null;
        System.out.println("\n--------------TAKING BETS--------------");
        for(String player : players) {
            multiple_bets = Boolean.TRUE;
            while (multiple_bets) {
                System.out.println("\n" + player + " Place Your Be(option 1 or 2 or 3)\n1. EVEN \n2. ODD \n3. NUMBER(1-36)");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("1")) {
                    bet = "EVEN";
                } else if(choice.equalsIgnoreCase("2")){
                    bet = "ODD";
                }
                else  {
                    System.out.println("Enter a Number between 1 and 36");
                    bet = scanner.next();
                    while (Integer.parseInt(bet) < 1 || Integer.parseInt(bet) > 36) {
                        System.out.println("Incorrect Input,please enter number between 1 and 36");
                        bet = scanner.next();
                    }
                }
                System.out.println(player + " Enter Bet Amount");
                double amount = scanner.nextDouble();
                bets.add(new Bets(player, bet, amount));

                System.out.println("You want to place another bet?\n 1. Yes \n 2. No");
                String option = scanner.next();
                while (Integer.parseInt(option)!=1 && Integer.parseInt(option)!=2){
                    System.out.println("Incorrect Input select 1 or 2");
                    System.out.println("You want to place another bet?\n 1. Yes \n 2. No");
                    option =scanner.next();
                }
                multiple_bets = option.equalsIgnoreCase("1")? Boolean.TRUE : Boolean.FALSE;
            }
        }
        System.out.println(bets.toString());
        System.out.println("--------------BETS CLOSED--------------");
    }

    public void spinTheWheel(List<Bets> bets){
        System.out.println("\n--------------SPINNING THE WHEEL--------------");
        Random random = new Random();
        winningNumber= random.nextInt((36-1)+1)+1;
        for(Bets bet : bets){
            double winningAmount = 0.0;
            if(bet.getBet().equalsIgnoreCase("EVEN")) {
                //EVEN NUMBER
                if (winningNumber % 2 == 0) {
                    winningAmount += bet.getAmount() * 2;
                    outcomes.add(new Outcomes(bet.getPlayerName(), bet.getBet(), "WIN", winningAmount));
                } else {
                    outcomes.add(new Outcomes(bet.getPlayerName(), bet.getBet(), "LOSE", winningAmount));
                }
            }
            else if(bet.getBet().equalsIgnoreCase("ODD")) {
                //ODD NUMBER
                    if (winningNumber % 2 != 0){
                        winningAmount += bet.getAmount() * 2;
                        outcomes.add(new Outcomes(bet.getPlayerName(), bet.getBet(), "WIN", winningAmount));
                    }else{
                        outcomes.add(new Outcomes(bet.getPlayerName(), bet.getBet(), "LOSE", winningAmount));
                    }
                }else {
                //EXACT MATCH
                if(winningNumber == Integer.parseInt(bet.getBet())){
                    winningAmount+=bet.getAmount()*36;
                    outcomes.add(new Outcomes(bet.getPlayerName(),bet.getBet(),"WIN",winningAmount));
                }else{
                    outcomes.add(new Outcomes(bet.getPlayerName(),bet.getBet(),"LOSE",winningAmount));
                }
            }
        }
        System.out.println("\n------------------------PLEASE WAIT COMPILING RESULTS------------------------");
        try {
            Thread thread = new Thread();
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        System.out.println("--------------STARTING THE ROUND--------------");
        Main main = new Main();
        main.readFile();
        main.placeBets(main.players);
        main.spinTheWheel(main.bets);
        System.out.println("WINNING NUMBER: "+ main.winningNumber);
        System.out.println("Player\t\t\t\tBet\t\t\t\tOutcome\t\t\tWinnings\n" +
                "---------------------------------------------------------------");
        for (Outcomes outcomes : main.outcomes){
            System.out.println(outcomes.toString());
        }
        System.out.println("--------------END OF ROUND--------------");
    }
}
