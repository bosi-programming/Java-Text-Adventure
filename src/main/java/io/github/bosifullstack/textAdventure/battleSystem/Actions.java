package io.github.bosifullstack.textAdventure.battleSystem;

import java.util.Random;

import io.github.bosifullstack.textAdventure.characterCreation.Player;
import io.github.bosifullstack.textAdventure.itemSystem.Item;
import io.github.bosifullstack.textAdventure.itemSystem.Weapon;
import io.github.bosifullstack.textAdventure.magicSystem.Magic;
import io.github.bosifullstack.textAdventure.magicSystem.MagicType;

/** Class with all possible actions that can be taken on a fight */
public class Actions {
  static Random rand = new Random();

  /**
   * Deal damage - Used by those without a weapon
   * 
   * @param attackDamage    int - physical damage
   * @param targetCharacter {@link Character} - Character that will take the
   *                        damage
   */
  public static void dealAttackDamage(int attackDamage, Player targetCharacter) {
    int physicalDamage = rand.nextInt(attackDamage) - targetCharacter.getDefense();
    targetCharacter.setHealth(targetCharacter.getHealth() - physicalDamage);
    PrintTables.printEffectText(targetCharacter, physicalDamage);
  }

  /**
   * Deal damage - Used by players with weapons
   * 
   * @param weapon          {@link Weapon} - Weapon used by the player
   * @param targetCharacter {@link Character} - Character that will take the
   *                        attack
   */
  public static void dealAttackDamage(Weapon weapon, Player targetCharacter) {
    int physicalDamage = rand.nextInt(weapon.getDamage()) - targetCharacter.getDefense();
    int magicalDamage = weapon.getElementalDamage()
        * typesRelation(weapon.getElementalType(), targetCharacter.getElementalWeakness());
    int totalDamage = physicalDamage + magicalDamage;

    targetCharacter.setHealth(targetCharacter.getHealth() - totalDamage);
    PrintTables.printEffectText(targetCharacter, totalDamage);
  }

  /**
   * Use a magic known by a character
   * 
   * @param magic           {@link Magic} - Magic to be used
   * @param targetCharacter {@link Character} - Character that will take the magic
   */
  public static void useMagic(Magic magic, Player targetCharacter) {
    int magicEffect = magic.getEffect() * typesRelation(magic.getType(), targetCharacter.getElementalWeakness());

    targetCharacter.setHealth(targetCharacter.getHealth() - magicEffect);
    PrintTables.printEffectText(targetCharacter, magicEffect);
  }

  /**
   * Use an {@link Item}
   * 
   * @param item            {@link Item} - Item to be used
   * @param targetCharacter {@link Character} - Character that will use the item
   */
  public static void useItem(Item item, Player targetCharacter) {
    useMagic(item.getMagic(), targetCharacter);
  }

  /**
   * Calculate relation between types of {@link Magic}
   *
   * @param type1 {@link MagicType} - Magic type that we want to know how much
   *              it'll affect
   * @param type2 {@link MagicType} - Element that we want to calculate if it is a
   *              weekness or not to type1
   * @return int - Multiplier between 1 and 2
   */
  private static int typesRelation(MagicType type1, MagicType type2) {
    switch (type1) {
      case Fire:
        if (type2 == MagicType.Earth) {
          return 2;
        }
        return 1;
      case Water:
        if (type2 == MagicType.Fire) {
          return 2;
        }
        return 1;
      case Air:
        if (type2 == MagicType.Water) {
          return 2;
        }
        return 1;
      case Earth:
        if (type2 == MagicType.Air) {
          return 2;
        }
        return 1;
      default:
        return 1;
    }
  }
}
