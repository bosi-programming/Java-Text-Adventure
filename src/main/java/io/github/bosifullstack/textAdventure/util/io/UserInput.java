package io.github.bosifullstack.textAdventure.util.io;

import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.Action;
import io.github.bosifullstack.textAdventure.gameMechanic.actionSystem.ActionId;
import java.util.Map;
import java.util.Scanner;

/* UserInput serves for validation of user input
* Check will be made if entered arguments are numbers and there is an action matching entered number
*
* */
public class UserInput {

    public int handleUserInput(Map<ActionId, Action> actions) {
        Scanner sc = ScannerHelper.getInstance().getScanner();

        int actionNo;
        do {
            Output output = new Output();
            output.createTextNode("Please enter valid choice");
            output.createLineBreak();
            output.print();
            while (!sc.hasNextInt()) {
                output.createTextNode("Please enter valid number");
                output.createLineBreak();
                output.print();
                sc.next();
            }
            actionNo = sc.nextInt();

        } while (!actionExists(actions, actionNo));

        return actionNo;
    }

    private boolean actionExists(Map<ActionId, Action> actions, int actionNo) {
        boolean exists = false;
        for (Map.Entry<ActionId, Action> entry : actions.entrySet()) {
            if (entry.getKey().actionNo == actionNo) {
                exists = true;
                break;
            }
        }
        return exists;
    }


}
