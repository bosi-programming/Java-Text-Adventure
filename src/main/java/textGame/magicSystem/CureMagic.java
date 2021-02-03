package textGame.magicSystem;

import textGame.characterCreation.PlayerSpreadsheet;

public class CureMagic extends Magic {
  private static String[] namesArray = new String[] { "Cure", "Cura", "Curaga" };
  private static int[] costsArray = new int[] { 4, 10, 20 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20};

  public CureMagic(PlayerSpreadsheet character) {
    super(getMagicName(namesArray, character.getWisdom()), getMagicCost(costsArray, character.getWisdom()), getMagicImpact(impactBaseArray, character.getWisdom()), MagicType.Cure);
  }

  public CureMagic(int creatorWisdom) {
    super(getMagicName(namesArray, creatorWisdom), 0, getMagicImpact(impactBaseArray, creatorWisdom), MagicType.Cure);
  }
}
