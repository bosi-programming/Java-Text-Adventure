package io.github.bosifullstack.textAdventure;

import io.github.bosifullstack.textAdventure.characterCreation.EnemySpreadsheet;
import io.github.bosifullstack.textAdventure.characterCreation.Player;
import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;
import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.Level;
import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.LevelGenerator;
import io.github.bosifullstack.textAdventure.util.io.Output;

import static io.github.bosifullstack.textAdventure.battleSystem.BattleSystem.battle;
import static io.github.bosifullstack.textAdventure.characterCreation.CharacterCreation.createCharacter;


import java.util.Scanner;

/**
 * Main file used to preview basic features of the framework
*/
public class Main {
  public static void main(String[] args) {

    //Please Note: features of CharacterCreation should be refactored in order to use new io mechanisms
    PlayerSpreadsheet player = createCharacter();
    Level firstLevel =  new LevelGenerator().generateLevelStructure();
    firstLevel.startLevel(player);

    /*
    PlayerSpreadsheet player = createCharacter();
    EnemySpreadsheet enemy = new EnemySpreadsheet();
    battle(player, enemy);*/

  }
}
