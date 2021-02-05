package textGame;

import textGame.characterCreation.PlayerSpreadsheet;

import static textGame.battleSystem.BattleSystem.battle;
import static textGame.characterCreation.CharacterCreation.createCharacter;

import textGame.characterCreation.EnemySpreadsheet;

public class Main {
  public static void main(String[] args) {
    PlayerSpreadsheet player = createCharacter();
    EnemySpreadsheet enemy = new EnemySpreadsheet();
    battle(player, enemy);
  }
}
