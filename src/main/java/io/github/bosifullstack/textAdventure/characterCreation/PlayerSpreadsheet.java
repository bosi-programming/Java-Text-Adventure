package textAdventure.characterCreation;

import java.util.ArrayList;

import textAdventure.itemSystem.Armor;
import textAdventure.itemSystem.ArmorType;
import textAdventure.itemSystem.Item;
import textAdventure.itemSystem.Weapon;
import textAdventure.magicSystem.Magic;
import textAdventure.magicSystem.MagicType;

public class PlayerSpreadsheet extends Character {
  private String race;
  private String className;

  private int numHealthPots;
  private Weapon weapon;
  private Armor armor;
  private Armor shield;

  private ArrayList<Magic> knowMagics = new ArrayList<Magic>();
  private ArrayList<Item> items = new ArrayList<Item>();

  public PlayerSpreadsheet() {
    super();
    this.race = "human";
    this.className = "warrior";
    this.numHealthPots = 3;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void setItems(ArrayList<Item> items) {
    this.items = items;
  }

  public PlayerSpreadsheet(String name, String race, String className, int strength, int dexterity, int constitution,
      int intelligence, int wisdom, int charisma, ArrayList<Magic> magics, ArrayList<Item> items,
      MagicType elementalWeakness) {
    super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, elementalWeakness);
    this.race = race;
    this.className = className;
    this.numHealthPots = 3;

    this.knowMagics = magics;
    this.items = items;
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public int getNumHealthPots() {
    return numHealthPots;
  }

  public void setNumHealthPots(int numHealthPots) {
    this.numHealthPots = numHealthPots;
  }

  public void setArmorOrShield(Armor armor) {
    if (armor.getType() == ArmorType.Armor) {
      this.armor = armor;
      this.setDefense(this.getDefense() + armor.getDefense());
    } else if (armor.getType() == ArmorType.Shield) {
      this.shield = armor;
      this.setDefense(this.getDefense() + shield.getDefense());
    } else {
      System.out.println("Error on setting a new armor");
    }
  }

  public int getArmorValue() {
    return armor.getDefense() + shield.getDefense();
  }

  public Armor getArmor() {
    return armor;
  }

  public Armor getShield() {
    return shield;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void setArmor(Armor armor) {
    this.armor = armor;
    this.setDefense(this.getDefense() + armor.getDefense());
  }

  public void setShield(Armor shield) {
    this.shield = shield;
    this.setDefense(this.getDefense() + shield.getDefense());
  }

  public ArrayList<Magic> getKnowMagics() {
    return knowMagics;
  }

  public void setKnowMagics(ArrayList<Magic> knowMagics) {
    this.knowMagics = knowMagics;
  }

  public void addKnowMagics(Magic magic) {
    this.knowMagics.add(magic);
  }

  public boolean knowCertainMagic(Magic magic) {
    return this.knowMagics.contains(magic);
  }
}
