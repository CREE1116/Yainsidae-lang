package yainlang.machine;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import yainlang.parser.Syntax;
import yainlang.var.Memory;
import yainlang.function.*;

public class Machine {
    ArrayList<Command> list;
    Memory memory;
    Cal cal;
    Bool bool;
    Print print;
    Scan scan;
    public Machine() {
        list = new ArrayList<Command>();
        memory = new Memory();
        cal = new Cal();
        bool = new Bool();
        print = new Print();
        scan = new Scan();
        
    }
    public void addCommand(Command command) {
        list.add(command);
    }
    public void run() {
        int index = 0;
      //  System.out.println(list);
        while(true){
            if(index > list.size()-1) break;
            if(!order(list.get(index))) break;
            index++;
       }
    }
    private boolean order(Command command){
        Syntax syntax = command.getSyntax();
        if(syntax == Syntax.Declar) return Declare(command);
        if(syntax == Syntax.Assign) return Assign(command);
        if(syntax == Syntax.print) return Print(command);
        // if(syntax == Syntax.scan) return Scan(command);
        // if(syntax == Syntax.loopStart) return LoopStart(command);
        // if(syntax == Syntax.loopEnd) return LoopEnd(command);
        // if(syntax == Syntax.if_) return If(command);
        // if(syntax == Syntax.elif) return Elif(command);
        // if(syntax == Syntax.else_) return Else(command);
        return false;
    }
    private boolean Declare(Command command) {
       // System.out.println("선언");
         switch (command.getVarName().get(0).split(":")[0]){
            case"고": this.memory.set(command.getVarName().get(0),"");
             return true;
            case"자": this.memory.set(command.getVarName().get(0),0);
             return true;
            case"라": this.memory.set(command.getVarName().get(0),true);
             return true;
            default: return false;
        }
    }
    private boolean Assign(Command command){
    //    System.out.println("대입");
      //System.out.println(command.getVarName().get(1));
         switch (command.getVarName().get(0).split(":")[0]){
            case "고": this.memory.set(command.getVarName().get(0),command.getVarName().get(1));
             return true;
            case"자": this.memory.set(command.getVarName().get(0),cal.stringCal(command.getVarName().get(1)));
             return true;
            case"라": this.memory.set(command.getVarName().get(0),Boolean.parseBoolean(command.getVarName().get(1)));
             return true;
            default: return false;
        }
    }
    private boolean Print(Command command){
        String varName = command.getVarName().get(0);
       if(isStringContent(varName)) {
           System.out.println(varName.substring(1,varName.length()-1));
           return true;
       }
       if(isVar(varName)) {
           System.out.println(this.memory.get(command.getVarName().get(0)).get());
           return true;
       }
        System.out.println(command.getVarName().get(0));
       return true;
    }

    private boolean isStringContent(String s){
        final Pattern stringPattern = Pattern.compile("\"[^\"]*\"", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = stringPattern.matcher(s);
        return matcher.matches();
    }
    private boolean isVar(String s){
       String simbol = s.substring(0, 1);
        if(simbol.equals("고")||simbol.equals("자")||simbol.equals("라")) return true;
        else return false;
    }
    
}
