package textAdventure.itemSystem;

public class Armor extends Item {
  private int defense;
  private ArmorType type;

  public Armor(String name, int buyPrice, int sellPrice, int defense, ArmorType type) {
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

  public ArmorType getType() {
    return type;
  }
}
