package io.github.bosifullstack.textAdventure.magicSystem;

/**
 * Enum with all the {@link Magic} types of the system
 */
public enum MagicType {
  Cure("Cure"), Fire("Fire"), Water("Water"), Air("Air"), Earth("Earth"), Incolor("Incolor");

  public final String type;

  private MagicType(String type) {
    this.type = type;
  }
}
