package io.github.bosifullstack.textAdventure.gameMechanic.levelSystem;

import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.levels.Level1;
import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.levels.Level2;
import io.github.bosifullstack.textAdventure.gameMechanic.levelSystem.levels.Level3;

/*LevelGenerator enables organisation of predefined levels*/
public class LevelGenerator {

    public Level generateLevelStructure(){
        //Levels to be used
        Level firstLevel = new Level1();
        Level secondLevel  = new Level2();
        Level thirdLevel  = new Level3();

        //associating levels with each other
        firstLevel.setLeftLevel(secondLevel);
        firstLevel.setForwardLevel(thirdLevel);

        secondLevel.setRightLevel(thirdLevel);

        thirdLevel.setLeftLevel(secondLevel);

        //should return first level of a game
        return firstLevel;
    }

}
