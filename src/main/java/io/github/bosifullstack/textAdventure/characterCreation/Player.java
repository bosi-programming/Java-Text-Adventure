package io.github.bosifullstack.textAdventure.characterCreation;

import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

/** Class that all type of characters inherit from */
public class Player {
  private String name;
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  private int defense;
  private int health;
  private int maxHealth;
  private int mp;
  private int maxMp;

  private MagicType elementalWeakness;

  /** Creates a basic default character */

  /** NOTE
  naming objects same as Java default ones is not a good practice
   changing old class name 'Character' to 'Player'
   */

  public Player() {
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

  /**
   * Creates a character
   * 
   * @param name              String - Name of the character
   * @param strength          int - {@link Character} strength
   * @param dexterity         int - {@link Character} dexterity
   * @param constitution      int - {@link Character} constitution
   * @param intelligence      int - {@link Character} intelligence
   * @param wisdom            int - {@link Character} wisdom
   * @param charisma          int - {@link Character} charisma
   * @param elementalWeakness {@link MagicType} - {@link Character} elemental
   *                          weakness
   */
  Player(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
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

  /** @return int - {@link Player} defense */
  public int getDefense() {
    return defense;
  }

  /** @param defense int - {@link Player} defense */
  public void setDefense(int defense) {
    this.defense = defense;
  }

  /** @return int - {@link Player} health points */
  public int getHealth() {
    return this.health;
  }

  /** @param value int - {@link Player} health points */
  public void setHealth(int value) {
    if (value <= this.maxHealth) {
      this.health = value;
    } else {
      this.health = this.maxHealth;
    }
  }

  /** @return {@link MagicType} - {@link Player} elemental weakness */
  public MagicType getElementalWeakness() {
    return elementalWeakness;
  }

  /** @param elementalWeakness {@link MagicType} - {@link Player} elemental weakness */
  public void setElementalWeakness(MagicType elementalWeakness) {
    this.elementalWeakness = elementalWeakness;
  }

  /** @return String - {@link Player} name */
  public String getName() {
    return name;
  }

  /** @param name String - {@link Player} new name */
  public void setName(String name) {
    this.name = name;
  }

  /** @return int - {@link Player} strength */
  public int getStrength() {
    return strength;
  }

  /** @param strength int - {@link Player} new strength */
  public void setStrength(int strength) {
    this.strength = strength;
  }

  /** @return int - {@link Player} dexterity */
  public int getDexterity() {
    return dexterity;
  }

  /** @param dexterity int - {@link Player} new dexterity */
  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  /** @return int - {@link Player} constitution */
  public int getConstitution() {
    return constitution;
  }

  /** @param constitution int - {@link Player} new constitution */
  public void setConstitution(int constitution) {
    this.constitution = constitution;
  }

  /** @return int - {@link Player} intelligence */
  public int getIntelligence() {
    return intelligence;
  }

  /** @param intelligence int - {@link Player} new intelligence */
  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  /** @return int - {@link Player} wisdom */
  public int getWisdom() {
    return wisdom;
  }

  /** @param wisdom int - {@link Player} new wisdom */
  public void setWisdom(int wisdom) {
    this.wisdom = wisdom;
  }

  /** @return int - {@link Player} charisma */
  public int getCharisma() {
    return charisma;
  }

  /** @param charisma int - {@link Player} new charisma */
  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  /** @return int - {@link Player} maximum health points */
  public int getMaxHealth() {
    return maxHealth;
  }

  /** @param maxHealth int - {@link Player} new maximum health points */
  public void setMaxHealth(int maxHealth) {
    this.maxHealth = maxHealth;
  }

  /** @return int - {@link Player} magical points */
  public int getMp() {
    return mp;
  }

  /** @param mp int - {@link Player} magical points */
  public void setMp(int mp) {
    this.mp = mp;
  }

  /** @return int - {@link Player} maximum magical points */
  public int getMaxMp() {
    return maxMp;
  }

  /** @param maxMp int - {@link Player} maximum magical points */
  public void setMaxMp(int maxMp) {
    this.maxMp = maxMp;
  }
}
