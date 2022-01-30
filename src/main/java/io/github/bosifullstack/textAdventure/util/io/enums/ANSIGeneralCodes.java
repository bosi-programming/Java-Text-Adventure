package io.github.bosifullstack.textAdventure.util.io.enums;

public enum ANSIGeneralCodes {

    //General codes
    DEFAULT("0"),
    BOLD("1"),
    UNDERLINE("4");


    //TO-DO if needed more color codes can be added

    private final String ansiCode;

    private ANSIGeneralCodes(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    public String getAnsiCode() {
        return ansiCode;
    }

}
