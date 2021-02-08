package io.github.bosifullstack.textAdventure.magicSystem;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;

/**
 * Creates air magic
 */
public class AirMagic extends Magic {
  private static String[] namesArray = new String[] { "Air", "Aira", "Aiga" };
  private static int[] costsArray = new int[] { 5, 12, 30 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20 };

  /**
   * Creates a air {@link Magic} using the {@link PlayerSpreadsheet}
   * @param character {@link PlayerSpreadsheet}
   */
  public AirMagic(PlayerSpreadsheet character) {
    super(getMagicName(namesArray, character.getIntelligence()), getMagicCost(costsArray, character.getIntelligence()),
        getMagicImpact(impactBaseArray, character.getIntelligence()), MagicType.Air);
  }

  /**
   * Creates a air {@link Magic} using the creator wisdom. Mainly used to create items
   * @param creatorIntelligence int
   */
  public AirMagic(int creatorIntelligence) {
    super(getMagicName(namesArray, creatorIntelligence), 0, getMagicImpact(impactBaseArray, creatorIntelligence), MagicType.Cure);
  }
}
