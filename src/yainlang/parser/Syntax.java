package yainlang.parser;

import java.util.regex.Pattern;

public enum Syntax {
    print("여러분들의 \\[[^\\]]*\\]을 확실하게 만나고 확인하시게 될 것입니다 여러분!"),
    scan("\\[[^\\]]*\\]을 오늘 단죄하러 왔다"),
    loopStart("늬우스를 상영하겠습니다"),
    loopEnd("반동이다!"),
    if_("\\[[^\\]]*\\],을좀 가져다주시오"),
    else_("없어요"),
    elif("어\\.\\.\\[[^\\]]*\\]는 몸에 안좋으니까"),
    var("\\[[^\\]]*\\]"),
    Declar("\\[[^\\]]*\\] 동무를 소개합니다!"),
    Assign("\\[[^\\]]*\\]은 바로 \\[[^\\]]*\\]을 말하는것입니다 여러분!");

    private Pattern RE;
    Syntax (String RE) {
        this.RE = Pattern.compile(RE, Pattern.CASE_INSENSITIVE);
        ;
    }
    public Pattern getRE() {
        return RE;
    }
}
