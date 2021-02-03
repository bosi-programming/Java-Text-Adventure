package textGame.magicSystem;

public class Magic {
  private String name;
  private int cost;
  private int effect;
  private MagicType type;

  public Magic(String name, int cost, int impact, MagicType type) {
    this.name = name;
    this.cost = cost;
    this.type = type;
    this.effect = impact;
  }

  public static int calculateMagicCircle(int mainAttribute) {
    if (mainAttribute > 20) {
      return 2;
    } else if (mainAttribute > 14) {
      return 1;
    } else {
      return 0;
    }
  }

  public static String getMagicName(String[] namesArray, int mainAttribute) {
    return namesArray[calculateMagicCircle(mainAttribute)];
  }

  public static int getMagicCost(int[] costsArray, int mainAttribute) {
    return costsArray[calculateMagicCircle(mainAttribute)];
  }

  public static int getMagicImpact(int[] impactBaseArray, int mainAttribute) {
    return impactBaseArray[calculateMagicCircle(mainAttribute)] * mainAttribute / 2;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public MagicType getType() {
    return type;
  }

  public int getEffect() {
    return effect;
  }

  public void setEffect(int effect) {
    this.effect = effect;
  }
}
