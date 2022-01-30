package io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.levels;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.Action;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.enums.ActionNames;
import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.Level;
import io.github.bosifullstack.textAdventure.util.LevelActionsHandler;
import io.github.bosifullstack.textAdventure.util.io.Output;
import io.github.bosifullstack.textAdventure.util.io.UserInput;

/*Implementation of Level 3 */
public class Level3 extends Level {
    public Level3(){
        super();
        setLevelName("LEVEL 3");
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
        LevelActionsHandler.addAction(this.getActions(), ActionNames.FINISH_GAME.getActionName(),(new Action() {
            @Override
            public PlayerSpreadsheet execute(PlayerSpreadsheet playerSpreadsheet) {
                Output output = new Output(true);
                output.createTextNode("Dear ");
                output.createTextNode(playerSpreadsheet.getName()).setTextColorBlue();
                output.createTextNode(", thank you for experimenting with this Open Source Project.");
                output.createLineBreak();
                output.createTextNode("Feel free to contribute.");
                output.print();
                return null;
            }
        }));

    }
}