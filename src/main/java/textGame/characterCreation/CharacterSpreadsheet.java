package textGame.characterCreation;

import textGame.itemSystem.Armor;
import textGame.itemSystem.ArmorType;
import textGame.itemSystem.Weapon;

public class CharacterSpreadsheet {
  private String name;
  private String race;
  private String className;
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  private int numHealthPots;
  private Weapon weapon;
  private Armor armor;
  private Armor shield;

  public CharacterSpreadsheet() {
    this.name = "Jorisvaldo";
    this.race = "human";
    this.className = "warrior";
    this.strength = 10;
    this.dexterity = 10;
    this.constitution = 10;
    this.intelligence = 10;
    this.wisdom = 10;
    this.charisma = 10;
    this.numHealthPots = 3;
  }

  public CharacterSpreadsheet(String name, String race, String className, int strength, int dexterity, int constitution,
      int intelligence, int wisdom, int charisma) {
    this.name = name;
    this.race = race;
    this.className = className;
    this.strength = strength;
    this.dexterity = dexterity;
    this.constitution = constitution;
    this.intelligence = intelligence;
    this.wisdom = wisdom;
    this.charisma = charisma;
    this.numHealthPots = 3;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + charisma;
    result = prime * result + ((className == null) ? 0 : className.hashCode());
    result = prime * result + constitution;
    result = prime * result + dexterity;
    result = prime * result + intelligence;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((race == null) ? 0 : race.hashCode());
    result = prime * result + strength;
    result = prime * result + wisdom;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CharacterSpreadsheet other = (CharacterSpreadsheet) obj;
    if (charisma != other.charisma)
      return false;
    if (className == null) {
      if (other.className != null)
        return false;
    } else if (!className.equals(other.className))
      return false;
    if (constitution != other.constitution)
      return false;
    if (dexterity != other.dexterity)
      return false;
    if (intelligence != other.intelligence)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (race == null) {
      if (other.race != null)
        return false;
    } else if (!race.equals(other.race))
      return false;
    if (strength != other.strength)
      return false;
    if (wisdom != other.wisdom)
      return false;
    return true;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  public int getConstitution() {
    return constitution;
  }

  public void setConstitution(int constitution) {
    this.constitution = constitution;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  public int getWisdom() {
    return wisdom;
  }

  public void setWisdom(int wisdom) {
    this.wisdom = wisdom;
  }

  public int getCharisma() {
    return charisma;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
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
}
