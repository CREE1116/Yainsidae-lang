package yainlang.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public void run() {
        
    }
    //지금은 테스트 단계이므로 함수를 실행하지 않고 이름만 출력합니다.
    //추후 enum에 할당된 기능을 수행하도록 할것
     public String parse(String line) {
        for(Syntax syntax : Syntax.values()) {
            Matcher matcher = syntax.getRE().matcher(line);
            if(matcher.matches()) {
                return syntax.name();
            }
        }
        return "error";
     }

}
