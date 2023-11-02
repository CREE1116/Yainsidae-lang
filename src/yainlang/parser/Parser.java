package yainlang.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import yainlang.machine.Command;
import yainlang.machine.Machine;

public class Parser {
    Machine machine;
    public Parser( Machine machine){
        this.machine = machine;
    }
    //지금은 테스트 단계이므로 함수를 실행하지 않고 이름만 출력합니다.
    //추후 enum에 할당된 기능을 수행하도록 할것
     public String parse(String line) {
        for(Syntax syntax : Syntax.values()) {
            Matcher matcher = syntax.getRE().matcher(line);
            if(matcher.matches()) {
                machine.addCommand(new Command(syntax, getVar(line)));
                return syntax.name()+", getVar: "+Arr2String(getVar(line));
            }
        }
        return "error";
     }
     private ArrayList<String> getVar(String line){
            ArrayList<String> output = new ArrayList<String>();
            Pattern pattern = Syntax.var.getRE();
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()){
                output.add(matcher.group());
            }
            return output;
     }
     private String Arr2String(ArrayList<String> arr){
        String out = "";
            for(int i = 0; i< arr.size(); i++){
                out = out+arr.get(i);    
            }
            return out;
     }

}
