package textGame;

import textGame.characterCreation.CharacterSpreadsheet;

import static textGame.battleSystem.BattleSystem.battle;
import static textGame.characterCreation.CharacterCreation.createCharacter;

public class Main {
  public static void main(String[] args) {
    CharacterSpreadsheet player = createCharacter();
    battle(player);
  }
}
