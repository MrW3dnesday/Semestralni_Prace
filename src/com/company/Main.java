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
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GamePlan gamePlan = new GamePlan(scanner);

        System.out.println("For testing: TEST, For normal gameplay just hit enter");
        System.out.print("Decision: ");

        String command = scanner.nextLine();
        command = command.toUpperCase(Locale.ROOT);

        if(command.equals("TEST")){
            gamePlan.TestInit();
        }else{
            gamePlan.Init();
        }

    }
}
