package io.github.bosifullstack.textAdventure.gameMechanic.actionSystem;

/* Action identifier class
*
* implements comparable so that it can be ordered properly inside TreeMap
* */
public class ActionId implements Comparable<ActionId>{
    public int actionNo;
    public String actionName;

    public int getActionNo() {
        return actionNo;
    }

    public void setActionNo(int actionNo) {
        this.actionNo = actionNo;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public int compareTo(ActionId o) {
        return this.actionNo > o.actionNo ? 1 : this.actionNo < o.actionNo ? -1 : 0;

    }
}
