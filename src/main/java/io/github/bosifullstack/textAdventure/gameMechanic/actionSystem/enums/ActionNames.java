package io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.enums;

public enum ActionNames {
    //General codes
    BACK("Go Back"),
    LEFT("Go Left"),
    RIGHT("Go Right"),
    FORWARD("Go Forward"),
    FINISH_GAME("Complete Java Text Adventure");


    //TO-DO if needed more action names can be added

    private final String actionName;

    private ActionNames(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

}
