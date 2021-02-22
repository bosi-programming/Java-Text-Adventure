package io.github.bosifullstack.textAdventure.battleSystem;

import java.util.Random;
import java.util.Scanner;

import io.github.bosifullstack.textAdventure.characterCreation.EnemySpreadsheet;
import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;

/** Class that starts a battle */
public class BattleSystem {

  //index=0->Red, index=1->Green, index=2->Yellow, index=3->Blue 
  private static String[] normal = {"\u001b[31m","\u001b[32m","\u001b[33m","\u001b[34m"};
  private static String[] bold = {"\u001b[31;1m","\u001b[32;1m","\u001b[33;1m","\u001b[34;1m"};
  private static String[] underline = {"\u001b[31;4m","\u001b[32;4m","\u001b[33;4m","\u001b[34;4m"};
  private static String[] reversed = {"\u001b[31;7m","\u001b[32;7m","\u001b[33;7m","\u001b[34;7m"};

  private static String reset = "\u001b[0m";


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
