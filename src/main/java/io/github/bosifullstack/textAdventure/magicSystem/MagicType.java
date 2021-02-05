package textAdventure.magicSystem;

public enum MagicType {
  Cure("Cure"), Fire("Fire"), Water("Water"), Air("Air"), Earth("Earth"), Incolor("Incolor");

  public final String type;

  private MagicType(String type) {
    this.type = type;
  }
}
