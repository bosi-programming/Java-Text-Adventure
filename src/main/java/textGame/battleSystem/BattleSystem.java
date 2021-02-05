package textGame.battleSystem;

import java.util.Random;
import java.util.Scanner;

import textGame.characterCreation.EnemySpreadsheet;
import textGame.characterCreation.PlayerSpreadsheet;

public class BattleSystem {
  public static void battle(PlayerSpreadsheet player, EnemySpreadsheet enemy) {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    while (enemy.getHealth() > 0) {
      PrintTables.printActionsTable(player, enemy);
      String input = in.nextLine();
      if (input.equals(Integer.toString(PrintTables.getAttackActionBtn()))) {
        Actions.dealAttackDamage(player.getWeapon(), enemy);
        Actions.dealAttackDamage(enemy.getDamage(), player);
      } else if (PrintTables.getMagicActionBtn() != 0
          & input.equals(Integer.toString(PrintTables.getMagicActionBtn()))) {
        PrintTables.printMagicTable(player.getKnowMagics(), player, enemy);
        Actions.dealAttackDamage(enemy.getDamage(), player);
      } else if (PrintTables.getItemActionBtn() != 0 & input.equals(Integer.toString(PrintTables.getItemActionBtn()))) {
        PrintTables.printItemsTable(player.getItems(), player, enemy);
        Actions.dealAttackDamage(enemy.getDamage(), player);
      } else {
        System.out.println("Invalid command! You lost your turn!");
        Actions.dealAttackDamage(enemy.getDamage(), player);
      }

      if (player.getHealth() < 1) {
        System.out.println("You are too weak to continue");
        System.out.println("------ GAME OVER -----");
        System.exit(0);
      }
    }

    System.out.println("You have won this battle!");
    System.out.println("_____________________________________________");

    System.out.println("_____________________________________________");
    System.out.println(" # " + enemy.getName() + " was defeated! #");
    if (rand.nextInt(100) < enemy.getChanceToDrop()) {
      player.getItems().add(enemy.getItemToDrop());
    }
  }
}
