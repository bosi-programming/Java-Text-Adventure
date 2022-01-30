package io.github.bosifullstack.textAdventure.battleSystem;

import java.util.ArrayList;
import java.util.Scanner;


import io.github.bosifullstack.textAdventure.characterCreation.EnemySpreadsheet;
import io.github.bosifullstack.textAdventure.characterCreation.Player;
import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.itemSystem.Item;
import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

/** Class that prints any battle choice */
public class PrintTables {
  private static int attackActionBtn = 1;
  private static int magicActionBtn = 0;
  private static int itemActionBtn = 0;

  //index=0->Red, index=1->Green, index=2->Yellow, index=3->Blue 
  private static String[] normal = {"\u001b[31m","\u001b[32m","\u001b[33m","\u001b[34m"};
  private static String[] bold = {"\u001b[31;1m","\u001b[32;1m","\u001b[33;1m","\u001b[34;1m"};
  private static String[] underline = {"\u001b[31;4m","\u001b[32;4m","\u001b[33;4m","\u001b[34;4m"};
  private static String[] reversed = {"\u001b[31;7m","\u001b[32;7m","\u001b[33;7m","\u001b[34;7m"};

  private static String reset = "\u001b[0m";

  static Scanner in = new Scanner(System.in);

  /**
   * Print that table of choices that the player has in the start of a battle
   * 
   * @param mainCharacter {@link PlayerSpreadsheet}
   * @param enemy         {@link EnemySpreadsheet}
   */
  public static void printActionsTable(PlayerSpreadsheet mainCharacter, EnemySpreadsheet enemy) {
    int tableNumber = 1;
    System.out.println("\t"+reversed[0]+"Your HP: " + mainCharacter.getHealth()+reset);
    System.out.println("\t"+reversed[3] + enemy.getName() + "'s HP: " + enemy.getHealth()+reset);
    System.out.println("\n\t"+normal[2]+"What would you like to do?"+reset);
    System.out.println("\t"+normal[1] + attackActionBtn + ". Attack"+reset);
    if (mainCharacter.getKnowMagics().size() > 0) {
      tableNumber++;
      magicActionBtn = tableNumber;
      System.out.println("\t"+normal[1] + magicActionBtn + ". Use magic"+reset);
    }
    if (mainCharacter.getItems().size() > 0) {
      tableNumber++;
      itemActionBtn = tableNumber;
      System.out.println("\t"+normal[1] + itemActionBtn + ". Use item"+reset);
    }
  }

  /**
   * Print text related to a damage or cure effect
   * 
   * @param character {@link Character} - Character that will receive the effect
   * @param effect    int - total value of the effect
   */
  public static void printEffectText(Player character, int effect) {
    if (effect >= 0) {
      System.out.println("\t> "+bold[0] + character.getName() + " receives " + effect + " of damage."+reset);
    } else {
      System.out.println("\t> "+underline[0] + character.getName() + " is cured of " + -effect + " of damage."+reset);
    }
  }

  /**
   * Print a table with the magic choices
   *
   * @param magics {@link ArrayList} of {@link Magic} - List of known magics
   * @param player {@link Character} - The one that will use the magic
   * @param enemy  {@link Character} - Possible receiver of a magic
   */
  public static void printMagicTable(ArrayList<Magic> magics, Player player, Player enemy) {
    int i = 0;
    for (Magic magic : magics) {
      i++;
      System.out.println("\t"+normal[1] + i + ". " + magic.getName()+reset);
    }
    System.out.println("\n\t"+normal[2]+"What magic do you want to cast?"+reset);
    String input = in.nextLine();

    Magic choosenMagic = magics.get(Integer.parseInt(input) - 1);
    if (choosenMagic.getType() == MagicType.Cure) {
      Actions.useMagic(choosenMagic, player);
    } else {
      Actions.useMagic(choosenMagic, enemy);
    }
  }

  /**
   * Print a table with the items choice
   *
   * @param items  {@link ArrayList} of {@link Item} - List of all items that the
   *               player has
   * @param player {@link Character} - The one that will use the magic
   * @param enemy  {@link Character} - Possible receiver of a magic
   */
  public static void printItemsTable(ArrayList<Item> items, Player player, Player enemy) {
    int i = 0;
    for (Item item : items) {
      i++;
      System.out.println("\t"+normal[1] + i + ". " + item.getName()+reset);
    }
    System.out.println("\n\t"+normal[2]+"What magic do you want to cast?"+reset);
    String input = in.nextLine();

    Item choosenItem = items.get(Integer.parseInt(input) - 1);
    if (choosenItem.getMagic().getType() == MagicType.Cure) {
      Actions.useItem(choosenItem, player);
    } else {
      Actions.useItem(choosenItem, enemy);
    }
    items.remove(Integer.parseInt(input) - 1);
  }

  /** @return int - Button related to the attack action */
  public static int getAttackActionBtn() {
    return attackActionBtn;
  }

  /** @return int - Button related to the item action */
  public static int getItemActionBtn() {
    return itemActionBtn;
  }

  /** @return int - Button related to the magic action */
  public static int getMagicActionBtn() {
    return magicActionBtn;
  }

}
