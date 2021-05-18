package interfaces;

/*
 *  Interface ICommand - TODO
 *
 *
 *
 *  @author     Dan Šebek
 *  @version    0.01a
 *  @created    květen 2021
 */
public interface IMovement {
    public String OnMove(IRoom nextRoom);
    public IRoom GetCurrentRoom();
}
