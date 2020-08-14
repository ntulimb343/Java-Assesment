package com.mlondi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<String> players = new ArrayList<>();
    private List<Bets> bets = new ArrayList<>();
    private boolean multiple_bets = Boolean.TRUE;

    public void readFile(){
        try {
            File myObj = new File("src/com/mlondi/players.txt");
            Scanner myReader = new Scanner(myObj);
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
        for(String player : players) {
            while (multiple_bets) {
                System.out.println("\n" + player + " Place Your Be(option 1 or 2)\n 1. EVEN \n 2. NUMBER(1-36)");
                if (scanner.next().equals("1")) {
                    bet = "EVEN";
                } else {
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
                System.out.println("option"+Integer.parseInt(option));
                while (Integer.parseInt(option)!=1 && Integer.parseInt(option)!=2){
                    System.out.println("Incorrect Input select 1 or 2");
                    System.out.println("You want to place another bet?\n 1. Yes \n 2. No");
                    option =scanner.next();
                }
                multiple_bets = option.equalsIgnoreCase("1")? Boolean.TRUE : Boolean.FALSE;
            }
        }
        System.out.println(bets.toString());
    }



    public static void main(String[] args) {
        Main main = new Main();
        main.readFile();
        main.placeBets(main.players);
    }
}
