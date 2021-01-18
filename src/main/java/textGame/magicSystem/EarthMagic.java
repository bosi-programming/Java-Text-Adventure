package textGame.magicSystem;

import textGame.characterCreation.CharacterSpreadsheet;

public class EarthMagic extends Magic {
  private static String[] namesArray = new String[] { "Earth", "Earthra", "Earthga" };
  private static int[] costsArray = new int[] { 5, 12, 30 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20 };

  public EarthMagic(CharacterSpreadsheet character) {
    super(getMagicName(namesArray, character.getIntelligence()), getMagicCost(costsArray, character.getIntelligence()),
        getMagicImpact(impactBaseArray, character.getIntelligence()), MagicType.Earth);
  }
}

