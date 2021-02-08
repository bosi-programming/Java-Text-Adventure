package io.github.bosifullstack.textAdventure.characterCreation;

import io.github.bosifullstack.textAdventure.itemSystem.Item;
import io.github.bosifullstack.textAdventure.magicSystem.CureMagic;
import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

/** Creates a enemy spreadsheet to be used on the game */

public class EnemySpreadsheet extends Character {
  private int damage;
  private int chanceToDrop;
  private Item itemToDrop;

  /** Creates a simple basic default enemy */
  public EnemySpreadsheet() {
    super();
    this.chanceToDrop = 25;
    this.itemToDrop = new Item("potion", 50, 10, new CureMagic(10));
    this.damage = 25 * 25 / 100;
  }

  /**
   * Creates an enemy
   * 
   * @param name              String - Name of the enemy
   * @param strength          int - {@link Character} strength
   * @param dexterity         int - {@link Character} dexterity
   * @param constitution      int - {@link Character} constitution
   * @param intelligence      int - {@link Character} intelligence
   * @param wisdom            int - {@link Character} wisdom
   * @param charisma          int - {@link Character} charisma
   * @param chanceToDrop      int - Chance to drop an item(use int between 0 and
   *                          100)
   * @param item              {@link Item} - Item that can be dropped by the enemy
   * @param elementalWeakness {@link MagicType} - {@link Character} elemental
   */
  public EnemySpreadsheet(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom,
      int charisma, int chanceToDrop, Item item, MagicType elementalWeakness) {
    super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, elementalWeakness);
    this.chanceToDrop = chanceToDrop;
    this.itemToDrop = item;
    this.damage = strength * 2 * chanceToDrop / 100;
  }

  /** @return int - Chance to drop an {@link Item} - number between 0 and 100 */
  public int getChanceToDrop() {
    return chanceToDrop;
  }

  /**
   * @param chanceToDrop int - Chance to drop an {@link Item} - use number between
   *                     0 and 100
   */
  public void setChanceToDrop(int chanceToDrop) {
    this.chanceToDrop = chanceToDrop;
  }

  /** @return int - Enemy damage */
  public int getDamage() {
    return damage;
  }

  /** @param damage int - New enemy damage */
  public void setDamage(int damage) {
    this.damage = damage;
  }

  /** @return {@link Item} - Dropped {@link Item} */
  public Item getItemToDrop() {
    return itemToDrop;
  }

  /** @param itemToDrop {@link Item} - Item that can be dropped ny the enemy */
  public void setItemToDrop(Item itemToDrop) {
    this.itemToDrop = itemToDrop;
  }
}
