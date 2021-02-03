package textGame.magicSystem;

import textGame.characterCreation.PlayerSpreadsheet;

public class AirMagic extends Magic {
  private static String[] namesArray = new String[] { "Air", "Aira", "Aiga" };
  private static int[] costsArray = new int[] { 5, 12, 30 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20 };

  public AirMagic(PlayerSpreadsheet character) {
    super(getMagicName(namesArray, character.getIntelligence()), getMagicCost(costsArray, character.getIntelligence()),
        getMagicImpact(impactBaseArray, character.getIntelligence()), MagicType.Air);
  }
}

