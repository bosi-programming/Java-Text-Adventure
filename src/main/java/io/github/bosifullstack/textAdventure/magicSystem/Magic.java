package io.github.bosifullstack.textAdventure.magicSystem;

/**
 * Class used to extend new magics for the Magic System
 */
public abstract class Magic {
  private String name;
  private int cost;
  private int effect;
  private MagicType type;

  /**
   * @param name   String - Name of the magic
   * @param cost   int - Cost of the magic in magical points(MP)
   * @param impact int - Damage or cure impact of the magic
   * @param type   {@link MagicType} - Magic type of the magic
   */
  public Magic(String name, int cost, int impact, MagicType type) {
    this.name = name;
    this.cost = cost;
    this.type = type;
    this.effect = impact;
  }

  /**
   * Used to calculate the level or circle of the magic based on the power of the
   * user.
   * 
   * @param mainAttribute int - Main attribute linked to the magic
   * @return int - A number between 0 to 2
   */
  public static int calculateMagicCircle(int mainAttribute) {
    if (mainAttribute > 20) {
      return 2;
    } else if (mainAttribute > 14) {
      return 1;
    } else {
      return 0;
    }
  }

  /**
   * Get the correct magic name based on its circle/level.
   * 
   * @param namesArray    String[] - an array of possible names organized by its
   *                      circle - {@link calculateMagicCircle}
   * @param mainAttribute int - User/player attribute linked to the magic
   * @return String - final name of the magic
   */
  public static String getMagicName(String[] namesArray, int mainAttribute) {
    return namesArray[calculateMagicCircle(mainAttribute)];
  }

  /**
   * Get the mp cost of the magic
   * 
   * @param costsArray    int[] - an array of mp costs based on the circle of the
   *                      magic - {@link calculateMagicCircle}
   * @param mainAttribute int - User/player attribute linked to the magic
   * @return int - final cost of the magic
   */
  public static int getMagicCost(int[] costsArray, int mainAttribute) {
    return costsArray[calculateMagicCircle(mainAttribute)];
  }

  /**
   * Get the mp cost of the magic
   * 
   * @param impactBaseArray    int[] - an array of impacts based on the circle of the
   *                      magic - {@link calculateMagicCircle}
   * @param mainAttribute int - User/player attribute linked to the magic
   * @return int - final impact of the magic
   */
  public static int getMagicImpact(int[] impactBaseArray, int mainAttribute) {
    return impactBaseArray[calculateMagicCircle(mainAttribute)] * mainAttribute / 2;
  }

  /**
   * @return String name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name - String - New name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return int
   */
  public int getCost() {
    return cost;
  }

  /**
   * @param cost int - new cost
   */
  public void setCost(int cost) {
    this.cost = cost;
  }

  /**
   * @return {@link MagicType}
   */
  public MagicType getType() {
    return type;
  }

  /**
   * @return int
   */
  public int getEffect() {
    return effect;
  }

  /**
   * @param effect int - new effect
   */
  public void setEffect(int effect) {
    this.effect = effect;
  }
}
