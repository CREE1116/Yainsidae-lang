package yainlang;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
public class main extends Items {

    public static void main(String[] args) throws IOException {
        TotalText = "";

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
        int startPos = TotalText.indexOf("친애하는 시민 동지 여러분") + 14;
        int endPos = TotalText.lastIndexOf("말도안된다고엏엏");
        TotalText = TotalText.substring(startPos, endPos);
 
//        Print print = new Print();
//        Scan scan = new Scan();
//        VarGet varGet = new VarGet();
//        VarSet varSet = new VarSet();
//
        String[] lines = TotalText.split("\\n");
        int i= 0;
        for (String line : lines) {
        	System.out.print(i+":		");
        	System.out.println(line);
        	i++;
        }
            
//            if (print.check(line)) print.print(line);
//            else if (scan.check(line)) scan.scanner(line);
//            else if (varGet.check(line)) varGet.get(line);
//            else if (varSet.check(line)) varSet.set(line);
//        }
        
    }
        

    private static void first(String line) {
        TotalText += (line + "\n");
    }
}