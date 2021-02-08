package io.github.bosifullstack.textAdventure.itemSystem;

import io.github.bosifullstack.textAdventure.magicSystem.Magic;

/**
 * Item class
 */
public class Item {
  private String name;
  private int buyPrice;
  private int sellPrice;
  private Magic magic;

  /**
   * Creates a non-magical item
   * 
   * @param name      String - Name of the item
   * @param buyPrice  int - Price to buy the item
   * @param sellPrice int - Price to sell the item
   */
  public Item(String name, int buyPrice, int sellPrice) {
    this.name = name;
    this.buyPrice = buyPrice;
    this.sellPrice = sellPrice;
  }

  /**
   * Creates a magical item
   * 
   * @param name      String - Name of the item
   * @param buyPrice  int - Price to buy the item
   * @param sellPrice int - Price to sell the item
   * @param magic     {@link Magic} - magic attached to the item
   */
  public Item(String name, int buyPrice, int sellPrice, Magic magic) {
    this.name = name;
    this.buyPrice = buyPrice;
    this.sellPrice = sellPrice;
    this.magic = magic;
  }

  /** @return String - name */
  public String getName() {
    return name;
  }

  /** @param name String */
  public void setName(String name) {
    this.name = name;
  }

  /** @return int - buyPrice */
  public int getBuyPrice() {
    return buyPrice;
  }

  /** @param buyPrice int - Price to buy the item */
  public void setBuyPrice(int buyPrice) {
    this.buyPrice = buyPrice;
  }

  /** @return int */
  public int getSellPrice() {
    return sellPrice;
  }

  /** @param sellPrice int - price to sell the item */
  public void setSellPrice(int sellPrice) {
    this.sellPrice = sellPrice;
  }

  /** @return magic {@link Magic} - magic attached to the item */
  public Magic getMagic() {
    return magic;
  }

  /** @param magic {@link Magic} - magic attached to the item */
  public void setMagic(Magic magic) {
    this.magic = magic;
  }
}
