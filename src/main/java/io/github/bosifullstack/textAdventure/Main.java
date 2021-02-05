package textAdventure;

import textAdventure.characterCreation.PlayerSpreadsheet;

import static textAdventure.battleSystem.BattleSystem.battle;
import static textAdventure.characterCreation.CharacterCreation.createCharacter;

import textAdventure.characterCreation.EnemySpreadsheet;

public class Main {
  public static void main(String[] args) {
    PlayerSpreadsheet player = createCharacter();
    EnemySpreadsheet enemy = new EnemySpreadsheet();
    battle(player, enemy);
  }
}
