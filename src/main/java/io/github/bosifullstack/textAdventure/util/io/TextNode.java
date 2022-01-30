package io.github.bosifullstack.textAdventure.util.io;

import io.github.bosifullstack.textAdventure.util.io.enums.ANISColorCodes;
import io.github.bosifullstack.textAdventure.util.io.enums.ANSIGeneralCodes;
import java.util.ArrayList;
import java.util.List;

/* TextNode is class which serves for enabling easier way to style text
* */

public class TextNode {

    //default constructor is used for line break
    public TextNode(){
        super();
        this.tempText = "\n";
        formatTextForAnsi();

    }

    public TextNode(String text){
        super();
        this.tempText = text;
        formatTextForAnsi();

    }

    private static final String ANSI_STYLE_DEF_START = "\033[";
    private List<String> ansiStyleDefGroup = new ArrayList();
    private static final String ANSI_STYLE_DEF_END = "m";
    private static final String ANSI_STYLE_REVERSE ="\033[0m";
    private String tempText;
    private String finalText;


    public String getFinalText() {
        return finalText;
    }

    private void setFinalText(String finalText) {
        this.finalText = finalText;
    }


    public TextNode setBold(){
        ansiStyleDefGroup.add(ANSIGeneralCodes.BOLD.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setUnderline(){
        ansiStyleDefGroup.add(ANSIGeneralCodes.UNDERLINE.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorBlack(){
        ansiStyleDefGroup.add(ANISColorCodes.BLACK.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorRed(){
        ansiStyleDefGroup.add(ANISColorCodes.RED.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorGreen(){
        ansiStyleDefGroup.add(ANISColorCodes.GREEN.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorYellow(){
        ansiStyleDefGroup.add(ANISColorCodes.YELLOW.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorBlue(){
        ansiStyleDefGroup.add(ANISColorCodes.BLUE.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorPurple(){
        ansiStyleDefGroup.add(ANISColorCodes.PURPLE.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorCyan(){
        ansiStyleDefGroup.add(ANISColorCodes.CYAN.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setTextColorWhite(){
        ansiStyleDefGroup.add(ANISColorCodes.WHITE.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorBlack(){
        ansiStyleDefGroup.add(ANISColorCodes.BLACK_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorRed(){
        ansiStyleDefGroup.add(ANISColorCodes.RED_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorGreen(){
        ansiStyleDefGroup.add(ANISColorCodes.GREEN_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorYellow(){
        ansiStyleDefGroup.add(ANISColorCodes.YELLOW_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorBlue(){
        ansiStyleDefGroup.add(ANISColorCodes.BLUE_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorPurple(){
        ansiStyleDefGroup.add(ANISColorCodes.PURPLE_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorCyan(){
        ansiStyleDefGroup.add(ANISColorCodes.CYAN_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    public TextNode setBackgroundColorWhite(){
        ansiStyleDefGroup.add(ANISColorCodes.WHITE_BACKGROUND.getAnsiCode());
        return formatTextForAnsi();
    }

    private TextNode formatTextForAnsi(){
        if(ansiStyleDefGroup.isEmpty()){
            this.setFinalText(this.tempText);
        }else{
            StringBuilder sb = new StringBuilder();

            sb.append(this.ANSI_STYLE_DEF_START);

            for(String s : ansiStyleDefGroup){
                if(ansiStyleDefGroup.indexOf(s) > 0){
                    sb.append(";");
                }
                sb.append(s.trim());

            }
            sb.append(this.ANSI_STYLE_DEF_END);

            sb.append(tempText);

            sb.append(ANSI_STYLE_REVERSE);

            this.setFinalText(sb.toString());
        }

        return this;
    }


}
