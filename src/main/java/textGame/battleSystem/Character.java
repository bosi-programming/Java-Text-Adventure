package textGame.battleSystem;

import java.util.Random;

import textGame.characterCreation.PlayerSpreadsheet;

public class Character {
  private int attackDamage;
  private int numHealthPots;
  private int weaponDamage;
  private int elementalDamage;
  private int armorDefense;
  Random rand = new Random();

  public Character() {
    this.attackDamage = 50;
    this.numHealthPots = 3;
    this.weaponDamage = 0;
    this.armorDefense = 0;
  }

  public Character(PlayerSpreadsheet playerSpreadsheet) {
    this.attackDamage = playerSpreadsheet.getStrength() * 5;
    this.numHealthPots = playerSpreadsheet.getNumHealthPots();
    if (playerSpreadsheet.getWeapon() != null) {
      this.weaponDamage = playerSpreadsheet.getWeapon().getDamage();
      this.elementalDamage = playerSpreadsheet.getWeapon().getElementalDamage();
    }
    if (playerSpreadsheet.getArmor() != null) {
      this.armorDefense += playerSpreadsheet.getArmor().getDefense();
    }
    if(playerSpreadsheet.getShield() != null) {
      this.armorDefense += playerSpreadsheet.getShield().getDefense();
    }
  }

  public Character(int health, int attackDamage, int numHealthPots) {
    this.attackDamage = attackDamage;
    this.numHealthPots = numHealthPots;
    this.weaponDamage = 0;
    this.armorDefense = 0;
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
    return rand.nextInt(this.attackDamage) + this.weaponDamage + this.elementalDamage;
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
