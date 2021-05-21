package base.classes;


/*
 *  Třída Command - Nadřazená třída všem příkazům.
 *  Obsahuje provedení příkazu a zjištění informací o příkazu
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public class Command{

    String commandName;
    String commandDescription;

    protected Command(){

    }

    protected Command(String commandName, String commandDescription){
        this.commandName = commandName;
        this.commandDescription = commandDescription;
    }

    /**
     * Metoda provede příkaz
     */
    public void Execute(){
        System.out.println("BASE CLASS");
    }

    /**
     * Metoda vrátí název příkazu
     *
     *@return Vrací název příkazu
     */
    public String GetCommandName(){
        return  commandName;
    }

    /**
     * Metoda vrátí popis příkazu
     *
     *@return Vrací popis příkazu
     */
    public String GetCommandDescription(){return commandDescription;}
}
