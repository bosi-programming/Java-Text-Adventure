package io.github.bosifullstack.textAdventure.itemSystem;

import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

/**
 * Weapon type of item, used by main character. Can be common or magical
 */
public class Weapon extends Item {
  private int damage;

  /**
   * Creates common weapon
   * 
   * @param name      String - Name of the weapon
   * @param buyPrice  int - Price to buy the item
   * @param sellPrice int - Price to sell the item
   * @param damage    int - Damage of the weapon
   */
  public Weapon(String name, int buyPrice, int sellPrice, int damage) {
    super(name, buyPrice, sellPrice);
    this.damage = damage;
  }

  /**
   * Creates magical weapon
   * 
   * @param name      String - Name of the weapon
   * @param buyPrice  int - Price to buy the item
   * @param sellPrice int - Price to sell the item
   * @param magic     {@link Magic} - Magic attached to the weapon
   * @param damage    int - Damage of the weapon
   */
  public Weapon(String name, int buyPrice, int sellPrice, Magic magic, int damage) {
    super(name, buyPrice, sellPrice, magic);
    this.damage = damage;
  }

  /** @return int - Non-magical damage of the weapon */
  public int getDamage() {
    return damage;
  }

  /** @param damage int - Non-magical damage of the weapon */
  public void setDamage(int damage) {
    this.damage = damage;
  }

  /** @return {@link MagicType} - Magical type of the weapon */
  public MagicType getElementalType() {
    if (this.getMagic() != null) {
      return this.getMagic().getType();
    }
    return null;
  }

  /** @return int - Magical damage of the weapon */
  public int getElementalDamage() {
    if (this.getMagic() != null & this.getMagic().getType() != MagicType.Cure) {
      return this.getMagic().getEffect();
    }
    return 0;
  }

  /**
   * @return int - Life steal of the weapon, if the weapon has a cure magic
   *         attached to it
   */
  public int getLifeSteal() {
    if (this.getMagic() != null & this.getMagic().getType() == MagicType.Cure) {
      return this.getMagic().getEffect();
    }
    return 0;
  }
}
