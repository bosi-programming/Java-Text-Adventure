package textGame.magicSystem;

import textGame.characterCreation.CharacterSpreadsheet;

public class WaterMagic extends Magic {
  private static String[] namesArray = new String[] { "Water", "Watera", "Watega" };
  private static int[] costsArray = new int[] { 5, 12, 30 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20 };

  public WaterMagic(CharacterSpreadsheet character) {
    super(getMagicName(namesArray, character.getIntelligence()), getMagicCost(costsArray, character.getIntelligence()),
        getMagicImpact(impactBaseArray, character.getIntelligence()), MagicType.Water);
  }
}

