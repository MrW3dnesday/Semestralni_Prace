package com.company;

import interfaces.ICommand;

public class CommandMove implements ICommand {
    @Override
    public void Execute(Object interact) {
        BasicRoom basicRoom = (BasicRoom) interact;

    }
}
