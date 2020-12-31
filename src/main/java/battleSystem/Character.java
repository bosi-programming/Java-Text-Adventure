package battleSystem;

import java.util.Random;

import characterCreation.CharacterSpreadsheet;

public class Character {
  private int health;
  private int maxHealth;
  private int attackDamage;
  private int numHealthPots;
  private int weaponDamage;
  private int armorDefense;
  Random rand = new Random();

  public Character() {
    this.health = 100;
    this.maxHealth = 100;
    this.attackDamage = 50;
    this.numHealthPots = 3;
    this.weaponDamage = 0;
    this.armorDefense = 0;
  }

  public Character(CharacterSpreadsheet playerSpreadsheet) {
    this.health = playerSpreadsheet.getConstitution() * 10;
    this.maxHealth = playerSpreadsheet.getConstitution() * 10;
    this.attackDamage = playerSpreadsheet.getStrength() * 5;
    this.numHealthPots = playerSpreadsheet.getNumHealthPots();
    this.weaponDamage = playerSpreadsheet.getWeaponDamage();
    this.armorDefense = playerSpreadsheet.getArmorDefense();
  }

  public Character(int health, int attackDamage, int numHealthPots) {
    this.health = health;
    this.maxHealth = health;
    this.attackDamage = attackDamage;
    this.numHealthPots = numHealthPots;
    this.weaponDamage = 0;
    this.armorDefense = 0;
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

  public void setHealthPotions(int value) {
    this.numHealthPots += value;
    if (value == 1) {
      System.out.println("# You have found a potion");
      System.out.println("# You have found a potion");
    } else {
      System.out.println("# You have found " + value + " potions");
    }
    System.out.println(" # You now have " + this.numHealthPots + " health potion(s). #");
  }

  public int dealDamage() {
    return rand.nextInt(this.attackDamage) + this.weaponDamage;
  }

  public int receiveDamage(int damage) {
    int newLife = this.health - damage + this.armorDefense;
    if (newLife < this.health) {
      this.setHealth(newLife);
    }
    return this.health;
  }

  public void drinkPotion(int cure) {
    if (this.numHealthPots > 0) {
      this.setHealth(this.health + cure);
      this.numHealthPots--;
      System.out.println("\t> You drink a health potion, healing yourself for " + cure + "." + "\n\t> You have now "
          + this.health + " HP." + "\n\t> You have " + this.numHealthPots + " health potions left.\n");
    } else {
      System.out.println("You have no health potions");
    }
  }
}
