package textGame.itemSystem;

import textGame.magicSystem.Magic;
import textGame.magicSystem.MagicType;

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
    if(this.getMagic() != null) {
      return this.getMagic().getType();
    }
    return null;
  }

  public int getElementalDamage() {
    if(this.getMagic() != null) {
      return this.getMagic().getDamage();
    }
    return 0;
  }

  public int getLifeSteal() {
    if(this.getMagic() != null) {
      return this.getMagic().getCure();
    }
    return 0;
  }
}
