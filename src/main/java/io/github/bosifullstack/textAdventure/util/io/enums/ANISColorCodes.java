package io.github.bosifullstack.textAdventure.util.io.enums;

public enum ANISColorCodes {

    //Color codes
    BLACK("30"),
    RED("31"),
    GREEN("32"),
    YELLOW("33"),
    BLUE("34"),
    PURPLE("35"),
    CYAN("36"),
    WHITE("37"),

    //Background color codes
    BLACK_BACKGROUND("40"),
    RED_BACKGROUND("41"),
    GREEN_BACKGROUND("42"),
    YELLOW_BACKGROUND("43"),
    BLUE_BACKGROUND("44"),
    PURPLE_BACKGROUND("45"),
    CYAN_BACKGROUND("46"),
    WHITE_BACKGROUND("47");


    //TO-DO if needed more color codes can be added

    private final String ansiCode;

    private ANISColorCodes(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    public String getAnsiCode() {
        return ansiCode;
    }


}
