package itemSystem;

enum armorType {
  Shield, Armor
}

public class Armor extends Item {
  private int defense;
  private armorType type;

  public Armor(String name, int buyPrice, int sellPrice, int defense, armorType type) {
    super(name, buyPrice, sellPrice);
    this.defense = defense;
    this.type = type;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public armorType getType() {
    return type;
  }

  public void setType(armorType type) {
    this.type = type;
  }
}
