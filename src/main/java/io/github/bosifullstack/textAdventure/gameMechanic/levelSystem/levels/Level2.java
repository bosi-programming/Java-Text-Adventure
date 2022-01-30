package io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.levels;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.Action;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.enums.ActionNames;
import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.Level;
import io.github.bosifullstack.textAdventure.util.LevelActionsHandler;
import io.github.bosifullstack.textAdventure.util.io.UserInput;

/*Implementation of Level 2 */
public class Level2 extends Level {
    public Level2(){
        super();
        setLevelName("LEVEL 2");
        defineDefaultActions();
    }

    @Override
    public Level getCurrentLevel(){
        return this;
    }

    @Override
    public Level getRightLevel() {
        return super.getRightLevel();
    }

    @Override
    public void setRightLevel(Level level) {
        super.setRightLevel(level);
        LevelActionsHandler.addAction(this.getActions(), ActionNames.RIGHT.getActionName() ,(new Action() {
            @Override
            public PlayerSpreadsheet execute(PlayerSpreadsheet playerSpreadsheet) {
                getRightLevel().setPreviousLevel(getCurrentLevel());
                getRightLevel().startLevel(playerSpreadsheet);
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