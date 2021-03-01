package io.github.bosifullstack.textAdventure.util;

public class StringColor {
  // index=0->Red, index=1->Green, index=2->Yellow, index=3->Blue
  public static String[] normal = { "\u001b[31m", "\u001b[32m", "\u001b[33m", "\u001b[34m" };
  public static String[] bold = { "\u001b[31;1m", "\u001b[32;1m", "\u001b[33;1m", "\u001b[34;1m" };
  public static String[] underline = { "\u001b[31;4m", "\u001b[32;4m", "\u001b[33;4m", "\u001b[34;4m" };
  public static String[] reversed = { "\u001b[31;7m", "\u001b[32;7m", "\u001b[33;7m", "\u001b[34;7m" };

  public static String reset = "\u001b[0m";
}
