package io.github.bosifullstack.textAdventure.gameMechanic.levelSystem;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.Action;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.ActionId;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.enums.ActionNames;
import io.github.bosifullstack.textAdventure.util.LevelActionsHandler;
import io.github.bosifullstack.textAdventure.util.io.Output;
import java.util.Map;
import java.util.TreeMap;

/*Abstract class needed for abstraction of Level logic
*
* In order to simplify level structure, Level is considered to be an object from which user can move in four directions (forward, left, right and back) - inspiration is taken from boardgames
* Any specific level can have up to four 'adjacent' levels.
* Depending on which 'adjacent' levels have been set to specific Level system will automatically generate actions to access those levels.
*
* System works by passing PlayerSpreadsheet object to certain Level invoking a method: startLevel(PlayerSpreadsheet playerSpreadsheet)
*
* In addition, by defining default actions, specific actions can be added to specific level
* */
public abstract class Level {
    private PlayerSpreadsheet playerSpreadsheet;
    private String levelName;
    private boolean visited;
    private Level previousLevel;
    private Level leftLevel;
    private Level rightLevel;
    private Level forwardLevel;
    private Map<ActionId, Action> actions = new TreeMap<>();


    public abstract void startLevel(PlayerSpreadsheet playerSpreadsheet);
    public abstract void defineDefaultActions();
    public abstract Level getCurrentLevel();

    /* Method for generic print of current Level description */
    public void printLevelDescription(){
        Output output = new Output(true);
        output.createLineBreak();
        output.createTextNode(playerSpreadsheet.getName()).setTextColorBlue().setBold();
        output.createTextNode( isVisited() ? ", welcome back to " : ", welcome to ");
        output.createTextNode(levelName).setTextColorYellow().setBold();
        output.print();
    }

    /* Method which will print available actions */
    public void printAvailableActions(){
        Output output = new Output(true);
        output.createTextNode("You have following options:");
        output.createLineBreak();
        for (Map.Entry<ActionId, Action> entry : actions.entrySet()) {
            output.createTextNode(entry.getKey().actionNo + ". " + entry.getKey().actionName);
            output.createLineBreak();
        }

        output.print();
    }

    public PlayerSpreadsheet getPlayerSpreadsheet() {
        return playerSpreadsheet;
    }

    public void setPlayerSpreadsheet(PlayerSpreadsheet playerSpreadsheet) {
        this.playerSpreadsheet = playerSpreadsheet;
    }

    public Map<ActionId, Action> getActions() {
        return actions;
    }

    public void setActions(Map<ActionId, Action> actions) {
        this.actions = actions;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Level getPreviousLevel() {
        return previousLevel;
    }

    public void setPreviousLevel(Level level) {
        this.previousLevel = level;
        LevelActionsHandler.addAction(this.getActions(), ActionNames.BACK.getActionName(),(new Action() {
            @Override
            public PlayerSpreadsheet execute(PlayerSpreadsheet playerSpreadsheet) {
                getPreviousLevel().setPreviousLevel(getCurrentLevel());
                getPreviousLevel().startLevel(playerSpreadsheet);
                return playerSpreadsheet;
            }
        }));

    }

    public Level getLeftLevel() {
        return leftLevel;
    }

    public void setLeftLevel(Level leftLevel) {
        this.leftLevel = leftLevel;
    }

    public Level getRightLevel() {
        return rightLevel;
    }

    public void setRightLevel(Level rightLevel) {
        this.rightLevel = rightLevel;
    }

    public Level getForwardLevel() {
        return forwardLevel;
    }

    public void setForwardLevel(Level forwardLevel) {
        this.forwardLevel = forwardLevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
