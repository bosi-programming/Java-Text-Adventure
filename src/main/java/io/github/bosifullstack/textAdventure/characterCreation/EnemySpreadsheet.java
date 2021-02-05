package textAdventure.characterCreation;

import textAdventure.itemSystem.Item;
import textAdventure.magicSystem.CureMagic;
import textAdventure.magicSystem.MagicType;

public class EnemySpreadsheet extends Character {
  private int damage;
  private int chanceToDrop;
  private Item itemToDrop;

  public EnemySpreadsheet() {
    super();
    this.chanceToDrop = 25;
    this.itemToDrop = new Item("potion", 50, 10, new CureMagic(10));
    this.damage = 25 * 25 / 100;
  }

  public EnemySpreadsheet(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom,
      int charisma, int chanceToDrop, Item item, MagicType elementalWeakness) {
    super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, elementalWeakness);
    this.chanceToDrop = chanceToDrop;
    this.itemToDrop = item;
    this.damage = strength * 2 * chanceToDrop / 100;
  }

  public int getChanceToDrop() {
    return chanceToDrop;
  }

  public void setChanceToDrop(int chanceToDrop) {
    this.chanceToDrop = chanceToDrop;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public Item getItemToDrop() {
    return itemToDrop;
  }

  public void setItemToDrop(Item itemToDrop) {
    this.itemToDrop = itemToDrop;
  }
}
