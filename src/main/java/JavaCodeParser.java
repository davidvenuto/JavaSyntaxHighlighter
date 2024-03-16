import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import java.nio.file.Path;
import java.nio.file.Paths;

// IMPORTS ^^^^^^^^^^^^^

public class JavaCodeParser {

    String filePath = "projectpath.java";

    JavaParser javaParser = new JavaParser();
    Path path = Paths.get(filePath);

    public void parseCode(String filePath) {
        JavaParser javaParser = new JavaParser();
        Path path = Paths.get(filePath);

        try {
            ParseResult<CompilationUnit> result = javaParser.parse(path);
            result.ifSuccessful(compilationUnit -> {
                System.out.println(compilationUnit);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
