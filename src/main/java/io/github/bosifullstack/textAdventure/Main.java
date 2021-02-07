package io.github.bosifullstack.textAdventure;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;

import static io.github.bosifullstack.textAdventure.battleSystem.BattleSystem.battle;
import static io.github.bosifullstack.textAdventure.characterCreation.CharacterCreation.createCharacter;

import io.github.bosifullstack.textAdventure.characterCreation.EnemySpreadsheet;

/**
 * Main file used to preview basic features of the framework
*/
public class Main {
  public static void main(String[] args) {
    PlayerSpreadsheet player = createCharacter();
    EnemySpreadsheet enemy = new EnemySpreadsheet();
    battle(player, enemy);
  }
}
