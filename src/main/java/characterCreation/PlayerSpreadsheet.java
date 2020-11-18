package characterCreation;

public class PlayerSpreadsheet {
  private String name;
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  public PlayerSpreadsheet() {
    this.name = "Jorisvaldo";
    this.strength = 10;
    this.dexterity = 10;
    this.constitution = 10;
    this.intelligence = 10;
    this.wisdom = 10;
    this.charisma = 10;
  }

  public PlayerSpreadsheet(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom,
      int charisma) {
    this.name = name;
    this.strength = strength;
    this.dexterity = dexterity;
    this.constitution = constitution;
    this.intelligence = intelligence;
    this.wisdom = wisdom;
    this.charisma = charisma;
  }

  public String getName() {
    return name;
  }
  public int getStrength() {
    return strength;
  }
  public int getDexterity() {
    return dexterity;
  }
  public int getConstitution() {
    return constitution;
  }
  public int getIntelligence() {
    return intelligence;
  }
  public int getWisdom() {
    return wisdom;
  }
  public int getCharisma() {
    return charisma;
  }
}
