package io.github.bosifullstack.textAdventure.magicSystem;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;

/**
 * Water magic
 */
public class WaterMagic extends Magic {
  private static String[] namesArray = new String[] { "Water", "Watera", "Watega" };
  private static int[] costsArray = new int[] { 5, 12, 30 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20 };

  /**
   * Creates a water {@link Magic} using the {@link PlayerSpreadsheet}
   */
  public WaterMagic(PlayerSpreadsheet character) {
    super(getMagicName(namesArray, character.getIntelligence()), getMagicCost(costsArray, character.getIntelligence()),
        getMagicImpact(impactBaseArray, character.getIntelligence()), MagicType.Water);
  }

  /**
   * Creates a water {@link Magic} using the creator wisdom. Mainly used to create items
   */
  public WaterMagic(int creatorIntelligence) {
    super(getMagicName(namesArray, creatorIntelligence), 0, getMagicImpact(impactBaseArray, creatorIntelligence), MagicType.Cure);
  }
}
