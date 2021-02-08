package io.github.bosifullstack.textAdventure.itemSystem;

/** Armor item used by main character to reduce damage taken */
public class Armor extends Item {
  private int defense;
  private ArmorType type;

  /** Creates an armor
   * @param name      String - Name of the item
   * @param buyPrice  int - Price to buy the item
   * @param sellPrice int - Price to sell the item
   * @param defense int - How much of the damage it reduce
   * @param type {@link ArmorType} - Type of the armor*/
  public Armor(String name, int buyPrice, int sellPrice, int defense, ArmorType type) {
    super(name, buyPrice, sellPrice);
    this.defense = defense;
    this.type = type;
  }

  /** @return int - How much of the damage it reduces */
  public int getDefense() {
    return defense;
  }

   /** @param defense int - How much of the damage it reduce */
  public void setDefense(int defense) {
    this.defense = defense;
  }

  /** @return {@link ArmorType} - type of the armor */
  public ArmorType getType() {
    return type;
  }
}
