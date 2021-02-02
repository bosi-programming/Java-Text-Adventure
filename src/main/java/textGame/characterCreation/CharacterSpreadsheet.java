package textGame.characterCreation;

import java.util.ArrayList;

import textGame.itemSystem.Armor;
import textGame.itemSystem.ArmorType;
import textGame.itemSystem.Item;
import textGame.itemSystem.Weapon;
import textGame.magicSystem.Magic;
import textGame.magicSystem.MagicType;

public class CharacterSpreadsheet extends Character {
  private String race;
  private String className;

  private int numHealthPots;
  private Weapon weapon;
  private Armor armor;
  private Armor shield;

  private ArrayList<Magic> knowMagics;
  private ArrayList<Item> items;

  public CharacterSpreadsheet() {
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

  public CharacterSpreadsheet(String name, String race, String className, int strength, int dexterity, int constitution,
      int intelligence, int wisdom, int charisma, ArrayList<Magic> magics, ArrayList<Item> items, MagicType elementalWeakness) {
    super(name, strength, dexterity,constitution,intelligence, wisdom, charisma, elementalWeakness);
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
    } else if (armor.getType() == ArmorType.Shield) {
      this.shield = armor;
    } else {
      System.out.println("Error on setting a new armor");
    }
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
  }

  public void setShield(Armor shield) {
    this.shield = shield;
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
