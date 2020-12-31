package textGame;

import characterCreation.PlayerSpreadsheet;

import static battleSystem.BattleSystem.battle;
import static characterCreation.CharacterCreation.createCharacter;

public class Main {
  public static void main(String[] args) {
    PlayerSpreadsheet player = createCharacter();
    battle(player);
  }
}
