package io.github.bosifullstack.textAdventure.magicSystem;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;

/**
 * Creates earth magic
 */
public class EarthMagic extends Magic {
  private static String[] namesArray = new String[] { "Earth", "Earthra", "Earthga" };
  private static int[] costsArray = new int[] { 5, 12, 30 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20 };

  /**
   * Creates a water {@link Magic} using the {@link PlayerSpreadsheet}
   */
  public EarthMagic(PlayerSpreadsheet character) {
    super(getMagicName(namesArray, character.getIntelligence()), getMagicCost(costsArray, character.getIntelligence()),
        getMagicImpact(impactBaseArray, character.getIntelligence()), MagicType.Earth);
  }

  /**
   * Creates a earth {@link Magic} using the creator wisdom. Mainly used to create
   * items
   */
  public EarthMagic(int creatorIntelligence) {
    super(getMagicName(namesArray, creatorIntelligence), 0, getMagicImpact(impactBaseArray, creatorIntelligence),
        MagicType.Cure);
  }
}
