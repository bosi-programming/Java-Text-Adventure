package textGame.battleSystem;

import java.util.Random;

public class Enemy {
  private String name;
  private int health;
  private int maxHealth;
  private int attackDamage;
  private int healthPotionDropChance;
  Random rand = new Random();

  public Enemy() {
    this.name = "Jorjinho";
    this.maxHealth = 75;
    this.health = rand.nextInt(this.maxHealth);
    this.attackDamage = 25;
    this.healthPotionDropChance = 50;
  }

  public Enemy(String name) {
    this();
    this.name = name;
  }

  public Enemy(String name, int maxHealth, int attackDamage, int healthPotionDropChance) {
    this.name = name;
    this.maxHealth = maxHealth;
    this.health = rand.nextInt(this.maxHealth);
    this.attackDamage = attackDamage;
    this.healthPotionDropChance = healthPotionDropChance;
  }

  public String getName() {
    return this.name;
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

  public int dealDamage() {
    return rand.nextInt(this.attackDamage);
  }

  public int receiveDamage(int damage) {
    this.setHealth(this.health - damage);
    return this.health;
  }

  public int getHealthPotionDropChance() {
    return healthPotionDropChance;
  }

}
