package io.github.bosifullstack.textAdventure.itemSystem;

/** Enum with all the {@link Armor} types of the system */
public enum ArmorType {
  Shield("Shield"), Armor("Armor");

  public final String type;

  private ArmorType(String type) {
    this.type = type;
  }
}
