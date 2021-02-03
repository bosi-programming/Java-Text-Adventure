package textGame;

import textGame.characterCreation.PlayerSpreadsheet;

import static textGame.battleSystem.BattleSystem.battle;
import static textGame.characterCreation.CharacterCreation.createCharacter;

public class Main {
  public static void main(String[] args) {
    PlayerSpreadsheet player = createCharacter();
    battle(player);
  }
}
