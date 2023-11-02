package yainlang.machine;

import java.util.ArrayList;

import yainlang.parser.Syntax;

public class Command {
    Syntax syntax;
    ArrayList<String> varName;
    
    public Command(Syntax syntax, ArrayList<String> varName){
        this.syntax = syntax;
        this.varName = varName;
        removeBracket();
    }
    public String toString(){
        return syntax.name()+""+varName;
    }
    public Syntax getSyntax(){
        return syntax;
    }
    public ArrayList<String> getVarName(){
        return varName;
    }
    private void removeBracket(){
        for(int i = 0; i<varName.size(); i++){
            varName.set(i, varName.get(i).substring(1, varName.get(i).length()-1));
        }
    }

}
