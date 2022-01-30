package io.github.bosifullstack.textAdventure.util;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.Action;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.ActionId;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.enums.ActionNames;

import java.util.Map;


/* LevelActionsHandler contains methods for handling actions initiated by user */
public class LevelActionsHandler {

    public static void addAction (Map<ActionId, Action> actions, String actionName, Action action){
        removeBackActions(actions);
        ActionId actionId = new ActionId();
        actionId.actionNo = actions.size()+1;
        actionId.actionName = actionName;
        actions.put(actionId,action);
    }

    public static void executeAction (Map<ActionId, Action> actions, int actionNo, PlayerSpreadsheet playerSpreadsheet){
        Action actionToExecute = null;

        for (Map.Entry<ActionId, Action> entry : actions.entrySet()) {
            if(entry.getKey().actionNo == actionNo){
                actionToExecute = entry.getValue();
            }
        }
        if(actionToExecute != null){
            actionToExecute.execute(playerSpreadsheet);
        }

    }

    private static void removeBackActions(Map<ActionId, Action> actions){
        actions.entrySet().removeIf(entry -> entry.getKey().getActionName().equals(ActionNames.BACK.getActionName()));

    }

}
