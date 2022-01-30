package io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.levels;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.Action;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.enums.ActionNames;
import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.Level;
import io.github.bosifullstack.textAdventure.util.LevelActionsHandler;
import io.github.bosifullstack.textAdventure.util.io.UserInput;

/*Implementation of Level 1 */
public class Level1 extends Level {
    public Level1(){
        super();
        setLevelName("LEVEL 1");
        defineDefaultActions();
    }

    @Override
    public Level getCurrentLevel(){
        return this;
    }

    @Override
    public Level getLeftLevel() {
        return super.getLeftLevel();
    }

    @Override
    public void setLeftLevel(Level level) {
        super.setLeftLevel(level);
        LevelActionsHandler.addAction(this.getActions(), ActionNames.LEFT.getActionName(),(new Action() {
            @Override
            public PlayerSpreadsheet execute(PlayerSpreadsheet playerSpreadsheet) {
                getLeftLevel().setPreviousLevel(getCurrentLevel());
                getLeftLevel().startLevel(playerSpreadsheet);
                return playerSpreadsheet;
            }
        }));
    }

    @Override
    public Level getForwardLevel() {
        return super.getForwardLevel();
    }

    @Override
    public void setForwardLevel(Level level) {
        super.setForwardLevel(level);
        LevelActionsHandler.addAction(this.getActions(), ActionNames.FORWARD.getActionName(),(new Action() {
            @Override
            public PlayerSpreadsheet execute(PlayerSpreadsheet playerSpreadsheet) {
                getForwardLevel().setPreviousLevel(getCurrentLevel());
                getForwardLevel().startLevel(playerSpreadsheet);
                return playerSpreadsheet;
            }
        }));
    }

    @Override
    public void startLevel(PlayerSpreadsheet playerSpreadsheet) {
        this.setPlayerSpreadsheet(playerSpreadsheet);
        this.printLevelDescription();
        this.printAvailableActions();
        this.setVisited(true);
        UserInput userInput = new UserInput();
        int userChoice = userInput.handleUserInput(this.getActions());
        LevelActionsHandler.executeAction(this.getActions(), userChoice, playerSpreadsheet);
    }

    @Override
    public void defineDefaultActions(){
        //TO-DO Actions like Attack, Inventory interaction etc can be added here

    }


}
