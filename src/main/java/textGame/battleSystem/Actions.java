package textGame.battleSystem;

import java.util.Random;

import textGame.characterCreation.Character;
import textGame.itemSystem.Item;
import textGame.itemSystem.Weapon;
import textGame.magicSystem.Magic;
import textGame.magicSystem.MagicType;

public class Actions {
  static Random rand = new Random();

  public static void dealAttackDamage(int attackDamage, Character targetCharacter) {
    int physicalDamage = rand.nextInt(attackDamage) - targetCharacter.getDefense();
    targetCharacter.setHealth(targetCharacter.getHealth() - physicalDamage);
    PrintTables.printEffectText(targetCharacter, physicalDamage);
  }

  public static void dealAttackDamage(Weapon weapon, Character targetCharacter) {
    int physicalDamage = rand.nextInt(weapon.getDamage()) - targetCharacter.getDefense();
    int magicalDamage = weapon.getElementalDamage()
        * typesRelation(weapon.getElementalType(), targetCharacter.getElementalWeakness());
    int totalDamage = physicalDamage + magicalDamage;

    targetCharacter.setHealth(targetCharacter.getHealth() - totalDamage);
    PrintTables.printEffectText(targetCharacter, totalDamage);
  }

  public static void useMagic(Magic magic, Character targetCharacter) {
    int magicEffect = magic.getEffect() * typesRelation(magic.getType(), targetCharacter.getElementalWeakness());

    targetCharacter.setHealth(targetCharacter.getHealth() - magicEffect);
    PrintTables.printEffectText(targetCharacter, magicEffect);
  }

  public static void useItem(Item item, Character targetCharacter) {
    useMagic(item.getMagic(), targetCharacter);
  }


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
