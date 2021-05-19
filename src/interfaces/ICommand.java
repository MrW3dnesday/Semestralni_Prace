package interfaces;

import com.company.Player;

import java.util.Scanner;

/*
 *  Interface ICommand - TODO
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public interface ICommand {

    /*
     *  Metoda Execute - TODO
     *
     * @author Dan Šebek
     */
    public void Execute();
    public String GetCommandName();
    public String GetCommandDescription();
}
