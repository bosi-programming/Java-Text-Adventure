package characterCreation;

import java.util.Scanner;

public class CharacterCreation {
  public static PlayerSpreadsheet createCharacter() {
    int strength = 10;
    int dexterity = 10;
    int constitution = 10;
    int intelligence = 10;
    int wisdom = 10;
    int charisma = 10;

    Scanner in = new Scanner(System.in);

    System.out.println("Welcome to Java Text Game!");
    System.out.println("_____________________________________________");
    System.out.println("Now we'll create your character");

    System.out.println("Write the name of your character:");
    String name = in.nextLine();
    System.out.println("Your character name is: " + name);
    System.out.println("_____________________________________________");

    System.out.println("Write the name of your race");
    String race = in.nextLine();
    if (race.equals("human")) {
      intelligence += 2;
    } else if (race.equals("elf")) {
      wisdom += 2;
      dexterity += 2;
      constitution -= 2;
    } else if (race.equals("hobbit") | race.equals("halfling")) {
      dexterity += 2;
      constitution += 2;
      charisma -= 2;
    } else if (race.equals("orc")) {
      strength += 2;
    }
    System.out.println("Your character race is: " + race);

    System.out.println("Write the name of your class");
    String className = in.nextLine();
    if (className.equals("warrior") | className.equals("fighter")) {
      strength += 2;
      constitution += 2;
    } else if (className.equals("mage") | className.equals("wizard") | className.equals("sorcerer")) {
      intelligence += 2;
      constitution -= 2;
    } else if (className.equals("cleric") | className.equals("druid")) {
      wisdom += 2;
      dexterity -= 2;
    }
    System.out.println("Your character class is: " + className);

    PlayerSpreadsheet player = new PlayerSpreadsheet(name, race, className, strength, dexterity, constitution,
        intelligence, wisdom, charisma);

    return player;
  }
}
