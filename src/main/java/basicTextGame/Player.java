package basicTextGame;

import java.util.Random;

public class Player {
  private int health;
  private int maxHealth;
  private int attackDamage;
  private int numHealthPots;
  Random rand = new Random();

  public Player() {
    this.health = 100;
    this.maxHealth = 100;
    this.attackDamage = 50;
    this.numHealthPots = 3;
  }
  public Player(int health, int attackDamage, int numHealthPots) {
    this.health = health;
    this.maxHealth = health;
    this.attackDamage = attackDamage;
    this.numHealthPots = numHealthPots;
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
    return rand.nextInt(this.attackDamage);
  }
  public int receiveDamage(int damage) {
    this.setHealth(this.health - damage);
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
