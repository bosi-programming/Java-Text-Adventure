package textGame.characterCreation;

import textGame.magicSystem.MagicType;

public class Character {
  private String name;
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  private int health;
  private int maxHealth;
  private int mp;
  private int maxMp;

  private MagicType elementalWeakness;

  public Character() {
    this.name = "Jorisvaldo";
    this.strength = 10;
    this.dexterity = 10;
    this.constitution = 10;
    this.intelligence = 10;
    this.wisdom = 10;
    this.charisma = 10;

    this.health = 100;
    this.maxHealth = 100;
    this.mp = 20;
    this.maxMp = 20;

    this.setElementalWeakness(MagicType.Fire);
  }

  Character(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
      MagicType elementalWeakness) {
    this.name = name;
    this.strength = strength;
    this.dexterity = dexterity;
    this.constitution = constitution;
    this.intelligence = intelligence;
    this.wisdom = wisdom;
    this.charisma = charisma;

    this.health = constitution * 10;
    this.maxHealth = constitution * 10;
    this.mp = intelligence * 5;
    this.maxMp = intelligence * 5;

    this.setElementalWeakness(elementalWeakness);
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int value) {
    if (value <= this.maxHealth) {
      this.health = value;
    } else {
      this.health = this.maxHealth;
    }
  }

  public MagicType getElementalWeakness() {
    return elementalWeakness;
  }

  public void setElementalWeakness(MagicType elementalWeakness) {
    this.elementalWeakness = elementalWeakness;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public int getMaxHealth() {
    return maxHealth;
  }

  public void setMaxHealth(int maxHealth) {
    this.maxHealth = maxHealth;
  }

  public int getMp() {
    return mp;
  }

  public void setMp(int mp) {
    this.mp = mp;
  }

  public int getMaxMp() {
    return maxMp;
  }

  public void setMaxMp(int maxMp) {
    this.maxMp = maxMp;
  }
}
