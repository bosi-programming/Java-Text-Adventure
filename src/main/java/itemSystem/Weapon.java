package itemSystem;

public class Weapon extends Item {
  private int damage;

  public Weapon(String name, int buyPrice, int sellPrice, int damage) {
    super(name, buyPrice, sellPrice);
    this.damage = damage;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }
}
