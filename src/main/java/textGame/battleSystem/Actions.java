package textGame.battleSystem;

import java.util.Random;

import textGame.characterCreation.Character;
import textGame.itemSystem.Weapon;
import textGame.magicSystem.MagicType;

public class Actions {
  static Random rand = new Random();

  public static int dealAttackDamage(int attackDamage) {
    return rand.nextInt(attackDamage);
  }

  public static int dealAttackDamage(int attackDamage, Weapon weapon, Character character) {
    return rand.nextInt(attackDamage) + weapon.getDamage() + (weapon.getElementalDamage() * typesRelation(weapon.getElementalType(), character.getElementalWeakness()));
  }

  private static int typesRelation(MagicType type1 , MagicType type2) {
    switch(type1) {
      case Fire: 
        if(type2 == MagicType.Earth) {
          return 2;
        } 
        return 1;
      case Water:
        if(type2 == MagicType.Fire) {
          return 2;
        } 
        return 1;
      case Air: 
        if(type2 == MagicType.Water) {
          return 2;
        } 
        return 1;
      case Earth:
        if(type2 == MagicType.Air) {
          return 2;
        } 
        return 1;
      default:
        return 1;
    }
  }
}
