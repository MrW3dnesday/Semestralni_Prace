package com.company;

import java.util.Locale;
import java.util.Scanner;

/*
 *  Třída Main - Zajišťuje spuštení a inicializaci hry.
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Main {
    /**
     * Metoda se spouští při nastartování aplikace. Zajistí nastartování hry
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GamePlan gamePlan = new GamePlan(scanner);

        System.out.println("Vítej do mojí malý hry.\nDoufám, že si ji užiješ!\nPro pokračování stiskni enter...");

        String command = UserInput.ReadUserInput();
        command = command.toUpperCase(Locale.ROOT);

        if(command.equals("TEST")){
            gamePlan.TestInit();
        }else{
            gamePlan.Init();
        }
    }
}
