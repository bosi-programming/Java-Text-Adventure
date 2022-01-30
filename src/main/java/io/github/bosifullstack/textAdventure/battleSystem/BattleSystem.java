package io.github.bosifullstack.textAdventure.battleSystem;

import java.util.Random;
import java.util.Scanner;

import io.github.bosifullstack.textAdventure.characterCreation.EnemySpreadsheet;
import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.util.io.ScannerHelper;

import static io.github.bosifullstack.textAdventure.util.StringColor.reversed;
import static io.github.bosifullstack.textAdventure.util.StringColor.reset;
import static io.github.bosifullstack.textAdventure.util.StringColor.bold;

/** Class that starts a battle */
public class BattleSystem {

  public static void battle(PlayerSpreadsheet player, EnemySpreadsheet enemy) {
    Scanner in = ScannerHelper.getInstance().getScanner();
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
        System.out.println(reversed[2]+"Invalid command! You lost your turn!"+reset);
        Actions.dealAttackDamage(enemy.getDamage(), player);
      }

      if (player.getHealth() < 1) {
        System.out.println(bold[3]+"You are too weak to continue");
        System.out.println("------ GAME OVER -----"+reset);
        System.exit(0);
      }
    }

    System.out.println(bold[0]+"You have won this battle!");
    System.out.println("_____________________________________________");

    System.out.println("_____________________________________________");
    System.out.println(" # " + enemy.getName() + " was defeated! #"+reset);
    if (rand.nextInt(100) < enemy.getChanceToDrop()) {
      player.getItems().add(enemy.getItemToDrop());
    }
  }
}
