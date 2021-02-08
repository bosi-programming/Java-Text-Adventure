package io.github.bosifullstack.textAdventure.characterCreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import io.github.bosifullstack.textAdventure.itemSystem.Item;
import io.github.bosifullstack.textAdventure.magicSystem.CureMagic;
import io.github.bosifullstack.textAdventure.magicSystem.FireMagic;
import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.WaterMagic;

/**
 * {@link Character} creation class used to create a new character according to
 * user's choices
 */

public class CharacterCreation {
  /** Static class that start the CLI interface to create new player */
  public static PlayerSpreadsheet createCharacter() {
    PlayerSpreadsheet player = new PlayerSpreadsheet();

    Scanner in = new Scanner(System.in);

    System.out.println("Welcome to Java Text Game!");
    System.out.println("_____________________________________________");
    System.out.println("Now we'll create your character");

    System.out.println("Write the name of your character:");
    String name = in.nextLine();
    System.out.println("Your character name is: " + name);
    player.setName(name);
    System.out.println("_____________________________________________");

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
    System.out.println("Your character race is: " + race);
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
    System.out.println("Your character class is: " + className);

  }
}
