package io.github.bosifullstack.textAdventure.util.io;

import java.util.ArrayList;
import java.util.List;


/* Output class enables creation of TextNodes in order to achieve clean way of manipulating outputted text and its color and styles.
* Usage example:
*    Output output = new Output();
*    output.createTextNode("Username: ").setTextColorRed().setUnderline();
*    output.createTextNode("Name").setTextColorGreen().setBold();
*    output.print();
*
*
* */
public class Output {

    public Output(){
        super();
    }

    public Output(boolean newLine){
        super();
        if(newLine){
            createLineBreak();
        }
    }

    private List<TextNode> textStorage = new ArrayList<>();

    public void createLineBreak(){
        TextNode tn = new TextNode ();
        textStorage.add(tn);

    }


    public TextNode createTextNode(String text){
        TextNode tn = new TextNode (text);
        textStorage.add(tn);
        return tn;
    }

    public void print(){
        for(TextNode to : textStorage){
            System.out.print(to.getFinalText());
        }
        textStorage.clear();

    }

}
