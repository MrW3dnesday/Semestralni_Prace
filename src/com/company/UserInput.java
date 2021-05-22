package com.company;

import java.util.Scanner;

/*
 *  Třída UserInput - Slouží k vytvoření scanneru pro načítání z konzole
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class UserInput {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Metoda přectě text zadaný hráčem do konzole
     *
     * @return Vrací přectěný text
     */
    public static String ReadUserInput(){
        return scanner.nextLine();
    }

}
