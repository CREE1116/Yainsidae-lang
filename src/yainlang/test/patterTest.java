package yainlang.test;

import java.util.regex.Pattern;

import yainlang.parser.Parser;

public class patterTest {

    public void Test(){
        Parser parser = new Parser();
        System.out.println(parser.parse("여러분들의 (변수이름/출력할 문자열)을 확실하게 만나고 확인하시게 될 것입니다 여러분!"));
        System.out.println(parser.parse("늬우스를 상영하겠습니다"));
        System.out.println(parser.parse("반동이다!"));
        System.out.println(parser.parse("(변수이름)을 오늘 단죄하러 왔다"));
        System.out.println(parser.parse("(boolean),을좀 가져다주시오"));
    }
    
    public static void main(String[] args) {
        patterTest test = new patterTest();
        test.Test();
    }
    
}
