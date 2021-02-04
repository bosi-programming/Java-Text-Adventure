package textGame.battleSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import textGame.characterCreation.Character;
import textGame.characterCreation.EnemySpreadsheet;
import textGame.characterCreation.PlayerSpreadsheet;
import textGame.itemSystem.Item;
import textGame.itemSystem.Weapon;
import textGame.magicSystem.Magic;
import textGame.magicSystem.MagicType;

// TODO:
// - Item use
// - Run
// - End of battle

public class Actions {
  private static int attackActionBtn = 1;
  private static int magicActionBtn = 0;
  private static int itemActionBtn = 0;
  private static int runActionBtn = 0;

  static Random rand = new Random();
  static Scanner in = new Scanner(System.in);

  public static void action(PlayerSpreadsheet player, EnemySpreadsheet enemy) {
    while (enemy.getHealth() > 0) {
      printActionsTable(player, enemy);
      String input = in.nextLine();
      if (input.equals(Integer.toString(attackActionBtn))) {
        dealAttackDamage(player.getWeapon(), enemy);
        dealAttackDamage(enemy.getDamage(), player);
        if (player.getHealth() < 1) {
          System.out.println("\t> You have taken too much damage, you are too weak to continue!");
          break;
        }
      } else if (magicActionBtn != 0 & input.equals(Integer.toString(magicActionBtn))) {
        printMagicTable(player.getKnowMagics(), player, enemy);
      }
    }
  }

  public static void dealAttackDamage(int attackDamage, Character targetCharacter) {
    int physicalDamage = rand.nextInt(attackDamage) - targetCharacter.getDefense();
    targetCharacter.setHealth(targetCharacter.getHealth() - physicalDamage);
    printEffectText(targetCharacter, physicalDamage);
  }

  public static void dealAttackDamage(Weapon weapon, Character targetCharacter) {
    int physicalDamage = rand.nextInt(weapon.getDamage()) - targetCharacter.getDefense();
    int magicalDamage = weapon.getElementalDamage()
        * typesRelation(weapon.getElementalType(), targetCharacter.getElementalWeakness());
    int totalDamage = physicalDamage + magicalDamage;

    targetCharacter.setHealth(targetCharacter.getHealth() - totalDamage);
    printEffectText(targetCharacter, totalDamage);
  }

  public static void useMagic(Magic magic, Character targetCharacter) {
    int magicEffect = magic.getEffect() * typesRelation(magic.getType(), targetCharacter.getElementalWeakness());

    targetCharacter.setHealth(targetCharacter.getHealth() - magicEffect);
    printEffectText(targetCharacter, magicEffect);
  }

  public static void useItem(Item item, Character targetCharacter) {
    useMagic(item.getMagic(), targetCharacter);
  }

  private static void printActionsTable(PlayerSpreadsheet mainCharacter, EnemySpreadsheet enemy) {
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
    tableNumber++;
    runActionBtn = tableNumber;
    System.out.println("\t" + runActionBtn + ". Run!");
  }

  private static void printEffectText(Character character, int effect) {
    if (effect > 0) {
      System.out.println("\t> " + character.getName() + "receives " + effect + " of damage.");
    } else {
      System.out.println("\t> " + character.getName() + "is cured of " + effect + " of damage.");
    }
  }

  private static void printMagicTable(ArrayList<Magic> magics, Character player, Character enemy) {
    int i = 0;
    for (Magic magic : magics) {
      i++;
      System.out.println("\t" + i + ". " + magic.getName());
    }
    System.out.println("\n\tWhat magic do you want to cast?");
    String input = in.nextLine();

    Magic choosenMagic = magics.get(Integer.parseInt(input) - 1);
    if (choosenMagic.getType() == MagicType.Cure) {
      useMagic(choosenMagic, player);
    } else {
      useMagic(choosenMagic, enemy);
    }
  }

  private static int typesRelation(MagicType type1, MagicType type2) {
    switch (type1) {
      case Fire:
        if (type2 == MagicType.Earth) {
          return 2;
        }
        return 1;
      case Water:
        if (type2 == MagicType.Fire) {
          return 2;
        }
        return 1;
      case Air:
        if (type2 == MagicType.Water) {
          return 2;
        }
        return 1;
      case Earth:
        if (type2 == MagicType.Air) {
          return 2;
        }
        return 1;
      default:
        return 1;
    }
  }
}
