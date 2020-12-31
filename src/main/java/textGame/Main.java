package textGame;

import characterCreation.CharacterSpreadsheet;

import static battleSystem.BattleSystem.battle;
import static characterCreation.CharacterCreation.createCharacter;

public class Main {
  public static void main(String[] args) {
    CharacterSpreadsheet player = createCharacter();
    battle(player);
  }
}
