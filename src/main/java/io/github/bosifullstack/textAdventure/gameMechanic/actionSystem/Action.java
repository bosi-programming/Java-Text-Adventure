package io.github.bosifullstack.textAdventure.gameMechanic.actionSystem;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;

/*Functional interface for implementing Actions in unanimous implementations inside specific Level*/
@FunctionalInterface
public interface Action {
    public PlayerSpreadsheet execute (PlayerSpreadsheet playerSpreadsheet);

}
