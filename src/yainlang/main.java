package yainlang;
import yainlang.Items;
import yainlang.machine.Machine;
import yainlang.parser.Parser;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class main extends Items {
public static Machine machine;
    public static void main(String[] args) throws IOException {
        TotalText = "";
        machine = new Machine();
//        Path path = Paths.get("./" + "test.umm");
//        Charset cs = StandardCharsets.UTF_8;
//        List<String> list = Files.readAllLines(path, cs);
//        list.forEach(main::first);

        String fileName = args[0];
        System.out.println(fileName.toLowerCase(Locale.ROOT));
        if (fileName.toLowerCase(Locale.ROOT).endsWith(".yain ")) throw new IOException("확장자가 일치하지 않습니다.");
        BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
        String readerString;
        while ((readerString = reader.readLine()) != null) first(readerString);
        reader.close();
        int startPos = TotalText.indexOf("친애하는 시민 동지 여러분") + 15;
        int endPos = TotalText.lastIndexOf("말도안된다고엏엏");
        TotalText = TotalText.substring(startPos, endPos);
 
        Parser parser = new Parser(machine);
//
        String[] lines = TotalText.split("\\n");

// 단순한 구문분석 출력
        for (String line : lines) {
        //    System.out.println(parser.parse(line));
        parser.parse(line);
        }
        machine.run();
    }
        

    private static void first(String line) {
        TotalText += (line + "\n");
    }
}