package textGame.characterCreation;

import textGame.itemSystem.Item;
import textGame.magicSystem.CureMagic;
import textGame.magicSystem.MagicType;

public class EnemySpreadsheet extends Character {
  private int chanceToDrop;
  private Item itemToDrop;

  public EnemySpreadsheet() {
    super();
    this.chanceToDrop = 25;
    this.itemToDrop = new Item("potion", 50, 10, new CureMagic(10));
  }

  public EnemySpreadsheet(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom,
      int charisma, int chanceToDrop, Item item, MagicType elementalWeakness) {
    super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, elementalWeakness);
    this.chanceToDrop = chanceToDrop;
    this.itemToDrop = item;
  }

  public int getChanceToDrop() {
    return chanceToDrop;
  }

  public void setChanceToDrop(int chanceToDrop) {
    this.chanceToDrop = chanceToDrop;
  }

  public Item getItem() {
    return itemToDrop;
  }

  public void setItem(Item itemToDrop) {
    this.itemToDrop = itemToDrop;
  }
}
