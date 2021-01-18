package textGame.characterCreation;

public class EnemySpreadsheet {
  private String name;
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  private int chanceToDrop;
  private String item;

  public EnemySpreadsheet() {
    this.strength = 10;
    this.dexterity = 10;
    this.constitution = 10;
    this.intelligence = 10;
    this.wisdom = 10;
    this.charisma = 10;
    this.chanceToDrop = 25;
    this.item = "potion";
  }

  public EnemySpreadsheet(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom,
      int charisma, int chanceToDrop, String item) {
    this.name = name;
    this.strength = strength;
    this.dexterity = dexterity;
    this.constitution = constitution;
    this.intelligence = intelligence;
    this.wisdom = wisdom;
    this.charisma = charisma;
    this.chanceToDrop = chanceToDrop;
    this.item = item;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  public int getConstitution() {
    return constitution;
  }

  public void setConstitution(int constitution) {
    this.constitution = constitution;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  public int getWisdom() {
    return wisdom;
  }

  public void setWisdom(int wisdom) {
    this.wisdom = wisdom;
  }

  public int getCharisma() {
    return charisma;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  public int getChanceToDrop() {
    return chanceToDrop;
  }

  public void setChanceToDrop(int chanceToDrop) {
    this.chanceToDrop = chanceToDrop;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + chanceToDrop;
    result = prime * result + charisma;
    result = prime * result + constitution;
    result = prime * result + dexterity;
    result = prime * result + intelligence;
    result = prime * result + ((item == null) ? 0 : item.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + strength;
    result = prime * result + wisdom;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EnemySpreadsheet other = (EnemySpreadsheet) obj;
    if (chanceToDrop != other.chanceToDrop)
      return false;
    if (charisma != other.charisma)
      return false;
    if (constitution != other.constitution)
      return false;
    if (dexterity != other.dexterity)
      return false;
    if (intelligence != other.intelligence)
      return false;
    if (item == null) {
      if (other.item != null)
        return false;
    } else if (!item.equals(other.item))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (strength != other.strength)
      return false;
    if (wisdom != other.wisdom)
      return false;
    return true;
  }
}
