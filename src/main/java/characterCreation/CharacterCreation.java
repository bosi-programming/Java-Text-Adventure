package characterCreation;

import java.util.Scanner;

public class CharacterCreation {
  public static CharacterSpreadsheet createCharacter() {
    CharacterSpreadsheet player = new CharacterSpreadsheet();

    Scanner in = new Scanner(System.in);

    System.out.println("Welcome to Java Text Game!");
    System.out.println("_____________________________________________");
    System.out.println("Now we'll create your character");

    System.out.println("Write the name of your character:");
    String name = in.nextLine();
    System.out.println("Your character name is: " + name);
    System.out.println("_____________________________________________");

    chooseRace(player, in);
    chooseClass(player, in);

    return player;
  }

  private static void chooseRace(CharacterSpreadsheet player, Scanner in) {
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

  private static void chooseClass(CharacterSpreadsheet player, Scanner in) {
    System.out.println("Write the name of your class (warrior, mage, cleric or druid)");

    String className = in.nextLine().toLowerCase();

    if (className.equals("warrior") | className.equals("fighter")) {
      player.setStrength(player.getStrength() + 2);
      player.setConstitution(player.getConstitution() + 2);
    } else if (className.equals("mage") | className.equals("wizard") | className.equals("sorcerer")) {
      player.setIntelligence(player.getIntelligence() + 2);
      player.setConstitution(player.getConstitution() - 2);
    } else if (className.equals("cleric") | className.equals("druid")) {
      player.setWisdom(player.getWisdom() + 2);
      player.setDexterity(player.getDexterity() + 2);
    }
    System.out.println("Your character class is: " + className);

  }
}
