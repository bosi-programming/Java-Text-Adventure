package io.github.bosifullstack.textAdventure.characterCreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import io.github.bosifullstack.textAdventure.itemSystem.Item;
import io.github.bosifullstack.textAdventure.magicSystem.CureMagic;
import io.github.bosifullstack.textAdventure.magicSystem.FireMagic;
import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.WaterMagic;
import io.github.bosifullstack.textAdventure.util.io.ScannerHelper;

/**
 * {@link Character} creation class used to create a new character according to
 * user's choices
 */

public class CharacterCreation {
  //index=0->Red, index=1->Green, index=2->Yellow, index=3->Blue 
  private static String[] normal = {"\u001b[31m","\u001b[32m","\u001b[33m","\u001b[34m"};
  private static String[] bold = {"\u001b[31;1m","\u001b[32;1m","\u001b[33;1m","\u001b[34;1m"};
  private static String[] underline = {"\u001b[31;4m","\u001b[32;4m","\u001b[33;4m","\u001b[34;4m"};
  private static String[] reversed = {"\u001b[31;7m","\u001b[32;7m","\u001b[33;7m","\u001b[34;7m"};

  private static String reset = "\u001b[0m";


  /** Static class that start the CLI interface to create new player */
  public static PlayerSpreadsheet createCharacter() {
    PlayerSpreadsheet player = new PlayerSpreadsheet();

    Scanner in = ScannerHelper.getInstance().getScanner();

    System.out.println(bold[2]+"Welcome to Java Text Game!");
    System.out.println("_____________________________________________"+reset);
    System.out.println(reversed[1]+"Now we'll create your character"+reset);

    System.out.println("Write the name of your character:");
    String name = in.nextLine();
    System.out.println(bold[2]+"Your character name is: " + name+reset);
    player.setName(name);
    System.out.println(bold[2]+"_____________________________________________"+reset);

    chooseRace(player, in);
    chooseClass(player, in);

    ArrayList<Item> initialItems = new ArrayList<Item>();
    Item potion = new Item("potion", 50, 25, new CureMagic(12));
    Item[] initialPotions = new Item[] { potion, potion, potion };
    initialItems.addAll(Arrays.asList(initialPotions));
    player.setItems(initialItems);

    return player;
  }

  /**
   * Creates a CLI interface to let the user choose a race and apply it to the
   * {@link PlayerSpreadsheet}
   */
  private static void chooseRace(PlayerSpreadsheet player, Scanner in) {
    System.out.println("Write the name of your race (human, elf, hobbit, halfling or orc)");

    String race = in.nextLine().toLowerCase();

    if (race.equals("human")) {
      player.setIntelligence(player.getIntelligence() + 2);
    } else if (race.equals("elf")) {
      player.setWisdom(player.getWisdom() + 2);
      player.setDexterity(player.getDexterity() + 2);
      player.setConstitution(player.getConstitution() - 2);
    } else if (race.equals("hobbit") | race.equals("halfling")) {
      player.setDexterity(player.getDexterity() + 2);
      player.setConstitution(player.getConstitution() + 2);
      player.setCharisma(player.getCharisma() - 2);
    } else if (race.equals("orc")) {
      player.setStrength(player.getStrength() + 2);
    }
    System.out.println(bold[0]+"Your character race is: " + race+reset);
  }

  /**
   * Creates a CLI interface to let the user choose a class and apply it to the
   * {@link PlayerSpreadsheet}
   */
  private static void chooseClass(PlayerSpreadsheet player, Scanner in) {
    System.out.println("Write the name of your class (warrior, mage, cleric or druid)");

    String className = in.nextLine().toLowerCase();

    if (className.equals("warrior") | className.equals("fighter")) {
      player.setStrength(player.getStrength() + 2);
      player.setConstitution(player.getConstitution() + 2);
    } else if (className.equals("mage") | className.equals("wizard") | className.equals("sorcerer")) {
      player.setIntelligence(player.getIntelligence() + 2);
      player.setConstitution(player.getConstitution() - 2);

      ArrayList<Magic> knowMagics = new ArrayList<Magic>();
      knowMagics.add(new FireMagic(player));
      knowMagics.add(new WaterMagic(player));
      knowMagics.add(new CureMagic(player));
      player.setKnowMagics(knowMagics);
    } else if (className.equals("cleric") | className.equals("druid")) {
      player.setWisdom(player.getWisdom() + 2);
      player.setDexterity(player.getDexterity() + 2);

      ArrayList<Magic> knowMagics = new ArrayList<Magic>();
      knowMagics.add(new CureMagic(player));
      player.setKnowMagics(knowMagics);
    }
    System.out.println(bold[3]+"Your character class is: " + className+reset);

  }
}
