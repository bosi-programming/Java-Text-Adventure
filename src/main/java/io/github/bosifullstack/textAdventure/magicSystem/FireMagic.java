package io.github.bosifullstack.textAdventure.magicSystem;

import io.github.bosifullstack.textAdventure.characterCreation.PlayerSpreadsheet;

/**
 * Creates fire {@link Magic}
 */
public class FireMagic extends Magic {
  private static String[] namesArray = new String[] { "Fire", "Fira", "Firaga" };
  private static int[] costsArray = new int[] { 5, 12, 30 };
  private static int[] impactBaseArray = new int[] { 5, 10, 20 };

  /**
   * Creates a fire {@link Magic} using the {@link PlayerSpreadsheet}
   * @param character {@link PlayerSpreadsheet}
   */
  public FireMagic(PlayerSpreadsheet character) {
    super(getMagicName(namesArray, character.getIntelligence()), getMagicCost(costsArray, character.getIntelligence()),
        getMagicImpact(impactBaseArray, character.getIntelligence()), MagicType.Fire);
  }

  /**
   * Creates a fire {@link Magic} using the creator wisdom. Mainly used to create
   * items
   * @param creatorIntelligence int
   */
  public FireMagic(int creatorIntelligence) {
    super(getMagicName(namesArray, creatorIntelligence), 0, getMagicImpact(impactBaseArray, creatorIntelligence),
        MagicType.Cure);
  }
}
