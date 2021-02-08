package io.github.bosifullstack.textAdventure.battleSystem;

import java.util.ArrayList;
import java.util.Scanner;

import io.github.bosifullstack.textAdventure.characterCreation.Character;
import io.github.bosifullstack.textAdventure.characterCreation.EnemySpreadsheet;
import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.itemSystem.Item;
import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

/** Class that prints any battle choice */
public class PrintTables {
  private static int attackActionBtn = 1;
  private static int magicActionBtn = 0;
  private static int itemActionBtn = 0;

  static Scanner in = new Scanner(System.in);

  /**
   * Print that table of choices that the player has in the start of a battle
   * 
   * @param mainCharacter {@link PlayerSpreadsheet}
   * @param enemy         {@link EnemySpreadsheet}
   */
  public static void printActionsTable(PlayerSpreadsheet mainCharacter, EnemySpreadsheet enemy) {
    int tableNumber = 1;
    System.out.println("\tYour HP: " + mainCharacter.getHealth());
    System.out.println("\t" + enemy.getName() + "'s HP: " + enemy.getHealth());
    System.out.println("\n\tWhat would you like to do?");
    System.out.println("\t" + attackActionBtn + ". Attack");
    if (mainCharacter.getKnowMagics().size() > 0) {
      tableNumber++;
      magicActionBtn = tableNumber;
      System.out.println("\t" + magicActionBtn + ". Use magic");
    }
    if (mainCharacter.getItems().size() > 0) {
      tableNumber++;
      itemActionBtn = tableNumber;
      System.out.println("\t" + itemActionBtn + ". Use item");
    }
  }

  /**
   * Print text related to a damage or cure effect
   * 
   * @param character {@link Character} - Character that will receive the effect
   * @param effect    int - total value of the effect
   */
  public static void printEffectText(Character character, int effect) {
    if (effect >= 0) {
      System.out.println("\t> " + character.getName() + " receives " + effect + " of damage.");
    } else {
      System.out.println("\t> " + character.getName() + " is cured of " + -effect + " of damage.");
    }
  }

  /**
   * Print a table with the magic choices
   *
   * @param magics {@link ArrayList} of {@link Magic} - List of known magics
   * @param player {@link Character} - The one that will use the magic
   * @param enemy  {@link Character} - Possible receiver of a magic
   */
  public static void printMagicTable(ArrayList<Magic> magics, Character player, Character enemy) {
    int i = 0;
    for (Magic magic : magics) {
      i++;
      System.out.println("\t" + i + ". " + magic.getName());
    }
    System.out.println("\n\tWhat magic do you want to cast?");
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
  public static void printItemsTable(ArrayList<Item> items, Character player, Character enemy) {
    int i = 0;
    for (Item item : items) {
      i++;
      System.out.println("\t" + i + ". " + item.getName());
    }
    System.out.println("\n\tWhat magic do you want to cast?");
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
