package io.github.bosifullstack.textAdventure.itemSystem;

import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

public class Weapon extends Item {
  private int damage;

  public Weapon(String name, int buyPrice, int sellPrice, int damage) {
    super(name, buyPrice, sellPrice);
    this.damage = damage;
  }

  public Weapon(String name, int buyPrice, int sellPrice, Magic magic, int damage) {
    super(name, buyPrice, sellPrice, magic);
    this.damage = damage;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public MagicType getElementalType() {
    if (this.getMagic() != null) {
      return this.getMagic().getType();
    }
    return null;
  }

  public int getElementalDamage() {
    if (this.getMagic() != null & this.getMagic().getType() != MagicType.Cure) {
      return this.getMagic().getEffect();
    }
    return 0;
  }

  public int getLifeSteal() {
    if (this.getMagic() != null & this.getMagic().getType() == MagicType.Cure) {
      return this.getMagic().getEffect();
    }
    return 0;
  }
}
