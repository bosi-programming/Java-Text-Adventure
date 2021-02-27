package io.github.bosifullstack.textAdventure.characterCreation;

import java.util.ArrayList;

import io.github.bosifullstack.textAdventure.itemSystem.Armor;
import io.github.bosifullstack.textAdventure.itemSystem.ArmorType;
import io.github.bosifullstack.textAdventure.itemSystem.Item;
import io.github.bosifullstack.textAdventure.itemSystem.Weapon;
import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

/**
 * Creates a player spreadsheet necessary for the playeable {@link Character} to
 * exist.
 */
public class PlayerSpreadsheet extends Character {

  //index=0->Red, index=1->Green, index=2->Yellow, index=3->Blue 
  private static String[] normal = {"\u001b[31m","\u001b[32m","\u001b[33m","\u001b[34m"};
  private static String[] bold = {"\u001b[31;1m","\u001b[32;1m","\u001b[33;1m","\u001b[34;1m"};
  private static String[] underline = {"\u001b[31;4m","\u001b[32;4m","\u001b[33;4m","\u001b[34;4m"};
  private static String[] reversed = {"\u001b[31;7m","\u001b[32;7m","\u001b[33;7m","\u001b[34;7m"};

  private static String reset = "\u001b[0m";

  private String race;
  private String className;

  private Weapon weapon;
  private Armor armor;
  private Armor shield;

  private ArrayList<Magic> knowMagics = new ArrayList<Magic>();
  private ArrayList<Item> items = new ArrayList<Item>();

  /** Creates a basic default player */
  public PlayerSpreadsheet() {
    super();
    this.race = "human";
    this.className = "warrior";
  }

  /**
   * Creates a {@link PlayerSpreadsheet}
   *
   * @param name              String - Name of the character
   * @param race              String - Race of the character
   * @param className         String - Class of the character
   * @param strength          int - {@link Character} strength
   * @param dexterity         int - {@link Character} dexterity
   * @param constitution      int - {@link Character} constitution
   * @param intelligence      int - {@link Character} intelligence
   * @param wisdom            int - {@link Character} wisdom
   * @param charisma          int - {@link Character} charisma
   * @param magics            {@link ArrayList} of {@link Magic} - List of all
   *                          magics that this player knows
   * @param items             {@link ArrayList} of {@link Item} - List of all of the
   *                          player's items
   * @param elementalWeakness {@link MagicType} - {@link Character} elemental
   */
  public PlayerSpreadsheet(String name, String race, String className, int strength, int dexterity, int constitution,
      int intelligence, int wisdom, int charisma, ArrayList<Magic> magics, ArrayList<Item> items,
      MagicType elementalWeakness) {
    super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, elementalWeakness);
    this.race = race;
    this.className = className;

    this.knowMagics = magics;
    this.items = items;
  }

  /**
   * @return {@link ArrayList} of {@link Item} - {@link ArrayList} with all of the
   *         player's {@link Item}
   */
  public ArrayList<Item> getItems() {
    return items;
  }

  /**
   * @param items {@link ArrayList} of {@link Item} - A list of items that the
   *              player will have - Override current items list
   */
  public void setItems(ArrayList<Item> items) {
    this.items = items;
  }

  /** @return String - Player race */
  public String getRace() {
    return race;
  }

  /** @param race - String - New player race */
  public void setRace(String race) {
    this.race = race;
  }

  /** @return String - Player class */
  public String getClassName() {
    return className;
  }

  /** @param className String - New player class */
  public void setClassName(String className) {
    this.className = className;
  }

  /**
   * Sets a new armor based on {@link ArmorType}
   * 
   * @param armor {@link Armor} - New armor to be equiped
   */
  public void setArmorOrShield(Armor armor) {
    if (armor.getType() == ArmorType.Armor) {
      this.armor = armor;
      this.setDefense(this.getDefense() + armor.getDefense());
    } else if (armor.getType() == ArmorType.Shield) {
      this.shield = armor;
      this.setDefense(this.getDefense() + shield.getDefense());
    } else {
      System.out.println(bold[2]+"Error on setting a new armor"+reset);
    }
  }

  /** @return int - Armor defense value */
  public int getArmorValue() {
    return armor.getDefense() + shield.getDefense();
  }

  /** @return {@link Armor} - Get Armor that has {@link ArmorType} of Armor */
  public Armor getArmor() {
    return armor;
  }

  /** @return {@link Armor} - Get Armor that has {@link ArmorType} of Shield */
  public Armor getShield() {
    return shield;
  }

  /** @return {@link Weapon} - Player equiped weapon */
  public Weapon getWeapon() {
    return weapon;
  }

  /** @param weapon {@link Weapon} - Player new weapon */
  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  /** @return {@link ArrayList} of {@link Magic} - Player's known magics */
  public ArrayList<Magic> getKnowMagics() {
    return knowMagics;
  }

  /**
   * @param knowMagics {@link ArrayList} of {@link Magic} - New player's known
   *                   magics
   */
  public void setKnowMagics(ArrayList<Magic> knowMagics) {
    this.knowMagics = knowMagics;
  }

  /** @param magic {@link Magic} - Add a new magic to the list of know magics */
  public void addKnowMagics(Magic magic) {
    this.knowMagics.add(magic);
  }

  /** @return boolean - answer if the player know a certain magic */
  public boolean knowCertainMagic(Magic magic) {
    return this.knowMagics.contains(magic);
  }
}
